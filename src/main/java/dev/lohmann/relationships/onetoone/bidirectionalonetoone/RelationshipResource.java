package dev.lohmann.relationships.onetoone.bidirectionalonetoone;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/bidirectionalonetoone")
public class RelationshipResource {

    @GET
    @Transactional
    public PostComment createmanytooneObject() {
        Post post = new Post();
        PostComment postComment = new PostComment();

        post.setPostComment(postComment);
        post.persist();
        postComment.persist();

        return postComment;
    }
}