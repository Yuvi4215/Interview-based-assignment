package in.MyProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import in.MyProject.model.Student;
@Transactional
public interface IStudentRepo extends MongoRepository<Student, String> {

}
