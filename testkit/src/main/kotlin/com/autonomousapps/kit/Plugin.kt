package com.autonomousapps.kit

class Plugin @JvmOverloads constructor(
  val id: String,
  val version: String? = null,
  val apply: Boolean = true
) {

  companion object {
    const val KOTLIN_VERSION = "1.5.31"

    @JvmOverloads
    @JvmStatic
    fun of(
      id: String,
      version: String? = null,
      apply: Boolean = true
    ): Plugin = Plugin(id, version, apply)

    @JvmStatic
    val dagpId = "com.autonomousapps.dependency-analysis"

    @JvmStatic
    val dependencyAnalysisPlugin = Plugin(
      dagpId,
      System.getProperty("com.autonomousapps.pluginversion")
    )

    @JvmStatic val androidAppPlugin = Plugin("com.android.application")
    @JvmStatic val androidLibPlugin = Plugin("com.android.library")
    @JvmStatic val antlrPlugin = Plugin("antlr")
    @JvmStatic val applicationPlugin = Plugin("application")
    @JvmStatic val gradleEnterprisePlugin = Plugin("com.gradle.enterprise", "3.7")
    @JvmStatic val javaGradlePlugin = Plugin("java-gradle-plugin")
    @JvmStatic val javaPlugin = Plugin("java")
    @JvmStatic val javaLibraryPlugin = Plugin("java-library")
    @JvmStatic val kaptPlugin = Plugin("org.jetbrains.kotlin.kapt")
    @JvmStatic val kotlinAndroidPlugin = Plugin("kotlin-android")
    @JvmStatic val kotlinPluginNoVersion = Plugin("org.jetbrains.kotlin.jvm", null, true)
    @JvmStatic val springBootPlugin = Plugin("org.springframework.boot", "2.3.1.RELEASE")

    @JvmStatic
    fun kotlinPlugin(version: String? = KOTLIN_VERSION, apply: Boolean = true): Plugin {
      return Plugin("org.jetbrains.kotlin.jvm", version, apply)
    }
  }

  override fun toString(): String {
    var s = "id '$id'"
    if (version != null) {
      s += " version '$version'"
    }
    if (!apply) {
      s += " apply false"
    }
    return s
  }
}
