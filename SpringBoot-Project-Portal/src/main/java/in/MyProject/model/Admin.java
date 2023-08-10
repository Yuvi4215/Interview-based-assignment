package in.MyProject.model;

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
public class Admin {

	@Id
	@NonNull
	private String staffId;
	
	private String name;

	private String email;
	
	@NonNull
	private String password;
}
