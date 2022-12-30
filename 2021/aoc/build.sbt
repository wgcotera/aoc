ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file(".")).dependsOn(aloussase)
    .settings(
        name := "aoc",
        idePackagePrefix := Some("io.github.wgcotera"),
    )
lazy val aloussase = RootProject(uri("https://github.com/aloussase/http-client-scala.git"))