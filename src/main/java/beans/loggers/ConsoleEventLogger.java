package beans.loggers;

import beans.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("consoleEventLogger")
public class ConsoleEventLogger implements EventLogger {

  public void logEvent(Event event) {
    System.out.println(event);
  }
}
