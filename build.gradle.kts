plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
//    implementation(kotlin("script-runtime"))
}

tasks.register("hello") {
    doFirst {
        println("Hello")
    }

    doLast {
        println("Bye")
    }

}

tasks.test {
    useJUnitPlatform()
}