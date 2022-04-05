package in.olc.training.spark.process

import com.holdenkarau.spark.testing.SharedSparkContext
import org.apache.spark.rdd.RDD
import org.scalatest.funsuite.AnyFunSuite

class SparkWordCountTest extends AnyFunSuite with SharedSparkContext    {
  test("testing word count1") {
    val inputPath="src/test/resources/wordcount/word1.txt"
    implicit val sparkContext=sc  //sc is automatically available.
    val rdd: RDD[(String, Int)] = SparkWordCount.getWordCount(inputPath)
    val wordCountMap=rdd.collectAsMap() //apple -> 5 , ball ->2
    assert(wordCountMap("apple")== 5)
    assert(wordCountMap("ball")===2)
  }

  test("testing word count2") {
    val inputPath="src/test/resources/wordcount/word2.txt"
    implicit val sparkContext=sc  //sc is automatically available.
    val rdd: RDD[(String, Int)] = SparkWordCount.getWordCount(inputPath)
    val wordCountMap=rdd.collectAsMap()
    assert(wordCountMap("apple")== 4)
    assert(wordCountMap("ball")===1)
  }
}
