package com.knoldus.actor

import akka.actor.{Actor, Props, Terminated}
import akka.routing
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}
import com.knoldus.app.Tweet

class TestRouter extends Actor {
  var router: routing.Router = {
    val routees = Vector.fill(5) {
      val r = context.actorOf(Props[Worker].withDispatcher("prio-dispatcher"))
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }
 override def receive: PartialFunction[Any, Unit] = {

   case buffer: Tweet => router.route(buffer , sender())
   case Terminated(a) =>
     router = router.removeRoutee(a)
     val r = context.actorOf(Props[Worker])
     context watch r
     router = router.addRoutee(r)

  }
}
