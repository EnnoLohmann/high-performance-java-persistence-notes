package dev.lohmann.relationships.onetoone.unidirectionalonetoonesharedkey;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity(name = "PostcommentUniDirectionalOneToOneSharedKey")
@Table(name = "PostcommentUniDirectionalOneToOneSharedKey")
public class PostComment extends PanacheEntityBase {
    @Id
    private Long id;

    private String preview;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
