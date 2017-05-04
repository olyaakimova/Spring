// Spring Note


package fi.haagahelia.course.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noteId;
	private String noteName;
	private String noteContent;
	
	@CreatedDate
	private Date createdDate;	

	@CreatedBy
	private String createdBy;

	@LastModifiedDate 
	private Date lastModifiedDate;
	
	@LastModifiedBy 
	private String lastModifiedBy;
	
	@OneToMany(mappedBy ="permission")
			private List<Permission> permissions;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;

	
	public Note(String noteName, String noteContent, Category category) {
		super();
		this.noteName = noteName;
		this.noteContent = noteContent;
		this.category = category;
	}
	
	public Note(){}
	
	public Long getNoteId() {
		return noteId;
	}


	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}


	public String getNoteName() {
		return noteName;
	}


	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}


	public String getNoteContent() {
		return noteContent;
	}


	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	



	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
		
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}




}
