name := "coursework3"

version := "1.0"

scalaVersion := "2.11.7" 

lazy val akkaVersion = "2.4.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

scalacOptions += "-deprecation"



    