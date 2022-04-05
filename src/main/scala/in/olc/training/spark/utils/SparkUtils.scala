package in.olc.training.spark.utils

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SparkUtils{

  def getSparkContext()= {
    val conf = new SparkConf()
            .setMaster("local[2]") //yarn if you are running in cluster
            .setAppName("WordCount")
    val sc = new SparkContext(conf)
    sc
  }
  def getSparkSession()={
    val sparkSession = SparkSession
      .builder()
      .master("local")  //yarn if you are running in cluster
      .appName("SparkAndHive")
      .config("spark.sql.warehouse.dir","d:/spark-warehouse")
      .enableHiveSupport()
      .getOrCreate()
    sparkSession
  }
}
