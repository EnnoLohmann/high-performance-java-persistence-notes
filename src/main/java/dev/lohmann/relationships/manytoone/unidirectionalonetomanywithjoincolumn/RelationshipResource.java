package dev.lohmann.relationships.manytoone.unidirectionalonetomanywithjoincolumn;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/unidirectionalonetomanyjoincolumn")
public class RelationshipResource {

    @GET
    @Transactional
    public Post createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();
        post.addComment(postComment);
        post.persist();
        postComment.persist();

        return post;
    }
}