resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	"akka" at "http://repo.akka.io/snapshots",
	"repo.codahale.com" at "http://repo.codahale.com"
)

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
	"com.typesafe.akka" %  "akka-actor_2.10" % "2.4-SNAPSHOT",
	"com.yuvimasory" % "jerkson_2.10" % "0.6.1"
)

name := "basics"

version := "1.0"

scalaVersion := "2.10.3"
