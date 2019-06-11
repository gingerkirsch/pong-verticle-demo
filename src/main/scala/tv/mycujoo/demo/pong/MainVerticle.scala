package tv.mycujoo.demo.pong

import io.micrometer.prometheus.PrometheusMeterRegistry
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.json.JsonObject
import io.vertx.micrometer.backends.BackendRegistries
import io.vertx.scala.core.Vertx

import scala.concurrent.Future

class MainVerticle extends ScalaVerticle {
  override def startFuture(): Future[_] = {
    val registry: PrometheusMeterRegistry = BackendRegistries.getDefaultNow.asInstanceOf[PrometheusMeterRegistry]

    vertx.setPeriodic(1000, (periodic: Long) => {
      def foo(periodic: Long) = {
        Vertx.currentContext().get.owner().eventBus().send("metrics",
          new JsonObject().put("origin", "pong_1").put("metric", registry.scrape))
      }
      foo(periodic)
    })

    Future.successful(vertx.eventBus().consumer[String]("eventbus.ping").handler(handler => {
      handler.reply(s"pong from 1")
    }))
  }
}
