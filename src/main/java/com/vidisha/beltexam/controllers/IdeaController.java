package com.vidisha.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vidisha.beltexam.models.Idea;
import com.vidisha.beltexam.models.User;
import com.vidisha.beltexam.services.IdeaService;
import com.vidisha.beltexam.services.UserService;

@Controller
public class IdeaController {
	private final UserService userserv;
	private final IdeaService ideaserv;
	
	public IdeaController(IdeaService ideaserv, UserService userserv) {
		this.ideaserv = ideaserv;
		this.userserv = userserv;
	}
	
	@RequestMapping("/ideas/new")
	public String index(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
    	User u = userserv.findUserById(userId);
    	model.addAttribute("user", u);
    	return "createPage.jsp";
	}
	
	@RequestMapping(value="/ideas/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @RequestParam("host") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errors", "Cannot leave it empty");
			return "createPage.jsp";
		}
		else {
			Idea i = ideaserv.createIdea(idea);
			model.addAttribute("idea", i);
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/ideas/{idea_id}")
	public String showIdea(@PathVariable("idea_id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		Idea i = ideaserv.getIdea(id);
		List<User> liked_idea = i.getUsers();
		//List<User> liked_user = userserv.get
		model.addAttribute("likedIdea", liked_idea);
		model.addAttribute("idea", i);
		return "showIdea.jsp";
	}
	
	@RequestMapping("/ideas/{idea_id}/edit")
	public String editIdea(@ModelAttribute("idea") Idea idea, @PathVariable("idea_id") Long id, Model model, HttpSession session) {
		Idea i = ideaserv.getIdea(id);
		Long userId = (Long) session.getAttribute("userId");
		User user = userserv.findUserById(userId);
//		if(i.getHost().getId().equals(userId)) {
			model.addAttribute("user", user);
			model.addAttribute("idea", ideaserv.getIdea(id));
			return "editIdea.jsp";
//		} else {
//			return "redirect:/home";
//		}
			
		
	}
	@RequestMapping(value="/ideas/{idea_id}/update", method=RequestMethod.POST)
	public String updateIdea(@PathVariable("idea_id") Long id, @Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			//model.addAttribute("idea", ideaserv.getIdea(id));
			model.addAttribute("errors", "Cannot Leave It empty");
			return "editIdea.jsp";
		}
		else {
			Idea i = ideaserv.getIdea(id);
			ideaserv.deleteIdea(id);
			ideaserv.updateIdea(idea);
			return "redirect:/home";
		}
	}
	
	@RequestMapping("ideas/{idea_id}/like")
	public String like(@PathVariable("idea_id") Long id, Model model, HttpSession session) {
		Idea this_idea = ideaserv.getIdea(id);
		Long userId = (Long) session.getAttribute("userId");
		User this_user = userserv.findUserById(userId);
		this_idea.getUsers().add(this_user);
		ideaserv.updateIdea(this_idea);
		return "redirect:/home";
	}
	
	@RequestMapping("ideas/{idea_id}/unlike")
	public String unlike(@PathVariable("idea_id") Long id, Model model, HttpSession session) {
		Idea this_idea = ideaserv.getIdea(id);
		Long userId = (Long) session.getAttribute("userId");
		User this_user = userserv.findUserById(userId);
		this_idea.getUsers().remove(this_user);
		ideaserv.updateIdea(this_idea);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/ideas/{idea_id}/delete")
	public String destroy(@PathVariable("idea_id") Long id) {
		ideaserv.deleteIdea(id);
		return "redirect:/home";
	}
	
//	@RequestMapping("/ascending")
//	public String showLikes(HttpSession session, Model model) {
//		
//	}
}
