package pl.loginblocked.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HisotyOfChanges {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String historyMessage;
	private LocalDateTime time;
	private String publicationName;
}
