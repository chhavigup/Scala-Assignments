package com.knoldus
import org.scalatest.FunSuite
class Extractorspec extends FunSuite {
  val extractorTest = new Extractor
  test("testcase for apply method")
  {
    val actualvalue = URL(" https", "aws.amazon.com", "/console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))
    val expectedvalue = " https://aws.amazon.com//console/home?state=hash&isauthcode=true&code=112"
    assert(actualvalue===expectedvalue)
  }
  test("testcase for unapply method")
  {
    val actualvalue = extractorTest.callUnapply(" https://aws.amazon.com//console/home?state=hash&isauthcode=true&code=112")
    val expectedvalue = "Protocal :  https \n  domain : aws.amazon.com \n  path :/console/home \n params:Map(state -> hash, isauthcode -> true, code -> 112) "
    assert(actualvalue===expectedvalue)
  }


}
