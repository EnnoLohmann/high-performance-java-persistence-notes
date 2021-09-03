# Types of Relationships
## Annotations
 
- ManyToOne: Represents the child side (where the foreign key resides) in a Database one-to-many table relationship
- OneToMany: Represents the parent side of the oneToMany relationship 
- ElementCollection: Defines a oneToMany relationship between an entity and multiple value types - basic or embeddable
- OneToOne: Is used for parent and child side
- ManyToMany: Mirrors a manyToMany relationsship

## Performance
### ManyToOne Unidirektional

Because the ManyToOne-Relation controlls the foreign key directly the generated DML is very efficient.
The best performing JPA relations are on the child side of the relationship.

### ManyToOne Bidirektional

The Performance of the BiDirection ManyToOne Relationship is nearly as good as the unidirectional ManyToOne 
as long as there are not too many children. If there are Many Children the fetching can be negative for the performance.

### OneToMany Unidirektional

For the Unidirektional OneToMany relation an extra table will be create.
The Table is equivalent to the mapping Table of an ManyToMany relation and will have a negative performance impact.

### With JoinColumn

The JoinColumn Annotation can be used so that no mapping Table is needed. The Performance is better in this case but not as good as with the bi directional Mapping.

### List vs. Set

In a list hibernate tries to preserve the order of the List when deleting and adding elements. This cost performance cause it generate additional queries.
If the order is not importet you should use a set for better performance.

## Cascade

In ManyToMany Relationships the Delete Cascade Type does not make much sense. A combination of Persist and Merge should be used instead

## Conclusion

The best performing relationships are the one where the foreign Key is managed by the Child side. 