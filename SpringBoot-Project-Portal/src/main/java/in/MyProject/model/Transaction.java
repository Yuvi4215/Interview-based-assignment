package in.MyProject.model;

import java.time.LocalDate;

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
public class Transaction {

	@Id
	@NonNull
	private String trancationId;
	
	@NonNull
	private Long isbn;
	
	@NonNull
	private String libraryId;
	
	private LocalDate returnDate;

	private String staffId=" ";
	
	private String status = "pending";
}
