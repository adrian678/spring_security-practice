package ca.mcgill.quora.demo.data;

import ca.mcgill.quora.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
