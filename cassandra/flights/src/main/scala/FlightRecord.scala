/**
  * @author Andrey Kozyrev on 7/12/16.
  */
case class FlightRecord (
  year: Int,
  month: Int,
  day: Int,
  departed: Int,
  arrived: Int,
  carrier: String,
  number: String,
  tail: String,
  elapsed: Int,
  air: Int,
  arrivalDelay: Int,
  departureDelay: Int,
  origin: String,
  destination: String,
  distance: Int,
  cancelled: Boolean
)
