package dev.lohmann.relationships.manytomany.manytomanyastwomanytoone;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/ManyToManyAsTwoManyToOne")
public class RelationshipResource {

    @GET
    @Transactional
    public Post createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();
        post.persist();
        postComment.persist();
        post.addComment(postComment);
        post.persist();
        postComment.persist();

        return post;
    }
}