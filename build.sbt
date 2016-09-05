name := "oop-hw1"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

mainClass in assembly := Some("edu.nyu.oop.Boot")

unmanagedResourceDirectories in Compile += { baseDirectory.value / "src/main/java" }

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

scalariformSettings

// Custom tasks

compile <<= (compile in Compile) dependsOn(clean, compile in Test)

val formatc = TaskKey[Unit]("formatc", "Code formatter for generated C++. Run it after translation.")
formatc := """astyle --suffix=none --style=allman output/* """.!

val formatjtests = TaskKey[Unit]("formatjtests", "Code formatter for Java Unit Tests. Run it regularly.")
formatjtests := """astyle --recursive --suffix=none --style=java src/test/java/* """.!

val formatj = TaskKey[Unit]("formatj", "Code formatter for Java. Run it regularly.")
formatj <<= formatjtests map { (e) => """astyle --recursive --suffix=none --style=java src/main/java/* """.! }

val compilec = TaskKey[Unit]("compilec", "Compile the generated C++.")
compilec := """g++ output/java_lang.cc output/main.cc output/output.cc -o output/a.out""".!

val execc = TaskKey[Unit]("execc", "Execute the generated C++.")
execc := """output/a.out""".!

val runxtc = inputKey[Unit]("Run a command on your Boot class.")
runxtc := Def.inputTaskDyn {
  val args = sbt.complete.DefaultParsers.spaceDelimited("<arg>").parsed
  val cmd = s" edu.nyu.oop.Boot -${args.init.mkString(" -")} ${args.last}"
  (runMain in Compile).toTask(cmd)
}.evaluated

val conf = inputKey[Unit]("Output application configuration")
conf := Def.inputTaskDyn {
  (runMain in Compile).toTask(s" edu.nyu.oop.Boot -printConfig src/test/java/inputs/test000/Test000.java")
}.evaluated