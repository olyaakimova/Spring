//Spring UserController
//creates users
//checks if a user already exists

package fi.haagahelia.course.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.SignupForm;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository Urepository;
	
	//sign up
	@RequestMapping(value="signup")
	public String addUser (Model model){
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	//saveuser
	@RequestMapping(value="saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult){
		//if there is no validation errors
		if(!bindingResult.hasErrors()){
			//compare password and password check
			if(signupForm.getPassword().equals(signupForm.getPasswordCheck())){
				//if success (no validation error)
				//encrypt password to hash value
				String pwd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);
				
				//create user
				User newUser = new User();
				newUser.setUsername(signupForm.getUsername());
				newUser.setPasswordHash(hashPwd);
				newUser.setRole("USER");
				
				//check if user already exists in UserRepository
				if(Urepository.findByUsername(signupForm.getUsername())==null){
					//if success (no such user in repo)
					//save user
					Urepository.save(newUser);
				}
				else {
					//if failure (user already exists)
					//reject signup and redirect back to signup
					bindingResult.rejectValue("username", "err.username","Username already exists");
					return "signup";
				}
			}
			else{
				//if failure (there are validation errors, passwords dont match)
				//reject and redirect back to signup
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
				return "signup";
			}
		}
		else{
			return "signup";
		}
		return "regirect:/login";
	}
}
