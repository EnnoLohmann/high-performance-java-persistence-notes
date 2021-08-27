package dev.lohmann.relationships.manytoone.unidirectionalonetomanywithjoincolumn;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PostUniDirectionalOneToManyJoinColumn")
@Table(name = "PostUniDirectionalOneToManyJoinColumn")
public class Post extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    @JsonManagedReference
    private List<PostComment> comments = new ArrayList<>();

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Helper Methods to keep Parent and Child in sync
    public void addComment(PostComment postComment) {
        comments.add(postComment);
    }

    public void removeComment(PostComment postComment) {
        comments.remove(postComment);
    }
}
