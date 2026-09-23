plugins {
    kotlin("jvm") version "2.4.0"
    id("io.ktor.plugin") version "3.1.1"
    kotlin("plugin.serialization") version "2.3.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-netty:3.6.0")
    implementation("io.ktor:ktor-server-content-negotiation:3.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.11.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.6.0")
    implementation("io.ktor:ktor-server-status-pages:3.6.0")
}

application {
    mainClass.set("KtorSampleKt")
}
