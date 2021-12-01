import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
}

repositories {
   mavenCentral()
}

dependencies {
    testApi("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.assertj:assertj-core:3.18.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
