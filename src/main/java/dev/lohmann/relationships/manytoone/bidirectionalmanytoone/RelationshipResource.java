package dev.lohmann.relationships.manytoone.bidirectionalmanytoone;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/bidirectionalmanytoone")
public class RelationshipResource {

    @GET
    @Transactional
    public Post createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();

        post.addComment(postComment);
        post.persist();

        return post;
    }

}