package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object WordCountDataSetWT {

  case class Book(value: String)

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("WordCountDataSetWT")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val input = spark.read.text("data/book.txt").as[Book]

    val words = input
      .select(explode(split($"value", " ")).alias("word"))
      .filter($"word" =!= "")

    val wordCounts = words.groupBy("word").count()

    wordCounts.show(wordCounts.count.toInt)
  }

}
