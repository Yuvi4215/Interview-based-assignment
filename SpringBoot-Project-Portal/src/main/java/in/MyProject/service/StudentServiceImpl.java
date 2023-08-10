package in.MyProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.MyProject.dao.IStudentRepo;
import in.MyProject.model.Student;

@Service

public class StudentServiceImpl implements IStudentService {

	@Autowired(required = true)
	private IStudentRepo stdRepo;
	
	@Override
	public List<Student> findStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveStudent(Student student) {
	stdRepo.save(student);;
		
	}

	@Override
	public Student getStudent(String libraryId) {
		Optional<Student> optional = stdRepo.findById(libraryId);
		Student student=null;
		if (optional.isPresent()) {
			student = optional.get();
		}
		return student;
	}

}
