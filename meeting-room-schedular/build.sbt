val common= Seq(
  version := "0.1" ,
  scalaVersion := "2.12.6",
libraryDependencies++=Seq("org.slf4j" % "slf4j-api" % "1.7.5",
"org.slf4j" % "slf4j-simple" % "1.7.5"
)
)

lazy val root = (project in file("."))
  .settings(common)
  .settings(
    name := "meeting-room-schedular"
  )
  .dependsOn(db)
lazy val db = (project in  file("db-operations"))
  .settings(common)
  .settings(
    name := "db",
    libraryDependencies++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",
         "mysql" % "mysql-connector-java" % "5.1.24"
    )
  )
lazy val admin = (project in file("admin"))
   .settings(common)
   .settings(
     name := "admin",
     libraryDependencies++= Seq(
       "org.scalatest" %% "scalatest" % "3.0.5" % "test"

     )
   )

lazy val login = (project in file("login"))
  .settings(common)
  .settings(
    name := "login",
    libraryDependencies++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % "test"

    )
  )
  .dependsOn(db,root)
lazy val signUp = (project in file("signUp"))
   .settings(common)
    .settings(
      name := "signUp",
      libraryDependencies++= Seq(
        "org.scalatest" %% "scalatest" % "3.0.5" % "test"
      )
    )
.dependsOn(db,admin)
