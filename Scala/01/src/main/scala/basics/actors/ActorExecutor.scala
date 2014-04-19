package basics.actors

import akka.actor.ActorSystem
import akka.actor.Props

object ActorExecutor {

  def exec = {
    val system = ActorSystem("HelloSystem")
    val helloActor = system.actorOf(Props[DummyActor])
    helloActor ! "buenos dias"
  }
}