package org.test.extractionsample

import org.json4s._
import org.json4s.jackson.JsonMethods
import scala.collection.JavaConversions._
import scala.collection.immutable.Map

object Testing {
  private implicit val formats = DefaultFormats
  def main(args: Array[String]):Unit = {
    val jsonSample1 = """{"action":"add"}"""
    val jsonSample2 = """{"action":"add","item": {"name": "a.txt","Owner": {"email": "testemail@somewhere.org"}}}"""
    try {
      println("====================================")
      println("Sample 1: %s".format(jsonSample1))
      println("Sample 2: %s".format(jsonSample2))
      println("====================================")
      
      println("---------------------")
      println("Attempt Extraction of Sample1 as Map[String,String]")
      JsonMethods.parse(jsonSample1).extract[Map[String,String]]
      println("Successfully Extracted Sample1 as Map[String,String]")
      println("---------------------")
      
      println("---------------------")
      println("Attempt Extraction of Sample1 as Map[String,Any]")
      JsonMethods.parse(jsonSample1).extract[Map[String,Any]]
      println("Successfully Extracted Sample1 as Map[String,Any]")
      println("---------------------")
      
      println("---------------------")
      println("Attempt Extraction of Sample2 as Map[String,Any]")
      JsonMethods.parse(jsonSample2).extract[Map[String,Any]]
      println("Successfully Extracted Sample2 as Map[String,Any]")
      println("---------------------")
    }
    catch {
      case e: Exception => {
        println("---------------------")
        println("Extraction Failed!")
        println(e.toString)
        println("---------------------")
      }
    }
  }
}