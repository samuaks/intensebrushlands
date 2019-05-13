package open.vision.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import open.vision.app.domain.User;
import open.vision.app.domain.UserRepository;
import open.vision.app.domain.SignupForm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	
	//sign a new user
	@RequestMapping(value="signup")
	public String signUp(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	//Create new user
	//Also check if user exists already, in which case dont create
	@RequestMapping(value="saveuser", method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("signupform") SignupForm signup, BindingResult binding) {
		//check for validation
		if(!binding.hasErrors()) { 
			//Match passwords against each other
			//password encrypt
			if(signup.getPassword().equals(signup.getPasswordTest())) {
				String password = signup.getPassword();
				BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
				String hashpw = encrypt.encode(password);
				
				//User check and assign role "USER"
				User user = new User();
				user.setPasswordCheck(hashpw);
				user.setUsername(signup.getUsername());
				user.setRole("USER");
				
				//Check if user exists
				if(repo.findByUsername(signup.getUsername())==null) {
					repo.save(user);
				} else {
					binding.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
				
			} else {
				binding.rejectValue("passwordCheck", "err.passCheck", "Password doesn't match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	} 
}
