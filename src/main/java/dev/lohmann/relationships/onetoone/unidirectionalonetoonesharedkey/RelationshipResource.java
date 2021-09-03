package dev.lohmann.relationships.onetoone.unidirectionalonetoonesharedkey;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/relationships/unidirectionalonetooneSharedKey")
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