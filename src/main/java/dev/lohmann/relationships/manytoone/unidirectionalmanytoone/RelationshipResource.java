package dev.lohmann.relationships.manytoone.unidirectionalmanytoone;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/unidirectionalmanytoone")
public class RelationshipResource {

    @GET
    @Transactional
    public PostComment createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();

        postComment.setPost(post);
        post.persist();
        postComment.persist();

        return postComment;
    }
}