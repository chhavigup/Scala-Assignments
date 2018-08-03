
package com.knoldus.actor

import akka.actor.Actor
import akka.event.{Logging, LoggingAdapter}

import com.knoldus.app.Tweet

class Worker extends Actor {
  var count = 0
  val log: LoggingAdapter = Logging(context.system, this)

  override def receive: PartialFunction[Any, Unit] = {
    case tweet: Tweet => if (tweet.friendsCount > 500) {
      count += 1
      log.info(s"friend count = ${tweet.friendsCount} , country = ${tweet.countryName} userName = ${tweet.tweetUserName} ")
      sender() ! "I receive a message with friend circle greater than 500"}
      else
    {

      sender() ! "I receive a message with friend circle less than 500"
    }
  }
}
