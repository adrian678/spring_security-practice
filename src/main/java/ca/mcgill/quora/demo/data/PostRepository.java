package ca.mcgill.quora.demo.data;

import ca.mcgill.quora.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    //TODO check on which methods/queries are included by default
}
