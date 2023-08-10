package in.MyProject.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import in.MyProject.model.Books;
@Transactional
public interface IBookRepo extends MongoRepository<Books, Long> {

	public Books findByTitle(String title);
	public List<Books> findByAuthorIsContaining(String author);
	public List<Books> findByGenre(String genre);
	public List<Books> findByTitleIsContaining(String title);

}
