package dev.lohmann.mappingtypesandidentifiers.identitygenerators;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "Table")
public class Table extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
    @TableGenerator(name = "table_generator", allocationSize = 3)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
