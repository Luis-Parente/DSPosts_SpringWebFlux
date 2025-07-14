package com.devsuperior.DSPosts.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
/*
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAll() {
		List<User> result = userRepository.findAll();
		return result.stream().map(x -> new UserDTO(x)).toList();
	}

	public UserDTO findById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return new UserDTO(user);
	}

	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(entity, dto);

		entity = userRepository.save(entity);

		return new UserDTO(entity);
	}

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

	private void copyDtoToEntity(User entity, UserDTO dto) {
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
	}
*/
}
