plugins {
    id("java")
    id("io.freefair.lombok") version "6.5.1"
    id("org.springframework.boot") version "2.7.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
    testImplementation("com.fasterxml.jackson.core:jackson-annotations:2.13.3")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    testCompileOnly ("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.24")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("junit:junit:4.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.2.11")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}