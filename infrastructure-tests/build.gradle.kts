plugins {
  kotlin("jvm")
}

dependencies {
//  implementation(libs.kotlin.shell.core)
  implementation(libs.executor)
  implementation(platform("org.http4k:http4k-bom:4.17.0.0"))
  implementation( "org.http4k:http4k-core")
  implementation( "org.http4k:http4k-server-undertow")
  implementation( "org.http4k:http4k-client-apache")
//  implementation(libs.turtle)
}
