
import com.datastax.driver.core.{Cluster, Session}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * @author Andrey Kozyrev on 7/12/16.
  */
@Configuration
class FlightsConfig {

  @Bean
  def cluster(): Cluster = Cluster.builder().addContactPoint("127.0.0.1").build()

  @Bean
  def session(): Session = cluster().connect()

  @Bean
  def reader(): FlightReader = new FlightReader()

  @Bean
  def publisher(): FlightPublisher = new FlightPublisher(reader(), session())
}
