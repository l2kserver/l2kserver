plugins {
    id("java")
}

group = "org.l2kserver"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":l2kserver-plugin-api"))
    implementation(project(":l2kserver-game-model"))

    annotationProcessor(project(":l2kserver-plugin-api"))
}

tasks.test {
    useJUnitPlatform()
}