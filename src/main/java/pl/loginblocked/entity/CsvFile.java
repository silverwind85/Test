package pl.loginblocked.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class CsvFile {
	@Id
	@GeneratedValue
	private Long id;
	@Transient
	private MultipartFile content;
	private String category;


	public CsvFile() {
		super();
	}

	public CsvFile(Long id, MultipartFile content,String category) {
		super();
		this.id = id;
		this.content = content;
		this.category = category;
	}

	public CsvFile(MultipartFile content) {
		super();
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipartFile getContent() {
		return content;
	}

	public void setContent(MultipartFile content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
