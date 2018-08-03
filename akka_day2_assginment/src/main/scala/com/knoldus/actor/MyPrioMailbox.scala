
package com.knoldus.actor

import akka.actor.ActorSystem
import akka.dispatch.PriorityGenerator
import akka.dispatch.UnboundedStablePriorityMailbox
import com.knoldus.app.Tweet
import com.typesafe.config.Config


class MyPrioMailbox(settings: ActorSystem.Settings, config: Config)
  extends UnboundedStablePriorityMailbox(

    PriorityGenerator {

      case tweet: Tweet if tweet.friendsCount >500  => 0
      case tweet: Tweet if tweet.friendsCount >400 && tweet.friendsCount <500  => 1
      case tweet: Tweet if tweet.friendsCount >300 && tweet.friendsCount <400 => 2
      case _ => 3

    }
  )
