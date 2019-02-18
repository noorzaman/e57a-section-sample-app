# Project Title

I will use this tutorial to explore/demo topics presented by Vitaly within E-57a's lectures.  As I add additional functionality, I will TAG the version with a description below.

## Getting Started

First, decide on which TAG you are interested in.  

### TAG descriptions:
#### v1 : Spring Boot app with JPA and H2
This  project demos a very simple Spring Boot project with the the following features:
1. H2 in mememory database integration
2. JPA
3. Spring @Repository
3. Thymeleaf
4. Spring MVC
5. Spring @RestConstroller
6. Spring devtools

An H2 embedded (in project) in-memory simple relational database that developers use for demoing/trying out code that requires a database.  Spring Boot takes the H2 DB to the next level with its opinionated nature of configuration for H2.  With only adding the H2 and JPA Spring dependencies add,  Spring will generate/load DDL from the scanned Entities in your project to create the DB tables.  It also takes care of the connection setup.  You only need to be concerned with writing your JPA entities and Spring Repositories.

Here is a [good overview of H2](http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database)

#### v2 : Includes Docker
This TAG contains contents of v1 + Docker file, run script, and Maven Spotify Docker plugin

#### (additional TAGs will appear here)

### Prerequisites

1. Java 1.8
2. Docker

### Installing / Running

You can then clone a specific TAG (e.g., -b v1 is for tag v1) with the following command:
```
git clone -b v2 --single-branch https://github.com/LouisSavoldy/e57a-section-sample-app.git
```

Create a Docker image
```
mvn clean package docker:build
```

View Docker images
```
docker images

REPOSITORY                       TAG                 IMAGE ID            CREATED             SIZE
e-57a-section/sample-service     v2                  eaa68861fdd0        About an hour ago   142MB
```

Start container from image
```
docker run e-57a-section/sample-service:v2
```

## Authors

* **Louis Savoldy** - with content from e57a's lectures (Vitaly Yurik) and Spring Microservices in Action (John Carnell)
