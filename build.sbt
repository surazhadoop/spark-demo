name := "SparkUnitTesting"
version := "0.1"
scalaVersion := "2.12.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.1"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.2.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "3.2.0_1.1.1" % Test


