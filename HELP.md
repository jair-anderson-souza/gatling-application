# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '16' to '11', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.
* The original package name 'io.github.jass2125.webflux-vs-mvc' is invalid and this project uses 'io.github.jass2125.webfluxvsmvc' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/gradle-plugin/reference/html/#build-image)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/2.4.5/reference/html/spring-boot-features.html#boot-features-r2dbc)

### Guides
The following guides illustrate how to use some features concretely:

* [Acessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [R2DBC Homepage](https://r2dbc.io)

## Missing R2DBC Driver

Make sure to include a [R2DBC Driver](https://r2dbc.io/drivers/) to connect to your database.
