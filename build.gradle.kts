import com.google.cloud.tools.jib.api.buildplan.ImageFormat

plugins {
    id("java")
    id("com.google.cloud.tools.jib")
}

group = "org.janusgraph"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

jib {
    to {
      image = "foo"
    //      image = "gcr.io/janusgraph-pods/image-built-with-jib"
    }
    container {
        mainClass = "org.janusgraph.Main"
        format = ImageFormat.OCI
    }
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-core
    implementation("org.janusgraph:janusgraph-core:0.6.2")
    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-cql
    implementation("org.janusgraph:janusgraph-cql:0.6.2")
    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-es
    implementation("org.janusgraph:janusgraph-es:0.6.2")
    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-driver
    implementation("org.janusgraph:janusgraph-driver:0.6.2")
    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-server
    implementation("org.janusgraph:janusgraph-server:0.6.2")
    // https://mvnrepository.com/artifact/org.janusgraph/janusgraph-all
    implementation("org.janusgraph:janusgraph-all:0.6.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}