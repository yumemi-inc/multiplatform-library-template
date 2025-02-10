package io.yumemi.something.buildlogic.publish

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.api.publish.maven.MavenPomDeveloperSpec
import org.gradle.api.publish.maven.MavenPomLicenseSpec

private const val LibraryName = "something" // TODO set library name
private const val LibraryUrl = "https://github.com/yumemi-inc/Something/" // TODO set library url

private const val ScmUrl = "https://github.com/yumemi-inc/Something/" // TODO set scm url
private const val ScmConnection = "scm:git:git://github.com/yumemi-inc/Something.git" // TODO set scm connection
private const val ScmDeveloperConnection = "scm:git:git://github.com/yumemi-inc/Something.git" // TODO set scm developer connection

internal fun MavenPublishBaseExtension.pom() {
    pom {
        name.set(LibraryName)
        description.set("A Kotlin Multiplatform Flux framework.")
        inceptionYear.set("2024")
        url.set(LibraryUrl)
        licenses {
            mit()
        }
        developers {
            yumemiInc()
        }
        scm {
            url.set(ScmUrl)
            connection.set(ScmConnection)
            developerConnection.set(ScmDeveloperConnection)
        }
    }
}

private fun MavenPomLicenseSpec.mit() {
    license {
        name.set("MIT")
        url.set("https://opensource.org/licenses/MIT")
        distribution.set("https://opensource.org/licenses/MIT")
    }
}

private fun MavenPomDeveloperSpec.yumemiInc() {
    developer {
        id.set("yumemi-inc")
        name.set("YUMEMI Inc.")
        url.set("https://github.com/yumemi-inc/")
    }
}
