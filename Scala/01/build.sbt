resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	"akka" at "http://repo.akka.io/snapshots",
	"repo.codahale.com" at "http://repo.codahale.com"
)

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
	 "com.typesafe.akka" % "akka-actor_2.11" % "2.3.4",
	"org.specs2" % "specs2_2.11" % "2.3.13"        
)

name := "basics"

version := "1.0"

scalaVersion := "2.11.2"
