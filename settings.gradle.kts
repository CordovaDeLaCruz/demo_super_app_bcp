pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "super_app_bcp"
include(":app")
include(":share:libs:data")
include(":share:libs:domain")
include(":share:libs:presentation")
include(":share:libs:networking")
include(":share:libs:constants")
include(":features:security:enrollment:data")
include(":features:security:enrollment:domain")
include(":features:security:enrollment:presentation")
include(":features:security:login:data")
include(":features:security:login:domain")
include(":features:security:login:presentation")
include(":features:splash:data")
include(":features:splash:domain")
include(":features:splash:presentation")
include(":features:session:home:data")
include(":features:session:home:domain")
include(":features:session:home:presentation")
