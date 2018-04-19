package beans.loggers;

import beans.Event;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("combinedEventLogger")
public class CombinedEventLogger implements EventLogger {

  @Autowired
  @Qualifier("loggersCollection")
  private Collection<EventLogger> loggers;

  @Override
  public void logEvent(Event event) {
    loggers.forEach(logger -> logger.logEvent(event));
  }
}
