package ca.mcgill.quora.demo.controller;

import ca.mcgill.quora.demo.data.PostRepository;
import ca.mcgill.quora.demo.model.Post;
import ca.mcgill.quora.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;
    PostService postService;
    Class<PostController> postControllerClass = PostController.class;

    @RequestMapping(value={"/posts", "/posts/"})
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @RequestMapping(value={"/posts/{id}", "/posts/{id}/"})
    public Post findOne(@PathVariable long id) {
        return postRepository.findById(id).orElse(null);
        //TODO perform exception handling for case of missing post
    }

}
