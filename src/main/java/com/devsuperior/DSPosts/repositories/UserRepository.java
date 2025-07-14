package com.devsuperior.DSPosts.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DSPosts.model.entities.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
