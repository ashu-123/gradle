plugins {
    id("java")
    id("application")
    id("org.flywaydb.flyway") version("6.3.2")
}

java {
//    sourceCompatibility  = JavaVersion.VERSION_1_8;
//    targetCompatibility = JavaVersion.VERSION_1_8;
    withJavadocJar();
    withSourcesJar();
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "org.example.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
//    implementation(kotlin("script-runtime"))
}

repositories {
    flatDir {
//        dirs.add(File("libs"))
    }
}

sourceSets {
    main {
        java {
//            setSrcDirs(listOf("ja"))
        }
    }

    test {
        java {
//            setSrcDirs(listOf("test/src"))
        }
    }
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