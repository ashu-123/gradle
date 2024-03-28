import com.adarshr.gradle.testlogger.theme.ThemeType
import org.gradle.api.tasks.testing.logging.TestLogEvent

val log4j_version: String by project
val jaxb_version: String by project
val junit_version: String by project

// Multi-project build configurations

// ALL PROJECTS CONFIGURATION
//allprojects {
//    apply(plugin = "java")
//    version = "1.0-SNAPSHOT"
//}

// PER PROJECT BASIS CONFIGURATION
//project(":Repository") { }
//
//project(":jacketService") {
//    dependencies {
//        implementation(project(":Repository"))
//    }

// SUB PROJECTS CONFIGURATION
//subprojects {
//    dependencies {
//        implementation("org.hamcrest:hamcrest-core:${hamcrest_version}")
//    }
//
//    java {
//        sourceCompatibility = JavaVersion.VERSION_13;
//    }
//}

//listOf("Repository").forEach { name ->
//    project(":$name") {
//        tasks.register("migrate") { }
//    }
//}
//}

plugins {
//    id("java")
//    id("java-library")
    id("application")
    id("org.flywaydb.flyway") version("6.3.2")
    id("com.adarshr.test-logger") version("2.0.0")
    id("jacoco")
}

java {
//    sourceCompatibility  = JavaVersion.VERSION_1_8;
//    targetCompatibility = JavaVersion.VERSION_1_8;
//    withJavadocJar();
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
    implementation("log4j:log4j:$log4j_version")
    implementation("javax.xml.bind:jaxb-api:$jaxb_version")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
//    testImplementation("junit:junit:$junit_version")
//    implementation(kotlin("script-runtime"))
}

//repositories {
//    flatDir {
//        dirs("")
//    }
//}

repositories {
    mavenCentral()
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
    testLogging.events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED)
}

testlogger {
    showSkipped = true
    showPassed = true
    showFailed = true
    theme = ThemeType.MOCHA_PARALLEL
}

tasks.register<Test>("singleTest") {
    group = "Verification"
    description = "Runs single test"
    dependsOn("testClasses")
    useJUnitPlatform()
    testLogging.events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
    filter {
        includeTestsMatching("org.example.MainTest.testMe")
    }
}