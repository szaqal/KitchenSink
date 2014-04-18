package basics.actors

import akka.actor.Actor
import akka.actor.Actor._

class DummyActor extends Actor {

  def receive = {
    case msg => println("received message: " + msg)
  }

}