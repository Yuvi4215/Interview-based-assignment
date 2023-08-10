package in.MyProject.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Books {

	@Id
	@NonNull
	private Long isbn;

	@NonNull
	private String author;
	
	@NonNull
	private String title;
	private String genre="Unkown";
	private String edition="Unkown";
	
	private String publisher="Unkown";
	private String year="Unkown";

	@NonNull
	private Integer totalCount;

	private Integer borrowed=0;
	private Integer available;
	
	private List<String> transactionId;
}
