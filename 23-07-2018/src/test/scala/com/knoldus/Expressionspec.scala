package com.knoldus

import org.scalatest.FunSuite

class Expressionspec extends FunSuite {
  val expressionTest = new Expression
  test("testcase for valid email id") {
    val actualvalue = expressionTest.check("chhavigupta@gmail.com")
    val expectedvalue = Some(("chhavigupta", "gmail.com"))
    assert(actualvalue === expectedvalue)

  }
  test("testcase for invalid email id") {
    val actualvalue = expressionTest.check("chhavigupta")
    val expectedvalue = None
    assert(actualvalue === expectedvalue)


  }
}
