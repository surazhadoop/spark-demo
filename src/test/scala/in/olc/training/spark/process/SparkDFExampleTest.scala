package in.olc.training.spark.process

import com.holdenkarau.spark.testing.{DataFrameSuiteBase, SharedSparkContext}
import org.scalatest.funsuite.AnyFunSuite
class SparkDFExampleTest extends AnyFunSuite  with DataFrameSuiteBase   {

  test("test initializing spark session") {
    val inputPath = "src/test/resources/employee/employee.json"
    implicit val sparkSession = spark //sc is automatically available.
    val df = SparkDFExample.getGenderWiseAverageSalary(inputPath)
    val wordCountMap = df.rdd.map(rows => (rows.getAs[String](0), rows.getAs[Double](1))).collectAsMap()
    wordCountMap.foreach(println)
    assert(wordCountMap("M") == 6000)
    assert(wordCountMap("F") === 5000)
  }

}
