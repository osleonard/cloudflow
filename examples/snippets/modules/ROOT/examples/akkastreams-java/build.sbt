//tag::docs-projectSetup-example[]
import sbt._
import sbt.Keys._

lazy val sensorData =  (project in file("."))
    .enablePlugins(CloudflowAkkaStreamsApplicationPlugin)
    .settings(
//end::docs-projectSetup-example[]
      libraryDependencies ++= Seq(
        "com.lightbend.akka"     %% "akka-stream-alpakka-file"  % "1.1.2",
        "com.typesafe.akka"      %% "akka-http-spray-json"      % "10.1.10",
        "ch.qos.logback"         %  "logback-classic"           % "1.2.3",
        "com.typesafe.akka"      %% "akka-http-testkit"         % "10.1.10" % "test",
        "org.scalatest"          %% "scalatest"                 % "3.0.8"  % "test"

//tag::docs-projectName-example[]
      ),
      name := "akkastreams-doc",
//end::docs-projectName-example[]
      organization := "com.lightbend.cloudflow",
      headerLicense := Some(HeaderLicense.ALv2("(C) 2016-2020", "Lightbend Inc. <https://www.lightbend.com>")),

      schemaCodeGenerator := SchemaCodeGenerator.Java,

      scalaVersion := "2.12.10",
      crossScalaVersions := Vector(scalaVersion.value),
      javacOptions ++= Seq("-Xlint:deprecation"),
      scalacOptions ++= Seq(
        "-encoding", "UTF-8",
        "-target:jvm-1.8",
        "-Xlog-reflective-calls",
        "-Xlint",
        "-Ywarn-unused",
        "-Ywarn-unused-import",
        "-deprecation",
        "-feature",
        "-language:_",
        "-unchecked"
      ),
      javacOptions ++= Seq("-Xlint:deprecation"),
      runLocalConfigFile := Some("src/main/resources/local.conf"),
      libraryDependencies ++= Seq(
        "org.scalatest"          %% "scalatest"                 % "3.0.8"    % "test",
        "junit"                  % "junit"                      % "4.12"     % "test"),

      scalacOptions in (Compile, console) --= Seq("-Ywarn-unused", "-Ywarn-unused-import"),
      scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value

    )
