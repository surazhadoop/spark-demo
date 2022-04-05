package in.olc.training.spark.process

import java.util.UUID

import in.olc.training.spark.utils.SparkUtils
import org.apache.commons.lang3.StringUtils
import org.apache.spark.SparkContext

object SparkWordCount{
  def main(args: Array[String]): Unit = {
    val inputPath="src/main/resources/word1.txt"  //read from args[0]
    val outputPath="src/main/output"    //read from args[1]
    implicit val sc=SparkUtils.getSparkContext()
    val wordCountRDD= getWordCount(inputPath)
    wordCountRDD.collect().foreach(println)
    wordCountRDD.saveAsTextFile(outputPath+s"_${UUID.randomUUID()}")
  }

  def getWordCount(inputPath:String)(implicit sc: SparkContext)={
    val wordRDD=sc.textFile(inputPath) // apple ball apple apple
    val wordCountRDD=wordRDD.flatMap(line=>line.split(" ")).flatMap(word=>{
      if(StringUtils.isNotBlank(word))Some(word,1)
      else None
    }
    ).reduceByKey(_+_)
    wordCountRDD
  }

}
