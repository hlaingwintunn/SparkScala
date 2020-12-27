package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark._

object FriendsByAgeWT {

  def parseLine(line: String): (Int, Int) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val numFriends = fields(3).toInt
    (age, numFriends)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "FriendsByAgeWT")

    val lines = sc.textFile("data/fakefriends-noheader.csv")

    val rdd = lines.map(parseLine)

    val totalsByAge = rdd.mapValues(x => (x, 1)).reduceByKey((x,y) => (x._1 + y._2, x._2 + y._2))

    val averageByAge = totalsByAge.mapValues(x => x._1 / x._2)

    val results = averageByAge.collect()

    results.sorted.foreach(println)
  }

}
