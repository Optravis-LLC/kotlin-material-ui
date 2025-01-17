group = libraryGroup
version = libraryVersion

plugins {
    kotlin("js")
    id("maven-publishing")
}

dependencies {
    api(project(":core"))

    val wrappers = Libraries.JsWrappers(kotlinVersion)
    api(wrappers.extensions)

    api(npm("@material-ui/lab", Libraries.Npm.MaterialUi.lab))

    testImplementation(kotlinTestJs)
}
