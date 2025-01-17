import java.text.SimpleDateFormat

plugins {
    signing
    `maven-publish`
}

val siteUrl = "https://github.com/subroh0508/kotlin-material-ui"
val githubUrl = "https://github.com/subroh0508/kotlin-material-ui"

val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ")

publishing {
    publications {
        create<MavenPublication>("kotlin") {
            from(components["kotlin"])
            artifact(tasks.getByName<Zip>("jsLegacySourcesJar"))
            groupId = libraryGroup
            artifactId = project.name
            version = libraryVersion

            metadata()
        }
    }
    val repoNameSuffix = when (project.name) {
        "lab" -> "-Lab"
        "pickers" -> "-Pickers"
        "date-io" -> "-DateIO"
        "date-fns" -> "-DateIO-date-fns"
        else -> ""
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Optravis-LLC/kotlin-material-ui")
            credentials {
                username = "Optravis-LLC"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

fun MavenPublication.metadata() {
    pom {
        name.set("Kotlin-Material-UI${if (project.name == "core") "" else "/Lab"}")
        description.set("Kotlin Wrapper Library of Material-UI")
        url.set(githubUrl)

        licenses {
            license {
                name.set("The MIT Licenses")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("subroh0508")
                name.set("Subroh Nishikori")
                email.set("in-the-n@me-of.love")
            }
        }

        scm {
            url.set(githubUrl)
        }
    }
}
