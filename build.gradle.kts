plugins {
    id("java")
    id("org.flywaydb.flyway") version("6.3.2")
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

tasks.register("hello-again") {
    dependsOn("hello")

    doLast {
        println("Finished")
    }
}

tasks.test {
    useJUnitPlatform()
}