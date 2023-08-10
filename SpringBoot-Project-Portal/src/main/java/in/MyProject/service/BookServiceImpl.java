package in.MyProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.MyProject.dao.IBookRepo;
import in.MyProject.model.Books;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired(required = true)
	private IBookRepo repo;

	@Override
	public List<Books> findAllAndPegination(Integer pageNo, Integer pageSize) {
		PageRequest request = PageRequest.of(pageNo-1, pageSize);
		return repo.findAll(request).getContent();
	}

	@Override
	public String addNewBook(Books book) {
		System.out.println(book);
		book.setAvailable(book.getTotalCount());
		repo.save(book);
		return "done";
	}

	@Override
	public Books findUsingId(Long id) {
		Optional<Books> optional = repo.findById(id);
		if (optional.isPresent()) {
			Books books = optional.get();
			return books;
		} else {
			return null;
		}
	}

	@Override
	public Books findUsingTitle(String title) {
		Books bookByTitle = repo.findByTitle(title);
		return bookByTitle;
	}

	@Override
	public List<Books> findTitleList(String title) {
		return repo.findByTitleIsContaining(title);
	}

	@Override
	public List<Books> findAuthorList(String author) {
		return repo.findByAuthorIsContaining(author);
	}

	@Override
	public List<Books> findGenreList(String genre) {
		return repo.findByGenre(genre);
	}

	@Override
	public void updateBook(Books book) {
		repo.save(book);
	}

	@Override
	public Integer getTotalPages(Integer pageSize) {
		long count = repo.count();
		System.out.println("Record Count :: "+ count);
		Integer totalPages= (int) (count/pageSize);
		if (count%pageSize!=0) {
			totalPages++;
		}
		if (count<pageSize) {
			totalPages=1;
		}
		
		System.out.println("pageSize is ::: "+pageSize);
		System.out.println("Total pages ::: "+totalPages);
		return totalPages;
	}


}
