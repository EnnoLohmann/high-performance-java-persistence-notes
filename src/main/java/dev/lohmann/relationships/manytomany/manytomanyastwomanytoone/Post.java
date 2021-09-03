package dev.lohmann.relationships.manytomany.manytomanyastwomanytoone;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity(name = "PostManyToManyAsTwoManyToOne")
@Table(name = "PostManyToManyAsTwoManyToOne")
public class Post extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<PostCommentPost> postComments = new ArrayList<>();

    public List<PostCommentPost> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostCommentPost> postComments) {
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
        postComments.add(new PostCommentPost(this, postComment));

    }

    public void removeComment(PostComment postComment) {
        for(Iterator<PostCommentPost> iterator = postComments.iterator(); iterator.hasNext();) {
            PostCommentPost postCommentPost = iterator.next();
            if(postCommentPost.getPost().equals(this) && postCommentPost.getPostComment().equals(postComment)) {
                iterator.remove();
                postCommentPost.getPostComment().getPosts().remove(postCommentPost);
                postCommentPost.setPost(null);
                postCommentPost.setPostComment(null);
                break;
            }
        }
    }
}
