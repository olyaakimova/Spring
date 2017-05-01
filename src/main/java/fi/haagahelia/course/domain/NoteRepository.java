// Spring NoteRepository


package fi.haagahelia.course.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository <Note,Long> {
	List<Note> findByNoteName(String name);
}
