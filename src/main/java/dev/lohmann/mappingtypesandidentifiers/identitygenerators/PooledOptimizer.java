package dev.lohmann.mappingtypesandidentifiers.identitygenerators;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "Pooled")
public class PooledOptimizer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pooled_generator")
    @GenericGenerator(name = "pooled_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "pooled_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "42"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "5"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")
    })
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
