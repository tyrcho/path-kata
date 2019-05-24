organization := "info.daviot"
name := "scala-paths"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.8"
libraryDependencies ++= Seq(scalaTest)

lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5" % Test
