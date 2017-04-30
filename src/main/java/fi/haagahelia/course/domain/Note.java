// Spring Note


package fi.haagahelia.course.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noteId;
	private String noteName;
	private String noteContent;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id")
	private Category category;
	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	//private String ownerName = authentication.getName();
	private String ownerName = "owner";
	//private User owner;
	
	
	public Note(){}

	public Note(String noteName, String noteContent, Category category) {
		super();
		this.noteName = noteName;
		this.noteContent = noteContent;
		this.category=category;
		}

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




//	public void setOwnerName(String ownerName) {
//		this.ownerName = ownerName;
//	}
	
	public String getOwnerName() {
		return ownerName;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteName=" + noteName + ", noteContent=" + noteContent + ", category="
				+ category + ", ownerName=" + ownerName + "]";
	}


	


}
