import sbt._
import Keys._

object CustomSettingsBuild extends Build {

	lazy val customKey1 = SettingKey[String]("customKey1")
	lazy val customKey2 = SettingKey[String]("customKey2")
	lazy val customKey3 = SettingKey[String]("customKey3")



	lazy val showSettings =  TaskKey[Unit]("showCustomSettings") := {
		println ("*** Build Configuration ***")
		println (customKey1.value)
		println (customKey2.value)
		println (customKey3.value)
	}

	val customSettingsBuild = Project(
		id = "CustomSettings",
		base = file("."),
		settings = Defaults.defaultSettings ++ Seq(
			showSettings
		)
	)
}
