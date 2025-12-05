import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import java.io.FileOutputStream
import java.net.URL

plugins {
    id("java") // Java support
    id("antlr")
    id("org.jetbrains.kotlin.jvm") version "2.2.21"
    id("org.jetbrains.intellij.platform") version "2.10.5"
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
    dependencies {
        classpath("org.antlr:antlr4:4.13.2")
    }
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

// Set the JVM language level used to build the project.
kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        java {
            srcDirs("src/main/java", "src/main/gen")
        }
    }
}

// Configure project's dependencies
repositories {
    mavenCentral()

    // IntelliJ Platform Gradle Plugin Repositories Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-repositories-extension.html
    intellijPlatform {
        defaultRepositories()
    }
}

// Dependencies are managed with Gradle version catalog - read more: https://docs.gradle.org/current/userguide/version_catalogs.html
dependencies {
    antlr("org.antlr:antlr4:4.13.2")
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.opentest4j:opentest4j:1.3.0")

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea(providers.gradleProperty("platformVersion"))

        // Plugin Dependencies. Uses `platformBundledPlugins` property from the gradle.properties file for bundled IntelliJ Platform plugins.
        bundledPlugins(providers.gradleProperty("platformBundledPlugins").map { it.split(',') })

        // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file for plugin from JetBrains Marketplace.
        plugins(providers.gradleProperty("platformPlugins").map { it.split(',') })

        // Module Dependencies. Uses `platformBundledModules` property from the gradle.properties file for bundled IntelliJ Platform modules.
        bundledModules(providers.gradleProperty("platformBundledModules").map { it.split(',') })

        testFramework(TestFrameworkType.Platform)
    }
}

// Configure IntelliJ Platform Gradle Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-extension.html
intellijPlatform {
    pluginConfiguration {
        name = providers.gradleProperty("pluginName")
        version = providers.gradleProperty("pluginVersion")

        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html#specifying-a-release-channel
        channels = providers.gradleProperty("pluginVersion").map { listOf(it.substringAfter('-', "").substringBefore('.').ifEmpty { "default" }) }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    buildPlugin {
        dependsOn(generateGrammarSource)
    }

    generateGrammarSource {
        dependsOn(getGrammar)
        //dependsOn(qulice)
        dependsOn(cleanParser)
        packageName = "org.eolang.jetbrains.parser"
        outputDirectory = File("src/main/gen")
        arguments.addAll(listOf("-Xexact-output-dir"))
    }
}
val cleanParser by tasks.registering(Delete::class) {
    delete(fileTree("src/main/gen"))
}

val qulice by tasks.registering(Exec::class) {
    workingDir = projectDir
    val mvnExecutable = if (providers.systemProperty("os.name").get().lowercase().contains("windows")) "mvn.cmd" else "/opt/homebrew/bin/mvn"
    commandLine("ls", "-l", ".")
    commandLine(
        mvnExecutable,
        "com.qulice:qulice-maven-plugin:check",
        "-e",
        "-X"
    )

    standardOutput = FileOutputStream("qulice.log")
    errorOutput = FileOutputStream("qulice-error.log")
}

val getGrammar by tasks.registering() {
    doFirst {
        val grammarFile = File("src/main/antlr/org/jetbrains/eolang/parser/Eo.g4")

        if (!grammarFile.exists()) {
            println("Created destination file: src/main/antlr/org/jetbrains/eolang/parser/Eo.g4")
        } else {
            println("File already exists. Delete it and rerun task")
            return@doFirst
        }

        println(
            "Creating and downloading grammar file from " +
                    "https://raw.githubusercontent.com/objectionary/" +
                    "eo/refs/heads/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4"
        )

        URL("https://raw.githubusercontent.com/objectionary/eo/refs/heads/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4")
            .openStream().use { input ->
                grammarFile.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

        grammarFile.appendText(
            "\n\nBAD_CHARACTER\n" +
                    "\t:\t.\t-> channel(HIDDEN)\n" +
                    "\t;"
        )

        if (grammarFile.exists()) {
            println("Grammar downloading is completed")
        }

        val content = grammarFile.readText()
        val updatedContent = content.replace("Program", "Eo")
        grammarFile.writeText(updatedContent)
    }
}

intellijPlatformTesting {
    runIde {
        register("runIdeForUiTests") {
            task {
                jvmArgumentProviders += CommandLineArgumentProvider {
                    listOf(
                        "-Drobot-server.port=8082",
                        "-Dide.mac.message.dialogs.as.sheets=false",
                        "-Djb.privacy.policy.text=<!--999.999-->",
                        "-Djb.consents.confirmation.enabled=false",
                    )
                }
            }

            plugins {
                robotServerPlugin()
            }
        }
    }
}