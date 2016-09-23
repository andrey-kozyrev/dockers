name := "flights"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-core" % "4.3.1.RELEASE",
  "org.springframework" % "spring-context" % "4.3.1.RELEASE",
  "org.apache.logging.log4j" % "log4j-api" % "2.6.2",
  "org.apache.logging.log4j" % "log4j-core" % "2.6.2",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.6.2",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.0",
  "org.clapper" %% "grizzled-slf4j" % "1.0.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0",
  "com.datastax.cassandra" % "cassandra-driver-mapping" % "3.0.0",
  "com.datastax.cassandra" % "cassandra-driver-extras" % "3.0.0"
)

fork := true

connectInput := true

outputStrategy := Some(StdoutOutput)