package in.MyProject.service;

import java.util.List;

import in.MyProject.model.Student;

public interface IStudentService {

	public List<Student> findStudent();
	public void saveStudent(Student student);
	public Student getStudent(String libraryId);
}
