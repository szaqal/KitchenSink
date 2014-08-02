resolvers ++= Seq(
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
        "akka" at "http://repo.akka.io/snapshots",
        "spray" at "http://repo.spray.io/"
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies ++= Seq(
        "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
        "org.specs2" % "specs2_2.11" % "2.3.11",
        "com.typesafe.scala-logging" % "scala-logging-slf4j_2.11" % "2.1.2",
        "com.typesafe.scala-logging" % "scala-logging-api_2.11" % "2.1.2",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "io.spray" %%  "spray-json" % "1.2.6",
        "io.spray" %% "spray-client" % "1.3.1",
        "com.typesafe.akka" % "akka-actor_2.11" % "2.3.4"
       )

name := "SprayDownload"

version := "1.0"

scalaVersion := "2.11.2"
