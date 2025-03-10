import com.vanniktech.maven.publish.SonatypeHost
import io.yumemi.something.buildlogic.PublishConventionExtension
import io.yumemi.something.buildlogic.dsl.alias
import io.yumemi.something.buildlogic.dsl.libs
import io.yumemi.something.buildlogic.dsl.mavenPublishing
import io.yumemi.something.buildlogic.dsl.plugin
import io.yumemi.something.buildlogic.publish.pom
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

@Suppress("unused")
class PublishConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.alias(libs.plugin("vanniktech-mavenPublish"))

            mavenPublishing {
                publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

                if (System.getenv("ORG_GRADLE_PROJECT_mavenCentralUsername") != null) {
                    signAllPublications()
                }

                pom()
            }

            val publishConvention = extensions.create("publishConvention", PublishConventionExtension::class)

            afterEvaluate {
                publishConvention.applyToProject(target)
            }
        }
    }
}
