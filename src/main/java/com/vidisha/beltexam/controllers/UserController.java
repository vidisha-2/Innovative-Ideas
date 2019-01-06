package com.vidisha.beltexam.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vidisha.beltexam.models.User;
import com.vidisha.beltexam.services.IdeaService;
import com.vidisha.beltexam.services.UserService;
import com.vidisha.beltexam.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final IdeaService ideaserv;
	
	public UserController(UserService userService, UserValidator userValidator, IdeaService ideaserv) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.ideaserv = ideaserv;
	}
	
	@RequestMapping("/index")
	public String registerForm(@ModelAttribute("user") User user) {
		return "loginreg.jsp";
	}
	
	  
    // if result has errors, return the registration page (don't worry about validations just now)
    // else, save the user in the database, save the user id in session, and redirect them to the /home route
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
       	userValidator.validate(user, result);
    	if(userValidator.checkEmail(user.getEmail(), result)==true) {
       		model.addAttribute("error", "Email already exists.");
			return "loginreg.jsp";
		}
    	if(result.hasErrors()) {
    		return "loginreg.jsp";
    	}
    	else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}
    	
    }
    
 // if the user is authenticated, save their user id in session
    // else, add error messages and return the login page
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes attr) {
       	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}else {
    		model.addAttribute("error_msg", "Invalid credentials. Please try again.");
    		User user = new User();
    		model.addAttribute("user", user);
    		return "loginreg.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	    // get user from session, save them in the model and return the home page
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/index";
    	}
    	else {
    		Long userId = (Long) session.getAttribute("userId");
        	User u = userService.findUserById(userId);
        	
        	model.addAttribute("user", u);
        	model.addAttribute("allIdeas", ideaserv.getAllIdeas());
        	return "ideas.jsp";
    	}
    	   
    }
	//logout
	 @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	        // redirect to login page
	    	session.invalidate();
	    	return "redirect:/index";
	    }
}
