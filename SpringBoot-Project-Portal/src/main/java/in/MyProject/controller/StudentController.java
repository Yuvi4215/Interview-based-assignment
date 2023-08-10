package in.MyProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.MyProject.IdGenreator.IdGenrator;
import in.MyProject.model.Books;
import in.MyProject.model.Student;
import in.MyProject.model.Transaction;
import in.MyProject.service.IBookService;
import in.MyProject.service.IStudentService;
import in.MyProject.service.ITransactionService;


@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired(required = true)
	private IStudentService studentService;
	
	@Autowired
	private ITransactionService transactionService;
	
	@Autowired(required = true)
	private IBookService bookService;
	
	private static final Integer pageSize=8;
	private String name="Yuvraj Varma";
	private String libraryId;
	private String message ="";
	private Integer fine ;
	private Integer limit ;
	/*
	 * public String loginPage(@ModelAttribute("Student") Student student) {
	 */	
	
	// Module is Complete.
	@GetMapping("/login")
	public String loginPage(Map<String , Object> model) {
		return "Su_StudentLogin";
	}
	
	// Module is Complete.
	@GetMapping("/signUp")
	public String signUpPage(Map<String , Object> model) {
		Student student = new Student();
		model.put("student", student);
		return "Su_StudentSignup";
	}
	
	// Module is Complete.
	@PostMapping("/signup_done")
	public String studentLog(@ModelAttribute("student") Student student, @RequestParam("confirm-password") String pswd,Map<String , Object> model) {
		System.out.println("student :: "+student);
		System.out.println("student :: "+student.getPassword());
		System.out.println("Confirm- password :: "+pswd);
		
		if (student.getPassword().equals(pswd)) {
			studentService.saveStudent(student);
			model.put("message", "Account created, please Login.");
			return "redirect:/student/login";
		} else {
			model.put("student", student);
			return "Su_StudentSignup";
		}
	}
	
	// Module is Complete.
	@PostMapping("/dashboard")
	public String studentDashboard(@RequestParam("libraryId") String id, @RequestParam("password") String pswd,Map<String , Object> model) {
		libraryId= id;
		Student student = studentService.getStudent(id);
		fine=student.getFine();
		limit=student.getTrancationId().size();
		System.out.println("ID :: "+id);
		System.out.println("PASSWORD :: "+pswd);
		model.put("student", name);
		return "Su_StudentHome";
	}
	
	// Module is Complete.
	@GetMapping("/home")
	public String homePage(Map<String , Object> model) {
		model.put("student", name);
		return "Su_student_dashboard";
	}
	
	// Module is Complete.
	@GetMapping("/search")
	public String searchBook(Map<String , Object> model) {
		model.put("student", name);
		return "Su_searchBook";
	}

	// Module is Complete.
	@GetMapping("/searching")
	public String searchingBook(@RequestParam("parameter") String parameter,@RequestParam("type") String type,Map<String , Object> model) {
		model.put("student", name);
		List<Books> list= new ArrayList<Books>();
		Books newBook = new Books();
		switch (type) {
			case "isbn": {
				newBook = bookService.findUsingId(Long.parseLong(parameter));
				list.add(newBook);
				break;
			}
			case "author": {
				list=bookService.findAuthorList(parameter);
				break;
			}
			case "title": {
				list=bookService.findTitleList(parameter);
				break;
			}
			case "genre": {
				list=bookService.findGenreList(parameter);
				break;
			}
		}
		
		model.put("limit", limit);
		model.put("list", list);
		return "Su_listBook";
	}
	
	// Module is Complete.
	@GetMapping("/bookList")
	public String allBook(@RequestParam(value = "pageNo",required=false) Integer pageNo, Map<String , Object> model) {
		model.put("student", name);
		if (pageNo == null) {
			pageNo=1;
		}
		Integer totalPages = bookService.getTotalPages(pageSize);
		List<Books> list = bookService.findAllAndPegination(pageNo, pageSize);
		model.put("limit", limit);
		model.put("list", list);
		model.put("pageNo",pageNo );
		model.put("pagesCount", totalPages);
		return "Su_listBook";
	}
	
	// Module is Complete.
	@GetMapping("/request")
	public String addRequest(@RequestParam("isbn") String isbn ,Map<String , Object> model) {
		System.out.println("Library ID :: "+libraryId);
		String transactionId = IdGenrator.genId();
		if (libraryId!=null) {
			System.out.println("ISBN is :: "+isbn);
			message = transactionService.SaveTransaction(new Transaction(transactionId, Long.parseLong(isbn), libraryId));
		}
		if (message.equalsIgnoreCase("done")) {
			Student student = studentService.getStudent(libraryId);
			List<String> studentTransaction = student.getTrancationId();
			studentTransaction.add(transactionId);
			student.setTrancationId(studentTransaction);
			student.setLimit(student.getTrancationId().size());
			studentService.saveStudent(student);

			Books book = bookService.findUsingId(Long.parseLong(isbn));
			List<String> bookTransaction = book.getTransactionId();
			bookTransaction.add(transactionId);
			book.setAvailable(book.getAvailable()-1);
			System.out.println(book.getAvailable());
			book.setBorrowed(book.getBorrowed()+1);
			book.setTransactionId(bookTransaction);
			bookService.updateBook(book);
			limit++;
			return "redirect:/student/pending";
		} else {
			model.put("message", "Fail to add book to Database");
			return "Su_commonOutput";
		}
	}

	// Module is Complete.
	@GetMapping("/pending")
	public String pendingRequest(Map<String , Object> model) {
		model.put("student", name);
		List<Transaction> list = transactionService.getTransactionByStatus(libraryId,"pending");
		model.put("list", list);
		return "Su_userPending";
	}

	@GetMapping("/borrowed")
	public String borrowedStatus(Map<String , Object> model) {
		model.put("student", name);
		List<Transaction> list = transactionService.getTransactionByStatus(libraryId,"Approved");
		model.put("list", list);
		return "Su_userBorrow";
	}
	
	@GetMapping("/fine")
	public String pendingFine(Map<String , Object> model) {
		model.put("student", name);
		model.put("student", libraryId);
		model.put("fine", fine);
		return "Su_pendingFine";
	}
	
	@GetMapping("/output")
	public String commonOutput( String message, Map<String , Object> model) {
		System.out.println("Book ISBN number :: "+ message);
		return "Su_commonOutput";
	}

	// Module is Complete.
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}


}
