package com.knoldus

import twitter4j.TwitterException




class Twitterspec extends org.scalatest.AsyncFunSuite {

  val twitterObj = new Twitter

  test("Count must be greater than zero for the searched hashtag") {
    val resultTweets = twitterObj.searchUsingHashtags("#RamNath")
    resultTweets.map(list => assert(list.nonEmpty))
  }

  test("Excpetion must occur for empty hashtag") {
    recoverToSucceededIf[TwitterException] {
      twitterObj.searchUsingHashtags("")
    }
  }

  test("Count of number of tweets of a user must be greater than 0") {
    twitterObj.noOfTweets("narendramodi").map(count => assert(count > 0))
  }

  test("Count of number of tweets of a non-existant user must throw an exception") {
    recoverToSucceededIf[TwitterException] {
      twitterObj.noOfTweets("asjfhsdvsbsbsbuybksdbvjsdbciusdbv")
    }
  }

  test("Average number of tweets must be greater than 0 for a user") {
    twitterObj.avgTweetsPerDay("narendramodi").map(count => assert(count > 0))
  }

  test("Average number of tweets must throw an exception for a non-existant user") {
    recoverToSucceededIf[TwitterException] {
      twitterObj.avgTweetsPerDay("asfavvsvsyudasbciuwe")
    }
  }

  test("Average number of retweets for a user must be greater than 0")
  {
    twitterObj.avgRetweet("narendramodi").map(count => assert(count > 0))
  }

  test("Average number of retweets for a non-existant user must throw an exception")
  {
    recoverToSucceededIf[TwitterException]{
      twitterObj.avgRetweet("asfeywuvfvfsvsfffbcndcs")
    }
  }

  test("Average number of likes for a user must be greater than 0")
  {
    twitterObj.avgLikes("narendramodi").map(count => assert(count > 0))
  }

  test("Average likes for a non-existant user must throw an exception")
  {
    recoverToSucceededIf[TwitterException]
      {
        twitterObj.avgLikes("nfcwe89bsdbc")
      }
  }

}