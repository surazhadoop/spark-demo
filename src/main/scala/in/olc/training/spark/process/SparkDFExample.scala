package in.olc.training.spark.process
import in.olc.training.spark.utils.SparkUtils
import org.apache.spark.sql.SparkSession

object SparkDFExample{

  def main(args: Array[String]): Unit = {
    val inputPath="src/main/resources/employee.json"  //read from args[0]
    val outputPath="src/main/output"    //read from args[1]
    implicit val sparkSession=SparkUtils.getSparkSession()
    val resultDF=getGenderWiseAverageSalary(inputPath)
    resultDF.show(false)
  }

  def getGenderWiseAverageSalary(inputPath:String)(implicit spark: SparkSession)={
    val employeeDF=spark.read.json(inputPath)
    employeeDF.show(false)
    val genderWiseSalary=employeeDF.groupBy("gender").avg("salary")
    genderWiseSalary
  }
}