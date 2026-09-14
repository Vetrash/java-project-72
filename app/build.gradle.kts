plugins {
    id("application")
    id("checkstyle")
    id("jacoco")
    id("gg.jte.gradle") version "3.1.12"
    id("io.freefair.lombok") version "8.6"
    id("org.sonarqube") version "7.1.0.6387"
    id("com.github.ben-manes.versions") version "0.53.0"
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:6.1.3")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("gg.jte:jte:3.1.12")
    implementation("com.h2database:h2:2.2.220")
    implementation("com.zaxxer:HikariCP:5.0.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.konghq:unirest-java:3.14.5")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.javalin:javalin-testtools:6.1.3")
    testImplementation("com.h2database:h2:2.2.220")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
}

sonar {
    properties {
        property("sonar.projectKey", "Vetrash_java-project-72")
        property("sonar.organization", "vetrash")
    }
}


tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.4"
    config = resources.text.fromFile("config/checkstyle/checkstyle.xml")
}


tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}


jte {
    generate()
    sourceDirectory.set(project.file("src/main/resources/templates").toPath())
    contentType.set(gg.jte.ContentType.Html)
}
