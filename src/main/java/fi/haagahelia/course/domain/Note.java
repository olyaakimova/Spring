// Spring Note


package fi.haagahelia.course.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noteId;
	private String noteName;
	private String noteContent;
	private Date noteCreationDate = new Date();
	
	
	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	//private String ownerName = authentication.getName();
	private String ownerName = "owner";
	
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


	public Date getNoteCreationDate() {
		return noteCreationDate;
	}


	public void setNoteCreationDate(Date noteCreationDate) {
		this.noteCreationDate = noteCreationDate;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteName=" + noteName + ", noteContent=" + noteContent
				+ ", noteCreationDate=" + noteCreationDate + ", category=" + category + ", ownerName=" + ownerName
				+ "]";
	}

}
