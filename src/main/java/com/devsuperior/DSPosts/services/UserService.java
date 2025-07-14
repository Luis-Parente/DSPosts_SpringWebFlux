package com.devsuperior.DSPosts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DSPosts.model.dto.UserDTO;
import com.devsuperior.DSPosts.model.entities.User;
import com.devsuperior.DSPosts.repositories.UserRepository;
import com.devsuperior.DSPosts.services.exceptions.ResourceNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Flux<UserDTO> findAll() {
		return userRepository.findAll().map(x -> new UserDTO(x));
	}

	public Mono<UserDTO> findById(String id) {
		return userRepository.findById(id).map(x -> new UserDTO(x)).switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
	}

	public Mono<UserDTO> insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(entity, dto);

		Mono<UserDTO> result = userRepository.save(entity).map(x -> new UserDTO(x));
		
		return result;
	}
	
	private void copyDtoToEntity(User entity, UserDTO dto) {
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
	} 

	/*
	public UserDTO update(UserDTO dto, String id) {
		User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		copyDtoToEntity(entity, dto);

		entity = userRepository.save(entity);

		return new UserDTO(entity);
	}

	public void delete(String id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		userRepository.deleteById(id);

	}

	public List<PostDTO> getUserPosts(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return user.getPosts().stream().map(x -> new PostDTO(x)).toList();

	}

	
	*/
}
