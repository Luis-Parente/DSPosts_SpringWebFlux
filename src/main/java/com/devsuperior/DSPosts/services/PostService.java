package com.devsuperior.DSPosts.services;

import java.time.Instant;
import java.time.format.DateTimeParseException;

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
		return postRepository.findById(id).map(post -> new PostDTO(post))
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Resource not found")));
	}

	public Flux<PostDTO> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text).map(post -> new PostDTO(post));
	}

	public Flux<PostDTO> fullSearch(String text, String start, String end) {
		Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
		Instant endMoment = convertMoment(end, Instant.now());
		return postRepository.fullSearch(text, startMoment, endMoment).map(post -> new PostDTO(post));
	}

	private Instant convertMoment(String orignalText, Instant alternative) {
		try {
			return Instant.parse(orignalText);
		} catch (DateTimeParseException e) {
			return alternative;
		}
	}
}
