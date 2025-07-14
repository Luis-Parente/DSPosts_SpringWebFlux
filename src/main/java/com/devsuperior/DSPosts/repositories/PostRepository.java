package com.devsuperior.DSPosts.repositories;

import java.time.Instant;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DSPosts.model.entities.Post;

import reactor.core.publisher.Flux;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {

	Flux<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{ $and: [ { moment: {$gte: ?1} }, { moment: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	Flux<Post> fullSearch(String text, Instant startMoment, Instant endMoment);
}
