//Spring NoteRepositoryJpaTest

package fi.haagahelia.course;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.Note;
import fi.haagahelia.course.domain.NoteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryJpaTest {
	private NoteRepository Nrepository;
	
	@Autowired
	public void setNoteRepository(NoteRepository Nrepository){
		this.Nrepository=Nrepository;
	}
	
	//add note
	@Test
	public void addNote(){
		//create a book object
		Note note = new Note ("noteName", "noteContent", new Category("home"));
		//check that it is not in a repository yet
		assertNull(note.getNoteId());
		//save note object to repository
		Nrepository.save(note);
		//check that now this note is in repository
		assertNotNull(note.getNoteId());
	}
	
	//search note
	@Test
	public void searchNote(){
		Note note = new Note ("noteName", "noteContent", new Category("home"));
		Nrepository.save(note);
		Note findNote = Nrepository.findOne(note.getNoteId());
		assertNotNull(findNote);
	}
	
	//delete note
	//delete book
		@Test
		//@WithMockUser(roles={"ADMIN"})
		public void deleteBook(){
			//first create
			Note note = new Note ("noteName", "noteContent", new Category("home"));
			Nrepository.save(note);
			//make sure it is there
			Note findNote = Nrepository.findOne(note.getNoteId());
			assertNotNull(findNote);
			//delete
			Nrepository.delete(note.getNoteId());
			//make sure there is no book anymore
			findNote = Nrepository.findOne(note.getNoteId());
			assertNull(findNote);
			
		}

}
