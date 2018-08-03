
name := "akka_day2_assginment"

version := "1.0"

scalaVersion := "2.12.6"


libraryDependencies ++= Seq(

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.typesafe.akka" %% "akka-testkit" % "2.5.13" % Test
)


libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.14"

