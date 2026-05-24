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

## Layout
.idea: IDE specific folder
.mvn : maven properties, gives us all the registry installation details  : npmjs equivalent
mvnw : present at the project level, so that everytime we dont have to install
src/ : source code
pom.xml : in xml format, the package.json equivalent, has all the dependencies mentioned here

src/
    - main/ : 
    - test/ : write your unit test cases
    - main/resources/application.yaml : config of springboot application, allows you to enable flags, add db, credentials, config setup
    - main/java/folder/AppName.java : This is the main class with the one main file

When you run it, a target folder is created, and all the .class files are stored there now.

It will show an error, with a description mentioned there :
here we have to add db url as well 

```yaml
spring:
    application:
        name: CreatorStore
    datasource:
        url:
        username:
        password:    
```
For springboot, we can add 
## DB
Direct
Session Pooler, not Driect connection 
Type: JDBC

Add url, remove username and password from url, put them in the username and password fields

got to maven repository, get dotenv, paste it in the pom.xml dependency folder

then load dotenv in the Main src/main/java/AppName.java file: 
```java
 Dotenv dotenv = Dotenv.configure()  .ignoreIfMissing().load();
        dotenv.entries().forEach((entry)->System.setProperty(
                entry.getKey(), entry.getValue()
    ));
```
Then update datasource : url: ${DATABASE_URL}
with this kind of representation.

## Adding new files
Follow uniform structure, create a package in the folder inside the java folder, ex: entities

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>


This one allows for adding Minimum and Max
- Add 
Hibernate handles all the SQL conversion, adds constrains and migrates the DB properly. 