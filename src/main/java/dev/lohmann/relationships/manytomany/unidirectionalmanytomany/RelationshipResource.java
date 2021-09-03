package dev.lohmann.relationships.manytomany.unidirectionalmanytomany;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/unidirectionalmanytoMany")
public class RelationshipResource {

    @GET
    @Transactional
    public Post createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();

        post.getPostComments().add(postComment);
        post.persist();
        postComment.persist();

        return post;
    }
}