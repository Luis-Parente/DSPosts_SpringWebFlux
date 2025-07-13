package com.devsuperior.DSPosts.model.dto;

import com.devsuperior.DSPosts.model.entities.User;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

	private String id;
	@NotBlank(message = "Required field")
	private String name;
	@NotBlank(message = "Required field")
	private String email;

	public UserDTO() {

	}

	public UserDTO(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
