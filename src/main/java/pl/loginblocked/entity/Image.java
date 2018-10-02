package pl.loginblocked.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Image {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String mime;
	@Lob
	private byte[] content;
	private String author;
	@Transient
	private MultipartFile picture;
	
	public Image() {
		super();
	}
	public Image(Long id, String name, String mime, byte[] content, String author) {
		super();
		this.id = id;
		this.name = name;
		this.mime = mime;
		this.content = content;
		this.author = author;
	}
	
	public Image(String name, String mime, byte[] content, String author, MultipartFile picture) {
		super();
		this.name = name;
		this.mime = mime;
		this.content = content;
		this.author = author;
		this.picture = picture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	
	
}
