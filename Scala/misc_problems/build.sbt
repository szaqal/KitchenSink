resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	"repo.codahale.com" at "http://repo.codahale.com"
)

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
	"org.specs2" % "specs2_2.10" % "2.3.11"            
)

name := "misc_problems"

version := "1.0"

scalaVersion := "2.10.3"
