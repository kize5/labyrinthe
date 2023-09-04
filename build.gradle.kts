plugins {
    id("java")
    application
}

group = "edu.campusnum.algo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("edu.campusnum.algo.maze.Main")

}

sourceSets {
    main {
        resources {
            srcDir("src/main/resources")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.processResources{
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}