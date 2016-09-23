import grizzled.slf4j.Logging
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * @author Andrey Kozyrev on 7/12/16.
  */
object Main extends App with Logging {

  logger.info("start")

  val ctx = new AnnotationConfigApplicationContext(classOf[FlightsConfig])

  ctx.getBean(classOf[FlightPublisher]).publish()
  ctx.close()

  logger.info("done")
}
