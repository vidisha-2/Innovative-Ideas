package com.vidisha.beltexam.validators;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vidisha.beltexam.models.User;
import com.vidisha.beltexam.repositories.UserRepository;


@Component
public class UserValidator implements Validator {
	private final UserRepository userRepository;
	public UserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		
	}
	
 //find if email already exists
	
    public boolean checkEmail(String email, BindingResult result) {
    	Optional<User> user = userRepository.findIfEmailExists(email);
    	if(user.isPresent()) {
    		
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
