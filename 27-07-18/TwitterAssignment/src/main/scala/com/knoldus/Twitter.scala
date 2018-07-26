package com.knoldus
import java.util.Calendar
import scala.concurrent.ExecutionContext.Implicits.global
import twitter4j._
import scala.collection.JavaConverters._
import scala.concurrent.Future

class Twitter {

  val twitter: Twitter = TwitterFactory.getSingleton

  def searchUsingHashtags(topic: String): Future[List[String]] = Future {

    val query = new Query(topic)

    val result: QueryResult = twitter.search(query)

    val a = result.getTweets.asScala.toList
    a.map(_.getText)

  }

def avgTweetsPerDay(username: String): Future[Long] = Future {

  val accountCreationTime = twitter.showUser(username).getCreatedAt.getTime

  val currentDate = Calendar.getInstance().getTimeInMillis
  //val d = new Date().getTime
  noOfTweets(username).map(_ / ((currentDate - accountCreationTime) / (1000 * 60 * 60 * 24)))
}.flatten

  def noOfTweets(username: String): Future[Int] = Future {
  twitter.showUser(username).getStatusesCount
}

  def avgRetweet(username: String): Future[Double] = Future {

  val statusList = twitter.timelines().getUserTimeline(username).asScala.toList
  statusList.map(_.getRetweetCount).sum / statusList.length.toDouble

}

  def avgLikes(username: String): Future[Double] = Future {

  val statusList = twitter.timelines().getUserTimeline(username).asScala.toList
  statusList.map(_.getFavoriteCount).sum / statusList.length.toDouble

}


}