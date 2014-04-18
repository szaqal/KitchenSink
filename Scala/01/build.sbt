resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	"akka" at "http://repo.akka.io/snapshots"
)

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
	"com.typesafe.akka" %  "akka-actor_2.10" % "2.4-SNAPSHOT"
)

name := "basics"

version := "1.0"

scalaVersion := "2.10.3"
