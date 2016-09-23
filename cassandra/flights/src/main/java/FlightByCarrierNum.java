import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * @author Andrey Kozyrev on 7/18/16.
 */
@Table(
    keyspace = "flights",
    name = "flights_by_carrier_num",
    readConsistency = "QUORUM",
    writeConsistency = "QUORUM"
)
public class FlightByCarrierNum {

    public FlightByCarrierNum() {
    }

    public FlightByCarrierNum(FlightRecord r) {
        carrier = r.carrier();
        number = r.number();
        year = r.year();
        month = r.month();
        day = r.day();
        tail = r.tail();
        origin = r.origin();
        destination = r.destination();
        departed = r.departed();
        arrived = r.arrived();
        elapsed = r.elapsed();
        air = r.air();
        arrivalDelay = r.arrivalDelay();
        departureDelay = r.departureDelay();
        distance = r.distance();
        cancelled = r.cancelled();
    }

    @PartitionKey(0)
    @Column(name = "carrier")
    private String carrier;

    @PartitionKey(1)
    @Column(name = "number")
    private String number;

    @ClusteringColumn(0)
    @Column(name = "year")
    private int year;

    @ClusteringColumn(1)
    @Column(name = "month")
    private int month;

    @ClusteringColumn(2)
    @Column(name = "day")
    private int day;

    @Column(name = "tail")
    private String tail;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departed")
    private int departed;

    @Column(name = "arrived")
    private int arrived;

    @Column(name = "elapsed")
    private int elapsed;

    @Column(name = "air")
    private int air;

    @Column(name = "arrival_delay")
    private int arrivalDelay;

    @Column(name = "departure_delay")
    private int departureDelay;

    @Column(name = "distance")
    private int distance;

    @Column(name = "cancelled")
    private boolean cancelled;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDeparted() {
        return departed;
    }

    public void setDeparted(int departed) {
        this.departed = departed;
    }

    public int getArrived() {
        return arrived;
    }

    public void setArrived(int arrived) {
        this.arrived = arrived;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getArrivalDelay() {
        return arrivalDelay;
    }

    public void setArrivalDelay(int arrivalDelay) {
        this.arrivalDelay = arrivalDelay;
    }

    public int getDepartureDelay() {
        return departureDelay;
    }

    public void setDepartureDelay(int departureDelay) {
        this.departureDelay = departureDelay;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return String.format("%s-%s/%s", carrier, number, tail);
    }
}
