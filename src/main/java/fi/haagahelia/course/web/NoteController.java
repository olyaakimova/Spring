package fi.haagahelia.course.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Note;
import fi.haagahelia.course.domain.NoteRepository;

@Controller
@SessionAttributes("note")
public class NoteController {
	
	@Autowired
	private NoteRepository Nrepository;
	@Autowired
	private CategoryRepository Crepository;

	

	//login
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }
	
	//show all notes
	@RequestMapping(value = {"/notelist","/","/index"}, method=RequestMethod.GET)
		public String NoteList(Model model){
		model.addAttribute("notes", Nrepository.findAll());
		return "notelist";
	}
	
	//RESTful to get all notes
	@RequestMapping(value="/notes",method = RequestMethod.GET)
	public @ResponseBody List<Note> noteListRest(){
		return (List <Note>) Nrepository.findAll();
	}
	
	//RESTful to get a note by id
	@RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
	public @ResponseBody Note findNoteRest(@PathVariable("id") Long noteId){
		return Nrepository.findOne(noteId);
	}
	//add note
	@RequestMapping(value="/add")
	public String addNote(Model model){
		model.addAttribute("note", new Note());
		//model.addAttribute("user", Urepository.findAll());
		model.addAttribute("categories", Crepository.findAll());
		return "addnote";
	}
	
	//edit note
		@RequestMapping(value="/edit/{id}")
		public String editNote(@PathVariable("id") Long noteId, Model model){
	        model.addAttribute("note", Nrepository.findOne(noteId));
	        model.addAttribute("categories", Crepository.findAll());
			return "editnote";
	
	}
	
	//view note
	@RequestMapping(value = "/viewnote/{id}", method=RequestMethod.GET)
	public String viewNote(@PathVariable("id") Long noteId, Model model){
        model.addAttribute("note", Nrepository.findOne(noteId));
        model.addAttribute("categories", Crepository.findAll());
		return "viewnote";
	}
		
	//save new note
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Note note){
		Nrepository.save(note);
		return "redirect:notelist";
	}
	
	//delete note
	//@PreAuthorize("hasAuthority('OWNER')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteNote(@PathVariable("id") Long noteId, Model model){
		Nrepository.delete(noteId);
		return "redirect:../notelist";
	}
	
}
