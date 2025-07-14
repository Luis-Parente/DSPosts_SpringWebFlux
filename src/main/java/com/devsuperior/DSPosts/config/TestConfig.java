package com.devsuperior.DSPosts.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.DSPosts.model.embedded.Author;
import com.devsuperior.DSPosts.model.embedded.Comment;
import com.devsuperior.DSPosts.model.entities.Post;
import com.devsuperior.DSPosts.model.entities.User;
import com.devsuperior.DSPosts.repositories.PostRepository;
import com.devsuperior.DSPosts.repositories.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Mono<Void> deleteUsers = userRepository.deleteAll();
		deleteUsers.subscribe();
		Mono<Void> deletePosts = postRepository.deleteAll();
		deletePosts.subscribe();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Flux<User> insertUsers = userRepository.saveAll(Arrays.asList(maria, alex, bob));
		insertUsers.subscribe();

		maria = userRepository.findByEmailIgnoreCase(maria.getEmail()).toFuture().get();
		alex = userRepository.findByEmailIgnoreCase(alex.getEmail()).toFuture().get();
		bob = userRepository.findByEmailIgnoreCase(bob.getEmail()).toFuture().get();

		Post post1 = new Post(null, Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", new Author(maria.getId(), maria.getName()));
		Post post2 = new Post(null, Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje!",
				new Author(maria.getId(), maria.getName()));

		Comment c1 = new Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(alex));
		Comment c2 = new Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(bob));
		Comment c3 = new Comment("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		post1.setUser(userRepository.findByEmailIgnoreCase(maria.getEmail()).block());
		post2.setUser(userRepository.findByEmailIgnoreCase(maria.getEmail()).block());

		Flux<Post> insertPosts = postRepository.saveAll(Arrays.asList(post1, post2));
		insertPosts.subscribe();

	}
}
