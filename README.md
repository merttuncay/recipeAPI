# RECIPE API
## Introduction

A comprehensive solution for storing and retrieving recipe XML files. 
With this tool, you can easily save recipes in XML format to a database, while also organizing them by categories and recipe names.
The API enables efficient searching and filtering, allowing you to quickly access recipes based on specific preferences. 
Seamlessly integrate this API into your applications, websites, or platforms, and enjoy the scalability, reliability, and ease of managing your recipe collection. 
Simplify your recipe management process and provide an exceptional user experience with the Recipe API.

## Requirements
For building and running the application you need:

- [JDK 18](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)

### Database

As Database, PostgreSQL was used. You could find the [DDL file](./src/main/resources/database-scripts/MendixDatabaseDDL.sql)  for schema and table creation for the database.

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.recipeapi.RecipeApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Guides and Dependencies

You could find the following libraries that I use:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#features.docker-compose)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
