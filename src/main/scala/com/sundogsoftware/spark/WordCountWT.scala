package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.SparkContext

object WordCountWT {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "WordCountWT")

    val input = sc.textFile("data/book.txt")

    val words = input.flatMap(x => x.split(" "))

    val wordCounts = words.countByValue()

    wordCounts.foreach(println)
  }

}
