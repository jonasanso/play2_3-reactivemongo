name := """play2_3-reactivemongo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.10.play23"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
