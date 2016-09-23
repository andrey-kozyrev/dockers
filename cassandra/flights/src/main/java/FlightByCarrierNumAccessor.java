import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;

/**
 * @author Andrey Kozyrev on 7/18/16.
 */
@Accessor
public interface FlightByCarrierNumAccessor {
    @Query("SELECT * FROM flights.flights_by_carrier_num WHERE carrier = :c AND number = :n")
    Result<FlightByCarrierNum> list(@Param("c") String carrier, @Param("n") String number);
}
