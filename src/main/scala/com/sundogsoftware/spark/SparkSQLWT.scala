package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession

object SparkSQLWT {
  case class Person(Id:Int, name: String, age: Int, numFriends:Int)

  def mapper(line:String): Person = {
    val fields = line.split(',')

    val person:Person = Person(fields(0).toInt, fields(1), fields(2).toInt, fields(3).toInt)
    person
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("SparkSQLWT")
      .master("local[*]")
      .getOrCreate()

    val lines = spark.sparkContext.textFile("data/fakefriends-noheader.csv")
    val people = lines.map(mapper)

    import spark.implicits._
    val schemaPeople = people.toDS

    schemaPeople.printSchema()
    schemaPeople.createOrReplaceTempView("people")

    val teenagers = spark.sql("SELECT * FROM people WHERE age >= 13 AND age <= 19")

    val results = teenagers.collect()

    results.foreach(println)

    spark.stop()

  }
}
