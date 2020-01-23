package ca.mcgill.quora.demo.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;            //TODO add @Notnull annotations
    @ManyToOne
    @JoinColumn
    private User author;
    private String content;
    private int points;

    public long getPid() {
        return pid;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getPoints() {
        return points;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
