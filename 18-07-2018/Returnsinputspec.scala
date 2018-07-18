package com.knoldus.edu

import org.scalatest.FunSuite
class Returnsinputspec extends FunSuite  {


      val obj = new ReturnsInput
      val obj1 = Pet("doggie")
      test("Test case for string ")
      {
        val actualValue = obj.matching("hello knoldus")
        val expectedValue = " you provided me this string hello knoldus"
        assert(actualValue === expectedValue)
      }
      test("Test case for Int") {
        val actualValue = obj.matching(5)
        val expectedValue = "thanks for the int 5"
        assert(actualValue === expectedValue)
      }
      test("Test case for List") {
        val actualValue = obj.matching(List(3, 4, 1, 5, 66, 7))
        val expectedValue = "thanks for the list List(3, 4, 1, 5, 66, 7)"
        assert(actualValue === expectedValue)
      }
      test("Test case for Array") {
        val actualValue = obj.matching(Array(2, 1, 4, 2, 3))
        val expectedValue = "you provided an array 2 ,1 ,4 ,2 ,3"
        assert(actualValue === expectedValue)
      }
      test("Test case for Array[String]") {
        val actualValue = obj.matching(Array("Welcome ", "to", "knoldus"))
        val expectedValue = "you provided an array of String Welcome ,to ,knoldus "
        assert(actualValue === expectedValue)
      }
      test("Test case for case class") {
        val actualValue = obj.matching(obj1)
        val expectedValue = "My pet name is doggie"
        assert(actualValue === expectedValue)

      }



  }

