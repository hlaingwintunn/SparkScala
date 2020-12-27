package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession

object DataFrameWT {

  case class Person(ID:Int, name:String, age:Int, numFriends:Int)

  def mapper(line:String) : Person = {
    val fields = line.split(',')

    val person:Person = Person(fields(0).toInt, fields(1), fields(2).toInt, fields(3).toInt)
    person
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("SparkSQLDataFrame")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val lines = spark.sparkContext.textFile("data/fakefriends-noheader.csv")
    val people = lines.map(mapper).toDF().cache()

    println("Here is our inferred schema:")
    people.printSchema()

    println("let's select the name column")
    people.select("name").show()

    println("Filter out anyone over 21:")
    people.filter(people("age") < 21).show()

    println("Group by age:")
    people.groupBy("age").count().show()

    println("Make everyone 10 years older:")
    people.select(people("name"), people("age") + 10).show()

    spark.stop()
  }

}
