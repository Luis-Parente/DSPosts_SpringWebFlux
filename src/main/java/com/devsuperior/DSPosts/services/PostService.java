package com.devsuperior.DSPosts.services;

import org.springframework.stereotype.Service;

@Service
public class PostService {
/*
	@Autowired
	private PostRepository postRepository;

	public PostDTO findById(String id) {
		Post entity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return new PostDTO(entity);
	}

	public List<PostDTO> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text).stream().map(x -> new PostDTO(x)).toList();
	}

	public List<PostDTO> fullSearch(String text, String start, String end) {
		Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
		Instant endMoment = convertMoment(end, Instant.now());
		return postRepository.fullSearch(text, startMoment, endMoment).stream().map(x -> new PostDTO(x)).toList();
	}
	
	private Instant convertMoment(String orignalText, Instant alternative) {
		try {
			return Instant.parse(orignalText);
		}
		catch (DateTimeParseException e) {
			return alternative;
	*/
}
