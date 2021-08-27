package dev.lohmann.mappingtypesandidentifiers.identitygenerators;

import dev.lohmann.mappingtypesandidentifiers.identitygenerators.Identity;
import dev.lohmann.mappingtypesandidentifiers.identitygenerators.PooledOptimizer;
import dev.lohmann.mappingtypesandidentifiers.identitygenerators.Sequence;
import dev.lohmann.mappingtypesandidentifiers.identitygenerators.Table;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/identitygenerators")
public class IdentityGeneratorsResource {

    @GET
    @Transactional
    @Path("/identity")
    public Long createIdentityObject() {
        Identity identity = new Identity();
        identity.persist();
        return identity.getId();
    }

    @GET
    @Transactional
    @Path("/sequence")
    public Long createSequenceObject() {
        Sequence sequence = new Sequence();
        sequence.persist();
        return sequence.getId();
    }

    @GET
    @Transactional
    @Path("/table")
    public Long createTableObject() {
        Table table = new Table();
        table.persist();
        return table.getId();
    }

    @GET
    @Transactional
    @Path("/pooled")
    public Long createPooledObject() {
        PooledOptimizer pooled = new PooledOptimizer();
        pooled.persist();
        return pooled.getId();
    }
}