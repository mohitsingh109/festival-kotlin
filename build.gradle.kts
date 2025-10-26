plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.allopen") version "2.0.20" // make classes open so we can use the (@Entity)
    kotlin("plugin.jpa") version "2.0.20" // JPA + Kotlin Integration
    kotlin("kapt")  version "2.0.20" // Kotlin annotation processing tool
    id("io.quarkus") version "3.20.2" // we'll use this to run the application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//val quarkusPlatformGroup: String by project
//val quarkusPlatformArtifact: String by project
//val quarkusPlatformVersion: String by project

dependencies {
    // BOM quarkus --> (10, 15)
    //implementation(enforcedPlatform("$quarkusPlatformGroup:$quarkusPlatformArtifact:$quarkusPlatformVersion"))
    // TODO We need to move it to platform version
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:3.28.3"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.2.20") // Onion
    implementation("io.quarkus:quarkus-arc:3.28.3")
    implementation("io.quarkus:quarkus-jackson:3.28.3") // Json String to Object or vice versa
    implementation("io.quarkus:quarkus-hibernate-validator:3.28.3") // This is giving the Size function that does the validation of min, max
    implementation("io.quarkus:quarkus-kotlin:3.28.3")
    implementation("io.quarkus:quarkus-liquibase")
    implementation("io.quarkus:quarkus-rest")
    implementation("io.quarkus:quarkus-rest-jackson")
    implementation("org.mapstruct:mapstruct:1.6.3") // Use to map field from one object to other
    kapt("org.mapstruct:mapstruct-processor:1.6.3") // Build folder it will create a implementation
    implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin:3.28.3")  // This is for doing database stuff like auto create table or mapping DB row wih kotlin object
    implementation("io.quarkus:quarkus-jdbc-postgresql") // this one is creating the postgresql as test container
    implementation("io.quarkus:quarkus-hibernate-validator")
    testImplementation(kotlin("test"))
    testImplementation("io.quarkus:quarkus-junit5:3.28.3")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperClass")
    // ...
}

//Json String to Object or vice versa
// Use reflection
// 1. create object with default constructor
// 2. call the setter to set the values
