@file:Suppress("HardcodedStringLiteral")

import org.gradle.api.Project

val Project.libraryGroup get() = packages("group")
val Project.libraryVersion get() = packages("version")
