package com.vidisha.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vidisha.beltexam.models.Idea;
import com.vidisha.beltexam.models.User;
import com.vidisha.beltexam.repositories.IdeaRepository;
import com.vidisha.beltexam.repositories.UserRepository;

@Service
public class IdeaService {
	private final IdeaRepository idearepo;
	private final UserRepository userrepo;
	
	public IdeaService(IdeaRepository idearepo, UserRepository userrepo) {
		this.idearepo = idearepo;
		this.userrepo = userrepo;
	}
	
	public Idea createIdea(Idea idea) {
		return idearepo.save(idea);
	}
	
	public Idea getIdea(Long id) {
		Optional<Idea> idea = idearepo.findById(id);
		if(idea.isPresent()) {
			return idea.get();
		}
		else {
			return null;
		}
	}
	
	public List<Idea> getAllIdeas(){
		return idearepo.findAll();
	}
	
	public Idea updateIdea(Idea idea) {
		return idearepo.save(idea);
	}
	
	public Idea deleteIdea(Long id) {
		idearepo.deleteById(id);
		return null;
	}
	
//	public List<User> getALLuser(){
//		return idearepo.
//	}
}
