package ca.mcgill.quora.demo.services;

import ca.mcgill.quora.demo.data.PostRepository;
import ca.mcgill.quora.demo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post findOne(long id){
        Optional<Post> post = postRepository.findById(id);
//        post.orElseThrow(new PostNotFoundException("No such post found"));
        return post.orElse(null); //TODO try to fit an exception here
    }
}
