plugins {
    kotlin("jvm") version "2.0.21"
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
    implementation("io.quarkus:quarkus-jackson:3.28.3")
    implementation("io.quarkus:quarkus-hibernate-validator:3.28.3") // This is giving the Size function that does the validation of min, max
    implementation("io.quarkus:quarkus-kotlin:3.28.3")
    implementation("org.mapstruct:mapstruct:1.6.3")
    implementation("org.mapstruct:mapstruct-processor:1.6.3")
    implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin:3.28.3")  // This is for doing database stuff like auto create table or mapping DB row wih kotlin object
    testImplementation(kotlin("test"))
    testImplementation("io.quarkus:quarkus-junit5:3.28.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}