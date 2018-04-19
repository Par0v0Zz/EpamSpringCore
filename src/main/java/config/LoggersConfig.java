package config;

import beans.loggers.CombinedEventLogger;
import beans.loggers.ConsoleEventLogger;
import beans.loggers.EventLogger;
import beans.loggers.FileEventLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beans.loggers")
public class LoggersConfig {

  @Autowired
  private ConsoleEventLogger consoleEventLogger;

  @Autowired
  private CombinedEventLogger combinedEventLogger;

  @Autowired
  private FileEventLogger fileEventLogger;

  @Bean
  public Map<EventType, EventLogger> loggersMap() {
    Map<EventType, EventLogger> map = new HashMap<>();
    map.put(EventType.INFO, consoleEventLogger);
    map.put(EventType.ERROR, combinedEventLogger);
    return map;
  }

  @Bean
  public Collection<EventLogger> loggersCollection() {
    Collection<EventLogger> loggers = new LinkedList<>();
    loggers.add(fileEventLogger);
    loggers.add(consoleEventLogger);
    return loggers;
  }
}
