package com.Antoniokobe.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Antoniokobe.workshopmongo.domain.User;
import com.Antoniokobe.workshopmongo.dto.UserDTO;
import com.Antoniokobe.workshopmongo.repository.UserRepository;
import com.Antoniokobe.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
	/* public Optional<User> findById(String id) {
	    Optional<User> user = repo.findById(id);
	    if (user.isPresent()) {
	        return user.get();
	    } else {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    
	}*/
	
	public User findById(String id) { 
		 Optional<User> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
		}
	
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User FromDTO(UserDTO objDto) {
		return new User (objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
