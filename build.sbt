import sbt.Package._
import sbt._

version := "0.1"
scalaVersion := Version.Scala
crossPaths := false

lazy val playerApplication = (project in file("."))
  .settings(
    name := "cmm-pong-verticle",
    mainClass in assembly := Some("tv.mycujoo.demo.pong.Launcher"),
    libraryDependencies ++= Seq(
      Library.vertx_lang_scala,
      Library.vertx_micrometer,
      Library.vertx_hazelcast,
      Library.hazelcastK8s,
      Library.logging,
      Library.micrometer_prometheus
    ).map(_.exclude("org.slf4j", "slf4j-jdk14")),
    packageOptions += ManifestAttributes(
      ("Main-Verticle", "scala:tv.mycujoo.demo.pong.MainVerticle"))
  )
