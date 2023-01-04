ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"
val scalaTestVersion = "3.2.14"
lazy val root = (project in file("."))
  .settings(
    name := "hack-with-jack"
  )


libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"                       % scalaTestVersion % Test,
)