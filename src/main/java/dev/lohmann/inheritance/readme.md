# Inheritance
## Types of Inheritance
- Single Table Inheritance: A single database Table for all classes in the inheritane hierarchy
- Class Table Inheritance: Each Class is mapped to a Table. The Inheritance is resolved through joins.
- Concrete Table Inheritance: Each Table definies all fields for the subclass and parent class.

If the Imnheritance is only in the Domain model and should not be mapped to the Database you can use @MappedSuperclass

## Performance

### Single Table

Since all fields are in one Table and no joins are needed this performance is fast.
NOT_NULL Constraints are not allowed in subclasses-
Data Integry needs to be checked in the Data Access Layer or with Database Triggers or Check Coinstraints

### Joined

Allows NOT_NULL. When writing Data Hibernate needs 2 Insert Statments for each subclass entity. 
Index Memory Footprint is growing cause there are multiple Tables.
Reading polymorphic queries requires joins which reduces the Performance.

### Table Per Class
Write Operations and queries for a concrete class are fast. Polimorphic queries are slow because Hibernate need to generate the result through a union of subqueries for every type

### Mapped Superclass
Very good performance but no support for polimorphic queries and associations

## Best Practices
All of the Inheritance Models have their tradeoffs to fill the gap between oop and Database.
Single Table performs best for reading and writing data but needs the overcome the nullable problem.
Join Table is worth when there are many subclasses and there is no need for polymorphic queries.
Table-Per-Class is the least performant when it comes to polymorphic queries or associations.
If each Subclass is stored in an own Table the MappedSuperclass could be an alternative.
