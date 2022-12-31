import com.soywiz.korge.gradle.*

buildscript {
  repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven { url = uri("https://plugins.gradle.org/m2/") }
  }
  dependencies {
    classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:3.4.0")
  }
}
apply<KorgeGradlePlugin>()
korge {
  id = "net.liplum.MinesweeperKt"
  jvmMainClassName = "net.liplum.MainKt"
// To enable all targets at once

  //targetAll()

// To enable targets based on properties/environment variables
  //targetDefault()

// To selectively enable targets

  targetJvm()
  //targetJs()
  //targetDesktop()
  //targetIos()
  //targetAndroidIndirect() // targetAndroidDirect()
}
