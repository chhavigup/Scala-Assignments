
package com.knoldus.actor

import akka.actor.{ActorRef, ActorSystem, Props, Terminated}
import akka.routing.Router
import akka.testkit.{ImplicitSender, TestKit}
import com.knoldus.app.Tweet
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class TestRouterspec extends TestKit(ActorSystem("tweetAppSystem")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val testRef1: ActorRef = system.actorOf(Props[TestRouter])

  "Unit Testing " should {


    "for Worker actor tweet received with friend group greater than 500" in {
      testRef1 ! Tweet("qwer", 234, 2324, "chhavi", "India", 501)
      expectMsg("I receive a message with friend circle greater than 500")
    }


    "for Worker actor tweet received with friend group less than 500" in {
      testRef1 ! Tweet("qwer", 234, 2324, "chhavi", "India", 400)
      expectMsg("I receive a message with friend circle less than 500")
    }

    "checks the Termination of any routee" in {

      testRef1 ! Terminated(testRef1)(false, true)
      expectNoMessage()
    }

  }
}

