import java.nio.charset.StandardCharsets
import java.util.function.Consumer

import com.datastax.driver.core.Session
import com.datastax.driver.mapping.MappingManager
import com.google.common.util.concurrent.{FutureCallback, Futures}
import grizzled.slf4j.Logging
import org.springframework.beans.factory.annotation.Autowired

import scala.io.Source
import scala.util.Random

/**
  * @author Andrey Kozyrev on 7/13/16.
  */
class FlightPublisher(@Autowired val reader: FlightReader, @Autowired val session: Session) extends Logging {

  private val mm = new MappingManager(session)
  private val mapper = mm.mapper(classOf[FlightByCarrierNum])
  private val flights = mm.createAccessor(classOf[FlightByCarrierNumAccessor])

  private def log(text: String): String = {
    logger.info(text)
    text
  }

  private def cql(res: String): String =
    log(Source.fromInputStream(getClass.getResourceAsStream(res), StandardCharsets.UTF_8.name()).getLines().mkString(" ").replaceAll("\\s+", " "))

  session.execute(cql("/keyspace.cql"))
  session.execute(cql("/table_flights_by_carrier_num.cql"))

  def publish(): Unit = {
    val rnd = new Random()
    for (r <- reader.read("/home/ak/usr/doc/flights/1999.csv")) {
      Futures.addCallback(mapper.saveAsync(new FlightByCarrierNum(r)), new FutureCallback[Void] {
        override def onFailure(t: Throwable): Unit = {
          logger.error("fuck!", t)
        }
        override def onSuccess(result: Void): Unit = {
          if (rnd.nextInt(1000) == 0) {
            logger.info(r)
          }
        }
      })
    }
  }

}
