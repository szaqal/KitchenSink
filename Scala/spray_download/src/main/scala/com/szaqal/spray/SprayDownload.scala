package com.szaqal.spray

import org.slf4j.LoggerFactory
import org.slf4j.Logger
import akka.actor.ActorSystem
import spray.http.HttpRequest
import scala.concurrent.impl.Future
import spray.http._
import spray.client.pipelining._
import scala.concurrent.Future
import scala.util.Success
import scala.util.Failure
import scala.concurrent.duration._
import scala.concurrent.Await
import spray.io.ClientSSLEngineProvider
import scala.collection.immutable.Range

object SprayDownload {

  import system.dispatcher

  import scala.language.postfixOps

  val logger = LoggerFactory.getLogger("SprayDownload")

  implicit val system = ActorSystem()

  val pipeline: HttpRequest => Future[HttpResponse] = sendReceive

  implicit val myEngineProvider = ClientSSLEngineProvider { engine =>
    engine.setEnabledCipherSuites(Array("TLS_RSA_WITH_AES_256_CBC_SHA"))
    engine.setEnabledProtocols(Array("SSLv3", "TLSv1"))
    engine
  }

  def download(url: String): Unit = {
    require(url != null && url.nonEmpty);

    logger.info("Downloading {}", url)

    val response: Future[HttpResponse] = pipeline(Get(url))

    response.onComplete({
      case Success(resp) => {
        logger.info("Request Success {}", resp.headers)
        logger.info("Response {}", resp.entity)
      }
      case Failure(error) => {
        logger.warn("Request Failed {}", error)
      }
      case _ => {
        logger.warn("Unknown Response")
      }
    })

  }

}