package com.knoldus.edu
import org.scalatest.FunSuite



class PatternMatchingSpec extends FunSuite {


      val list = List(2, 4, 5, 6, 7, 1)
      val obj  =  new PatternMatching
      test("Test case for max value"){
        val actualValue = obj.max(list)
         val expectedValue = 7
         assert(actualValue===expectedValue)}

  test("Test case for min value"){
    val actualValue = obj.min(list)
    val expectedValue = 1
    assert(actualValue===expectedValue)}

  test("Test case for Nth value from last")
{
    val actualValue = obj.lastNthElement(list,3)
    val expectedValue = 6
    assert(actualValue===expectedValue)
}

  test("Test case for length of a list"){
    val actualValue = obj.length(list)
    val expectedValue = 6
    assert(actualValue===expectedValue)
}


}

