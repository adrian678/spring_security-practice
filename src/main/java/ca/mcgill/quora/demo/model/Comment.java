package ca.mcgill.quora.demo.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;                //TODO add @Notnull annotations
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Post parentPost;
    @ManyToOne(cascade = CascadeType.ALL) //TODO right cascade type?
    @JoinColumn
    private Comment parentComment;

    public Post getParentPost(){
        return parentPost;
    }

    public Comment getParentComment(){
        return parentComment;
    }

}
