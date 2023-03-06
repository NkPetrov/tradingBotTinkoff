
plugins {
    idea
    java
    id("org.springframework.boot") version "2.7.4"
    id("com.google.protobuf") version "0.9.2"
}
apply(plugin = "io.spring.dependency-management")

group = "org.example"
version = "1.0-SNAPSHOT"


object Versions {
    const val protobuf = "3.19.3"
    const val grpc = "1.43.0"
    const val lombok = "1.18.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")

    implementation("io.grpc:grpc-okhttp:${Versions.grpc}")
    implementation("io.grpc:grpc-protobuf:${Versions.grpc}")
    implementation("io.grpc:grpc-stub:${Versions.grpc}")
    implementation("com.google.protobuf:protobuf-java:${Versions.protobuf}")

    implementation("org.projectlombok:lombok:${Versions.lombok}")
    annotationProcessor("org.projectlombok:lombok:${Versions.lombok}")
    testAnnotationProcessor("org.projectlombok:lombok:${Versions.lombok}")

    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("junit:junit:4.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.2.11")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}