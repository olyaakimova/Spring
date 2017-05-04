package fi.haagahelia.course;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Note;
import fi.haagahelia.course.domain.NoteRepository;
import fi.haagahelia.course.domain.PermissionRepository;
import fi.haagahelia.course.domain.UserRepository;
import fi.haagahelia.course.domain.User;

@SpringBootApplication
public class NotesApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder
	application) {
	return application.sources(NotesApplication.class);
	}

			
	private static final Logger log = LoggerFactory.getLogger(NotesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}
	@Bean
	public CommandLineRunner noteApp(NoteRepository Nrepository, UserRepository Urepository,CategoryRepository Crepository, PermissionRepository Prepository){
		return (args) -> {
			
			//adding some primary users
			User user1 = new User("user", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "USER");
			User user2 = new User("admin", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "ADMIN");
			User user3 = new User("owner", "$2a$05$nydhuDIcWXa0c8ItFgUNRO6YwFAQOaFbj6bmU4wptsRrays0ivzG6", "OWNER");
			
			
			Urepository.save(user1);
			Urepository.save(user2);
			Urepository.save(user3);
			
			//add categories
			Crepository.save(new Category("home"));
			Crepository.save(new Category("work"));
			Crepository.save(new Category("studies"));
			Crepository.save(new Category("other"));
			Crepository.save(new Category("travelling"));
			
			//adding some sample permissions - added directly from a note creation
			
		
			
			//adding some sample notes
			
			Nrepository.save(new Note("note1","note1 content",Crepository.findByName("home").get(0)));
			Nrepository.save(new Note("note2","note2 content",Crepository.findByName("work").get(0)));

			
			log.info("fetch all notes");
			for (Note note : Nrepository.findAll()) {
				log.info(note.toString());
			}
		};
		

		}
	}