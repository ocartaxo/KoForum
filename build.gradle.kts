/*
 * Copyright (c) 2022. Otávio Cartaxo (@_otaviocrtx)
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id ("org.jetbrains.kotlin.plugin.jpa") version "1.6.10"
//	id("org.jetbrains.kotlin.plugin.noarg") version "1.6.10"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("kapt") version "1.5.10"
}

group = "br.com.alura"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.10")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.10")
	developmentOnly("org.springframework.boot:spring-boot-devtools")


	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	val h2Version = "2.1.212"
	runtimeOnly("com.h2database:h2:$h2Version")
	testImplementation("com.h2database:h2:$h2Version")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	val mapstructVersion = "1.4.2.Final"
	api("org.mapstruct:mapstruct:$mapstructVersion")
	kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
