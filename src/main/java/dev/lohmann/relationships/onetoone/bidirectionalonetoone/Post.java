package dev.lohmann.relationships.onetoone.bidirectionalonetoone;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;

@Entity(name = "PostBiDirectionalOneToOne")
@Table(name = "PostBiDirectionalOneToOne")
public class Post extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    PostComment postComment;

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

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        postComment.setPost(this);
        this.postComment = postComment;
    }
}
