package com.devsuperior.DSPosts.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DSPosts.model.dto.PostDTO;
import com.devsuperior.DSPosts.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/posts")
@Tag(name = "Posts", description = "Controller for Posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Operation(description = "Get post by id", summary = "Get post by id", responses = {
			@ApiResponse(description = "Ok", responseCode = "200"),
			@ApiResponse(description = "Not Found", responseCode = "404"), })
	@GetMapping(value = "/{id}")
	public Mono<ResponseEntity<PostDTO>> findById(@PathVariable String id) {
		return postService.findById(id).map(postDto -> ResponseEntity.ok().body(postDto));
	}

	@Operation(description = "Get posts by title", summary = "Get list of posts by title", responses = {
			@ApiResponse(description = "Ok", responseCode = "200") })
	@GetMapping(value = "/titlesearch")
	public Flux<PostDTO> findByTitle(@RequestParam(defaultValue = "") String text) {
		return postService.findByTitle(text);
	}

	@Operation(description = "Get posts by moment, title, body and comments", summary = "Get list of posts by moment, title, body and comments", responses = {
			@ApiResponse(description = "Ok", responseCode = "200") })
	@GetMapping(value = "/fullsearch")
	public Flux<PostDTO> fullSearch(@RequestParam(defaultValue = "") String text,
			@RequestParam(defaultValue = "") String start, @RequestParam(defaultValue = "") String end) {
		return postService.fullSearch(text, start, end);
	}

	@Operation(description = "Get posts by user id", summary = "Get all posts of user", responses = {
			@ApiResponse(description = "Ok", responseCode = "200") })
	@GetMapping(value = "/user/{id}", produces = "application/json")
	public Flux<PostDTO> findByUser(@PathVariable String id) {
		return postService.findByUser(id);
	}
}
