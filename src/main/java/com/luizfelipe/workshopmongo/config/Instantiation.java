package com.luizfelipe.workshopmongo.config;

import com.luizfelipe.workshopmongo.domain.Post;
import com.luizfelipe.workshopmongo.domain.User;
import com.luizfelipe.workshopmongo.dto.AuthorDTO;
import com.luizfelipe.workshopmongo.repository.PostRepository;
import com.luizfelipe.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2023"), "partiu viagem",
                "vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2023"), "bom dia", "acordei feliz hoje!",
                new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
