package com.luizfelipe.workshopmongo.services;

import com.luizfelipe.workshopmongo.domain.Post;
import com.luizfelipe.workshopmongo.repository.PostRepository;
import com.luizfelipe.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Post user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
