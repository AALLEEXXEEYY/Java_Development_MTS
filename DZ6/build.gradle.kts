plugins {
    id("java")
}

group = "ru.mts"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework:spring-context:5.2.25.RELEASE")
    implementation ("org.springframework:spring-core:5.2.25.RELEASE")
    implementation ("org.springframework:spring-beans:5.2.25.RELEASE")
    implementation ("javax.annotation:javax.annotation-api:1.3.2")
    testImplementation("org.springframework:spring-test:5.2.25.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter:2.1.3.RELEASE")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}