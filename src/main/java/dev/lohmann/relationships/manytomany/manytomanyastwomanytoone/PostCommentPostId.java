package dev.lohmann.relationships.manytomany.manytomanyastwomanytoone;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostCommentPostId implements Serializable {

    private long postId;

    private long postCommentId;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getPostCommentId() {
        return postCommentId;
    }

    public void setPostCommentId(long postCommentId) {
        this.postCommentId = postCommentId;
    }

    public PostCommentPostId(long postId, long postCommentId) {
        this.postId = postId;
        this.postCommentId = postCommentId;
    }

    public PostCommentPostId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentPostId that = (PostCommentPostId) o;
        return postId == that.postId && postCommentId == that.postCommentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postCommentId);
    }
}
