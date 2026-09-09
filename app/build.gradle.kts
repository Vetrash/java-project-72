plugins {
    id("application")
    id("checkstyle")
    id("jacoco")
    id("io.freefair.lombok") version "8.6"
    id("org.sonarqube") version "7.1.0.6387"
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.12"
}

dependencies {
    // Javalin - используем только bundle и jte
    implementation("io.javalin:javalin:6.3.0")
    implementation("io.javalin:javalin-rendering:6.1.6")

    // Логирование
    implementation("org.slf4j:slf4j-simple:2.0.18")

    // База данных
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("com.h2database:h2:2.2.224")

    // Шаблонизатор JTE
    implementation("gg.jte:jte:3.1.12")

    // HTTP клиент для проверок URL
    implementation("com.konghq:unirest-java-core:4.4.0")

    // Парсинг HTML
    implementation("org.jsoup:jsoup:1.17.2")

    // Jackson для работы с JSON/YAML (версия, совместимая с Javalin)
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.2")

    implementation("info.picocli:picocli:4.7.6")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation("io.javalin:javalin-bundle:6.1.3")
}

sonar {
    properties {
        property("sonar.projectKey", "ponttor_java-project-71")
        property("sonar.organization", "ponttor")
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

application {
    mainClass.set("hexlet.code.App")
}
