// Spring Note


package fi.haagahelia.course.domain;

import java.util.Date;

import javax.persistence.CascadeType;
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
	private long noteId;
	private String noteName;
	private String noteContent;
	private Date noteCreationDate = new Date();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="noteId")
	private User owner;
	public Note(){}

	public Note(String noteName, String noteContent) {
		super();
		this.noteName = noteName;
		this.noteContent = noteContent;
		}

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
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

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteName=" + noteName + ", noteContent=" + noteContent
				+ ", noteCreationDate=" + noteCreationDate + ", users=" + owner + "]";
	}


}
