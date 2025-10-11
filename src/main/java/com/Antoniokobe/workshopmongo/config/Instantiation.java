package com.Antoniokobe.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Antoniokobe.workshopmongo.domain.Post;
import com.Antoniokobe.workshopmongo.domain.User;
import com.Antoniokobe.workshopmongo.dto.AuthorDTO;
import com.Antoniokobe.workshopmongo.repository.PostRepository;
import com.Antoniokobe.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post (null, sdf.parse("10/10/2025"),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post (null, sdf.parse("11/10/2025"),"Bom dia", "Acordei cheia de gás, naquele pique!", new AuthorDTO(maria));
				
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}

}
