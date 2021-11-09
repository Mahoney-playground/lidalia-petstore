import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterPlugin

val javaVersion by extra(JavaLanguageVersion.of(17))

plugins {
  base
  kotlin("jvm") version "1.6.0-RC2" apply false
  id("org.jmailen.kotlinter") version "3.6.0"
  id("com.github.ben-manes.versions") version "0.39.0"
}

allprojects {
  group = "uk.org.lidalia.petstore"
  version = "0.1.0"

  repositories {
    mavenCentral()
  }
  apply<KotlinterPlugin>()
}

subprojects {

  pluginManager.withPlugin("kotlin") {
    configure<JavaPluginExtension> {
      toolchain {
        languageVersion.set(javaVersion)
      }

      consistentResolution {
        useCompileClasspathVersions()
      }
    }

    configurations.all {
      resolutionStrategy {
        failOnNonReproducibleResolution()
      }
    }

    dependencies {

      val testImplementation by configurations

      testImplementation(libs.kotest.runnerJunit5)
    }

    tasks {

      withType<KotlinCompile>().configureEach {
        kotlinOptions.apply {
          jvmTarget = javaVersion.toString()
//                    freeCompilerArgs = listOf("-Xinline-classes")
        }
      }

      named<Test>("test") {
        environment("BUILD_SYSTEM", "GRADLE")
        useJUnitPlatform()
//        jvmArgs(
//          "-Xshare:off",
//          "--illegal-access=deny"
//        )
      }
    }

    kotlinter {
      reporters = arrayOf("checkstyle", "plain", "html")
    }
  }
}

tasks {
  check {
    dependsOn("installKotlinterPrePushHook")
  }
}
