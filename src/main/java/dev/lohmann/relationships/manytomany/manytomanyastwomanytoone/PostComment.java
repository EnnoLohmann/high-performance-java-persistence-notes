package dev.lohmann.relationships.manytomany.manytomanyastwomanytoone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PostcommentManyToManyAsTwoManyToOne")
@Table(name = "PostcommentManyToManyAsTwoManyToOne")
public class PostComment extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String preview;

    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<PostCommentPost> posts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public List<PostCommentPost> getPosts() {
        return posts;
    }

    public void setPosts(List<PostCommentPost> posts) {
        this.posts = posts;
    }
}
