package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark._

object RatingCounterwt {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    //Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "RatingCounterwt")

    val lines = sc.textFile("data/ml-100k/u.data")

    val ratings = lines.map(x => x.split("\t")(2))

    val results = ratings.countByValue()

    val sortedResults = results.toSeq.sortBy(_._1)

    sortedResults.foreach(println)
  }

}
