buildscript {

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

