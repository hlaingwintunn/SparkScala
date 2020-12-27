package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark._

object TotalAmountSpentByCustomerWT {

  def extractCustomerPriceParis(line: String): (Int, Float) = {
    val fields = line.split(",")
    (fields(0).toInt, fields(2).toFloat)
  }

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "TotalAmountSpentByCustomerWT")

    val input = sc.textFile("data/customer-orders.csv")

    val mappedInput = input.map(extractCustomerPriceParis)

    val totalByCustomer = mappedInput.reduceByKey((x,y) => x + y)

    val results = totalByCustomer.collect()

    results.foreach(println)
  }

}
