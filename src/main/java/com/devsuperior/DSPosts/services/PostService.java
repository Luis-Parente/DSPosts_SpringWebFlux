package com.devsuperior.DSPosts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DSPosts.model.dto.PostDTO;
import com.devsuperior.DSPosts.repositories.PostRepository;
import com.devsuperior.DSPosts.services.exceptions.ResourceNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Mono<PostDTO> findById(String id) {
		return postRepository.findById(id).map(x -> new PostDTO(x))
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
	}

	public Flux<PostDTO> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text).map(x -> new PostDTO(x));
	}
	/*
	 * public List<PostDTO> fullSearch(String text, String start, String end) {
	 * Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L)); Instant
	 * endMoment = convertMoment(end, Instant.now()); return
	 * postRepository.fullSearch(text, startMoment, endMoment).stream().map(x -> new
	 * PostDTO(x)).toList(); }
	 * 
	 * private Instant convertMoment(String orignalText, Instant alternative) { try
	 * { return Instant.parse(orignalText); } catch (DateTimeParseException e) {
	 * return alternative;
	 */
}
