springboot will do all they heavy work
our job is the make the design of the project, routes, map the strucuture out, etc.

springboot is highly opinionated

## to set up install Intellij
config: YAML
select springboot project
Type: maven
group, artifact, package name, 
JDK: latest or local one
packaging: Jar
Next

select latest springboot version
Language: java
Type maven
Packajing JAr

- Add dependencies as needed
1. PostgreSQL driver
2. Lombok (getter and setter utilities)
3. spring web(enables us to use REST apis)
4. Spring data JPA : acts like ORM, converts it to swl db
5. openAPI spec: for documentation