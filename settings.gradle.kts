
pluginManagement {
    plugins {
        id("com.google.cloud.tools.jib").version("3.3.0")
    }
    includeBuild("gradle/plugins/settings")
}

plugins {
//    id("org.janusgraph.settings")
}

rootProject.name = "janusgraph-pods"

