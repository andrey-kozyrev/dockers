import scala.io.Source
import grizzled.slf4j.Logging
import scala.util.{Failure, Success, Try}

/**
  * @author Andrey Kozyrev on 7/12/16.
  */
class FlightReader extends Logging {

  def read(file: String): Iterator[FlightRecord] = {
    Source.fromFile(file).getLines().map(line => record(line.split(","))).filter(_.isSuccess).map(_.get)
  }

  private def record(fields: Array[String]): Try[FlightRecord] = {
    try {
      Success(
        FlightRecord(
          fields(0).toInt,
          fields(1).toInt,
          fields(2).toInt,
          fields(4).toInt,
          fields(6).toInt,
          fields(8),
          fields(9),
          fields(10),
          fields(11).toInt,
          fields(13).toInt,
          fields(14).toInt,
          fields(15).toInt,
          fields(16),
          fields(17),
          fields(18).toInt,
          fields(21).toInt != 0
        )
      )
    } catch {
      case err: Exception =>
        Failure(err)
    }
  }
}
