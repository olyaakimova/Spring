package fi.haagahelia.course;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.web.NoteController;
import fi.haagahelia.course.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	
	@Autowired
	private NoteController Ncontroller;
	@Autowired
	private UserController Ucontroller;


	
	@Test
	public void contextLoads() throws Exception {
		assertThat(Ncontroller).isNotNull();
		assertThat(Ucontroller).isNotNull();
	}

}
