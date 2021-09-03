package dev.lohmann.relationships.manytomany.bidirectionalmanytomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PostBiDirectionalManyToMany")
@Table(name = "PostBiDirectionalManyToMany")
public class Post extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "post_comment_many_to_many_unidirectional"
            , joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
            @JsonManagedReference
    List<PostComment> postComments = new ArrayList<>();

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
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
        postComments.add(postComment);
        postComment.getPosts().add(this);
    }

    public void removeComment(PostComment postComment) {
        postComments.remove(postComment);
        postComment.getPosts().remove(this);
    }
}
