package in.MyProject.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.MyProject.model.Admin;
import in.MyProject.model.Books;
import in.MyProject.model.Student;
import in.MyProject.model.Transaction;
import in.MyProject.service.IAdminService;
import in.MyProject.service.IBookService;
import in.MyProject.service.IStudentService;
import in.MyProject.service.ITransactionService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired(required = true)
	private IAdminService adminService;
	@Autowired(required = true)
	private IBookService bookService;
	@Autowired(required = true)
	private ITransactionService transactionService;
	@Autowired(required = true)	
	private IStudentService studentService;
	
	private static final Integer pageSize=8;
	private String name;
	private String staffId;
	private String message = "";

	// Module is Complete.
	@GetMapping("/login")
	public String loginPage(Map<String, Object> model) {
		return "Au_AdminLogin";
	}

	// Module is Complete.
	@PostMapping("/dashboard")
	public String studentDashboard(@RequestParam("staffId") String id, @RequestParam("password") String pswd,
			Map<String, Object> model) {
		/*
		 * System.out.println("ID :: "+id); System.out.println("PASSWORD :: "+pswd);
		 */
		Admin admin = adminService.findAdmin(id);
		/* System.out.println(admin); */
		if (admin != null && admin.getPassword().equals(pswd)) {
			name = admin.getName();
			staffId =id;
			System.out.println(name);
			model.put("admin", name);
			staffId = id;
			return "Au_adminHome";
		} else {
			return "redirect:/admin/login";
		}
	}

	// Module is Complete.
	@GetMapping("/add")
	public String searchBook(Map<String, Object> model) {
		Books book = new Books();
		model.put("admin", name);
		model.put("book", book);
		return "Au_addBook";
	}

	// Module is Complete.
	@PostMapping("/adding")
	public String studentDashboard(@ModelAttribute("book") Books book, Map<String, Object> model) {
		model.put("admin", name);
		System.out.println("book : " + book);

		message = bookService.addNewBook(book);
		if (message.equalsIgnoreCase("done")) {
			model.put("message", "Book is Added in database");
		} else {
			model.put("message", "Sorry not able to add book in Database");
		}
		return "Au_commonOutput";
	}

	// Module is Complete.
	@GetMapping("/home")
	public String homePage(Map<String, Object> model) {
		model.put("admin", name);
		return "Au_admin_dashboard";
	}


	// Module (Anchor tag param pending pending)
	@GetMapping("/bookList")
	public String listBook(@RequestParam(value = "pageNo",required=false) Integer pageNo, Map<String, Object> model) {
		model.put("admin", name);
		if (pageNo == null) {
			pageNo=1;
		}
		Integer totalPages = bookService.getTotalPages(pageSize);
		List<Books> list = bookService.findAllAndPegination(pageNo, pageSize);
		model.put("list", list);
		model.put("pageNo",pageNo );
		model.put("pagesCount", totalPages);
		return "Au_listBookAdmin";
	}

	@GetMapping("/pending")
	public String pendingRequest(Map<String, Object> model) {
		model.put("admin", name);
		List<Transaction> list = transactionService.getAllTransactionByStatus("pending");
		model.put("list", list);
		return "Au_requestPending";
	}

	@GetMapping("/process")
	public String processRequest(@RequestParam("parameter") String parameter, Map<String, Object> model) {
		model.put("admin", name);
		Transaction transaction = transactionService.getTransaction(parameter);
	if (parameter!=null) {
		transaction.setReturnDate(LocalDate.now().plusDays(15));
		transaction.setStatus("Approved");
		transaction.setStaffId(staffId);
		transactionService.updateTransaction(transaction);
		return "redirect:/admin/borrower";
	} else {
		model.put("message", "Approval failled, try again.");
		return "Au_commonOutput";
	}
	}
	
	@GetMapping("/borrower")
	public String borrowerList(Map<String, Object> model) {
		model.put("admin", name);
		List<Transaction> list = transactionService.getAllTransactionByStatus("Approved");
		model.put("list", list);
		return "Au_borrowerList";
	}

	// Module is Complete.
	@GetMapping("/delete")
	public String deleteTransaction(@RequestParam("parameter") String parameter, Map<String, Object> model) {
		model.put("admin", name);
		String message="";
		if (parameter!=null) {
			Transaction transaction = transactionService.getTransaction(parameter);
			Period period = Period.between( transaction.getReturnDate(),LocalDate.now());
			int days = period.getDays();
			System.out.println(days);
			if (transaction != null) {
				Books book = bookService.findUsingId(transaction.getIsbn());
				List<String> bookList = book.getTransactionId();
				bookList.remove(bookList.indexOf(parameter));
				book.setTransactionId(bookList);
				book.setAvailable(book.getAvailable()+1);
				book.setBorrowed(book.getBorrowed()-1);
				bookService.updateBook(book);
				
				Student student = studentService.getStudent(transaction.getLibraryId());
				List<String> studentList = student.getTrancationId();
				studentList.remove(studentList.indexOf(parameter));
				student.setTrancationId(studentList);
				if (days>0) {
					student.setFine(student.getFine()+(days*10));
				}
				studentService.saveStudent(student);
			}
			transactionService.deleteTransaction(parameter);
			message=message+"Transaction Id :: "+parameter +" for Student :: "+ transaction.getLibraryId()+" with ISBN :: "+transaction.getIsbn() +" is deleted.";
			model.put("message",message );
		}
		return "Au_commonOutput";
	}
	
	// Module is Complete.
	@GetMapping("/update")
	public String bookUpdate(Map<String, Object> model) {
		model.put("admin", name);
		return "Au_searchBookAdmin";
	}

	// Module is Complete.
	@GetMapping("/updating")
	public String bookUpdating(@RequestParam("parameter") String parameter, @RequestParam("type") String type,
			Map<String, Object> model) {
		model.put("admin", name);
		Books book = new Books();
		if (type.equalsIgnoreCase("title")) {
			book = bookService.findUsingTitle(parameter);
		} else {
			//List<Books> list = bookService.findTitleList(parameter);
			book = bookService.findUsingId(Long.parseLong(parameter));
		}
		if (book != null) {
			model.put("book", book);
		} else {
			model.put("message", "No book is available with :: " + parameter + " parameter.");
		}
		return "Au_bookUpdate";
	}

	// Module is Complete.
	@PostMapping("/updated")
	public String bookUpdation(@ModelAttribute("book") Books book, Map<String, Object> model) {
		model.put("admin", name);
		message = bookService.addNewBook(book);
		if (message.equalsIgnoreCase("done")) {
			model.put("message", "Book updation successful.");
			return "Au_commonOutput";
		}
		System.out.println("Book : " + book);
		return "Au_adminHome";
	}

	// Module is Complete.
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	/*
	 * @GetMapping("/start") public String dispOutput(Map<String , Object> model) {
	 * List<String> namesList = List.of("Yuvraj", "yuvi","uv","yu-v","u-vi");
	 * model.put("list", namesList);
	 * 
	 * String[] array= {"one","two","three","four"}; model.put("array", array);
	 * 
	 * Set<String> cities = Set.of("Hyderabad","Delhi","Mumbai","Solapur");
	 * model.put("set", cities);
	 * 
	 * Map<String, String> maper = Map.of("key-1", "value-1", "key-2", "value-2",
	 * "key-3", "value-3"); model.put("map", maper); return "output"; }
	 */
}
