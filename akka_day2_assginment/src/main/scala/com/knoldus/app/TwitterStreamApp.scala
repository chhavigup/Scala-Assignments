package com.knoldus.app


import akka.actor.{ActorSystem, Props}
import akka.routing.Router
import com.knoldus.actor.TestRouter
import com.typesafe.config.ConfigFactory

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._


case class Tweet(tweetId: String, createdAt: Long, userId: Long, tweetUserName: String, countryName: String, friendsCount: Long)

object TwitterStreamApp extends App {
 //val sys = ActorSystem(" TwitterStreamApp", ConfigFactory.load("application.conf")
   // .withFallback(ConfigFactory.load()))


  val system = ActorSystem("tweetAppSystem")

  val master = system.actorOf(Props[TestRouter].withDispatcher("prio-dispatcher"), "router")

  // excution context should be use for scheduler
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  val buffer: ListBuffer[Tweet] = scala.collection.mutable.ListBuffer[Tweet]()

  system.scheduler.schedule(0 millis, 50 millis) {
    val rg = scala.util.Random
    buffer += Tweet(java.util.UUID.randomUUID().toString, rg.nextLong(), rg.nextLong(), rg.nextString(10), "India", rg.nextInt(2000))
  }

  system.scheduler.schedule(0 millis, 1000 millis) {
    master ! buffer
    buffer.clear()
  }
}


