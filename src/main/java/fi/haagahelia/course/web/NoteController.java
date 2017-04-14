package fi.haagahelia.course.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.Note;
import fi.haagahelia.course.domain.NoteRepository;
import fi.haagahelia.course.domain.UserRepository;

public class NoteController {
	
	@Autowired
	private NoteRepository Nrepository;
	@Autowired
	private UserRepository Urepository;
	
	
	//show all notes
	@RequestMapping(value = "/notelist", method=RequestMethod.POST)
		public String NoteList(Model model){
		model.addAttribute("books", Nrepository.findAll());
		return "notelist";
	}
	
	//RESTful to get all books
	@RequestMapping(value="/books",method = RequestMethod.GET)
	public @ResponseBody List<Note> noteListRest(){
		return (List <Note>) Nrepository.findAll();
	}
	
}
