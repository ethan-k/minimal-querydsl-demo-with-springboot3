# QueryDSL Minimal Example with Springboot 3 and gradle (Kotlin DSL)

## Prerequisites

* Java 17 
* Any docker container runner


## How to start a project


```bash
# Start database 
docker-compose up -d

# Run application
./gradlew bootRun
```



## Notes

Please the below dependencies are necessary to generate query types

```kotlin
plugins {
    kotlin("kapt") version "1.7.22"
}
dependencies {
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")
}
```