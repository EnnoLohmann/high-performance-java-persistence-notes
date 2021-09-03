package dev.lohmann.relationships.manytomany.manytomanyastwomanytoone;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_comment_post_many_to_many")
public class PostCommentPost {

    @EmbeddedId
    PostCommentPostId id;

    @ManyToOne
    @MapsId("postId")
    @JsonBackReference
    private Post post;

    @ManyToOne
    @MapsId("postCommentId")
    @JsonManagedReference
    private PostComment postComment;

    public PostCommentPost() {}

    public PostCommentPost(Post post, PostComment postComment) {
        this.post = post;
        this.postComment = postComment;

        this.id = new PostCommentPostId(post.getId(), postComment.getId());
    }

    public PostCommentPostId getId() {
        return id;
    }

    public void setId(PostCommentPostId id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentPost that = (PostCommentPost) o;
        return Objects.equals(id, that.id) && Objects.equals(post, that.post) && Objects.equals(postComment, that.postComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post, postComment);
    }
}
