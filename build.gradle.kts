plugins {
    kotlin("jvm")
    id("fabric-loom")
    `maven-publish`
    java
}

base.archivesName.set(property("archives_base_name") as String)

group = property("maven_group")!!
version = property("mod_version")!!

repositories {
    maven { url = uri("https://maven.blamejared.com") }

    maven { url = uri("https://api.modrinth.com/maven") }

    maven { url = uri("https://maven.shedaniel.me/") }
    maven { url = uri("https://maven.terraformersmc.com/releases/") }
    maven {
        name = "KosmX's maven"
        url = uri("https://maven.kosmx.dev/")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

    modImplementation("net.fabricmc:fabric-language-kotlin:${property("fabric_kotlin_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")

    // Patchouli
    modImplementation("vazkii.patchouli:Patchouli:${property("patchouli")}")

    //BetterCombat
    modImplementation("maven.modrinth:better-combat:${property("better_combat")}-fabric")
    modApi("me.shedaniel.cloth:cloth-config-fabric:${property("cloth_config")}")
    modImplementation("dev.kosmx.player-anim:player-animation-lib-fabric:${property("player_anim")}")
}

tasks {

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifact(remapJar) {
                    builtBy(remapJar)
                }
                artifact(kotlinSourcesJar) {
                    builtBy(remapSourcesJar)
                }
            }
        }

        // select the repositories you want to publish to
        repositories {
            // uncomment to publish to the local maven
            // mavenLocal()
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}


// configure the maven publication
