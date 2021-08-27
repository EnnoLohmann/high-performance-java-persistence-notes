package dev.lohmann.relationships.manytoone.unidirectionalonetomany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity(name = "PostcommentUniDirectionalOneToMany")
@Table(name = "PostcommentUniDirectionalOneToMany")
public class PostComment extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String preview;

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
}
