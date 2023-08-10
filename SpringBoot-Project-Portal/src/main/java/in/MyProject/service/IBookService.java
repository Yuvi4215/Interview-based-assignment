package in.MyProject.service;

import java.util.List;

import in.MyProject.model.Books;

public interface IBookService {
	public Integer getTotalPages(Integer pageSize);
	public List<Books> findAllAndPegination(Integer pageNo, Integer pageSize);
	public List<Books> findTitleList(String title);
	public List<Books> findAuthorList(String author);
	public List<Books> findGenreList(String genre);
	public String addNewBook(Books book);
	public void updateBook(Books book);
	public Books findUsingId(Long id);

	public Books findUsingTitle(String title);
}
