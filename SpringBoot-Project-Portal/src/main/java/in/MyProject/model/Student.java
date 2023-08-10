package in.MyProject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	
	@Id
	@NonNull
	private String libraryId;
	
	@NonNull
	private String studentId;

	@NonNull
	private String name;

	private String email;
	
	private Integer fine=0;

	@NonNull
	private Byte year;

	@NonNull
	private String department;
	
	@NonNull
	private String password;
	
	
	private List<String> trancationId = new ArrayList<String>();
	
	private Integer limit;
}
