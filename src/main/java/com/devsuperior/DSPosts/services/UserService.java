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
		return userRepository.findAll().map(user -> new UserDTO(user));
	}

	public Mono<UserDTO> findById(String id) {
		return userRepository.findById(id).map(user -> new UserDTO(user))
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
	}

	public Mono<UserDTO> insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(entity, dto);

		Mono<UserDTO> result = userRepository.save(entity).map(user -> new UserDTO(user));

		return result;
	}

	public Mono<UserDTO> update(UserDTO dto, String id) {
		return userRepository.findById(id).flatMap(existingUser -> {
			existingUser.setName(dto.getName());
			existingUser.setEmail(dto.getEmail());
			return userRepository.save(existingUser);
		}).map(user -> new UserDTO(user))
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
	}

	private void copyDtoToEntity(User entity, UserDTO dto) {
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
	}

	public Mono<Void> delete(String id) {
		return userRepository.findById(id)
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")))
				.flatMap(user -> userRepository.delete(user));

	}
	/*
	 * public List<PostDTO> getUserPosts(String id) { User user =
	 * userRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("Object not found")); return
	 * user.getPosts().stream().map(x -> new PostDTO(x)).toList();
	 * 
	 * }
	 * 
	 * 
	 */
}
