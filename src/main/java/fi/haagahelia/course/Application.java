package fi.haagahelia.course;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Note;
import fi.haagahelia.course.domain.NoteRepository;
import fi.haagahelia.course.domain.UserRepository;
import fi.haagahelia.course.domain.User;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner noteApp(NoteRepository Nrepository, UserRepository Urepository){
		return (args) -> {
			
			//adding some primary users
			User user1 = new User("user", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "USER");
			User user2 = new User("admin", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "ADMIN");
			Urepository.save(user1);
			Urepository.save(user2);
			
			//adding some sample notes
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
			
			Nrepository.save(new Note("note1","note1 content"));
			Nrepository.save(new Note("note2","note2 content"));

			
			log.info("fetch all notes");
			for (Note note : Nrepository.findAll()) {
				log.info(note.toString());
			}
		};
		

		}
	}