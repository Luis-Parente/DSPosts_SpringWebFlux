package com.devsuperior.DSPosts.model.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.DSPosts.model.dto.PostDTO;
import com.devsuperior.DSPosts.model.dto.UserDTO;
import com.devsuperior.DSPosts.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "Users", description = "Controller for Users")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(description = "Get all users", summary = "Get list of users", responses = {
			@ApiResponse(description = "Ok", responseCode = "200")})
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> result = userService.findAll();
		return ResponseEntity.ok().body(result);
	}

	@Operation(description = "Get user by id", summary = "Get user by id", responses = {
			@ApiResponse(description = "Ok", responseCode = "200"),
			@ApiResponse(description = "Not Found", responseCode = "404"), })
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO result = userService.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@Operation(description = "Create a new user", summary = "Create a new user", responses = {
			@ApiResponse(description = "Created", responseCode = "201"),
			@ApiResponse(description = "Bad Request", responseCode = "400"),
			@ApiResponse(description = "Unprocessable Entity", responseCode = "422") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserDTO dto) {
		UserDTO result = userService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}

	@Operation(description = "Update user", summary = "Update user data", responses = {
			@ApiResponse(description = "Ok", responseCode = "200"),
			@ApiResponse(description = "Bad Request", responseCode = "400"),
			@ApiResponse(description = "Unprocessable Entity", responseCode = "422") })
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO dto, @PathVariable String id) {
		UserDTO result = userService.update(dto, id);
		return ResponseEntity.ok().body(result);
	}

	@Operation(description = "Delete user", summary = "Delete user", responses = {
			@ApiResponse(description = "Sucess", responseCode = "204"),
			@ApiResponse(description = "Bad Request", responseCode = "400"),
			@ApiResponse(description = "Not Found", responseCode = "404")})
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(description = "Get posts by user id", summary = "Get all posts of user", responses = {
			@ApiResponse(description = "Ok", responseCode = "200"),
			@ApiResponse(description = "Not Found", responseCode = "404"), })
	@GetMapping(value = "/{id}/posts", produces = "application/json")
	public ResponseEntity<List<PostDTO>> getUserPosts(@PathVariable String id) {
		List<PostDTO> result = userService.getUserPosts(id);
		return ResponseEntity.ok().body(result);
	}
}
