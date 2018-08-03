
package com.knoldus.actor

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.knoldus.app.Tweet
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class WorkerSpec extends TestKit(ActorSystem("tweetAppSystem")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val testRef: ActorRef = system.actorOf(Props[Worker])

  "Unit Testing " should {


    "for Worker actor tweet received with friend group greater than 500" in {
      testRef ! Tweet("user", 234, 2324, "chhavi", "India", 501)
      expectMsg("I receive a message with friend circle greater than 500")
    }


    "for Worker actor tweet received with friend group less than 500" in {
      testRef ! Tweet("user1", 234, 2324, "chhavi", "India", 400)
      expectMsg("I receive a message with friend circle less than 500")
    }

  }
}

