package com.vidisha.beltexam.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vidisha.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	

	
	User findByEmail(String email);
	
	//find if email already exists
	@Query("SELECT t.email FROM User t WHERE t.email=?1")
	Optional<User> findIfEmailExists(String email);
}
