import sbt._

object Version {
  final val Scala           = "2.12.7"
  final val Vertx           = "3.7.0"
  final val MicrometerProm    = "1.1.4"
  final val Logging         = "3.9.2"
  final val HazelcastK8s    = "1.3.1"
}

object Library {
  val vertx_lang_scala                  = "io.vertx" %% "vertx-lang-scala"                       % Version.Vertx
  val vertx_micrometer                  = "io.vertx" % "vertx-micrometer-metrics"                % Version.Vertx
  val vertx_hazelcast                   = "io.vertx" %  "vertx-hazelcast"                         % Version.Vertx

  //non-vert.x deps
  val micrometer_prometheus             = "io.micrometer" % "micrometer-registry-prometheus"     % Version.MicrometerProm
  val logging                           = "com.typesafe.scala-logging" %% "scala-logging"         % Version.Logging
  val hazelcastK8s                      = "com.hazelcast" % "hazelcast-kubernetes"                % Version.HazelcastK8s

}

