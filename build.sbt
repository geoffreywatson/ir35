name := """ir35"""
organization := "geoff.com"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "geoff.com.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "geoff.com.binders._"
