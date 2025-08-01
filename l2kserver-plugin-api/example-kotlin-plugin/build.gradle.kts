plugins {
    kotlin("jvm") version "2.0.21"
    id("com.google.devtools.ksp") version "2.0.21-1.0.27"
}

group = "org.l2kserver"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":l2kserver-plugin-api"))
    ksp(project(":l2kserver-plugin-api"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}