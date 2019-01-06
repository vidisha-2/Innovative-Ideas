package com.vidisha.beltexam.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vidisha.beltexam.models.Idea;
import com.vidisha.beltexam.models.User;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	
//	@Query("SELECT u.firstname FROM User u JOIN u.ideas i WHERE i.id=?1")
//	List<User> findAllUsers(Long id);
}
