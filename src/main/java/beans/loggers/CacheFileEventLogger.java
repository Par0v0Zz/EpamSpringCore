package beans.loggers;

import beans.Event;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cacheFileEventLogger")
public class CacheFileEventLogger extends FileEventLogger {

  @Value("${cacheSize:}")
  private Integer cacheSize;

  private List<Event> cache = new ArrayList<>();

  @Override
  public void logEvent(Event event) {
    cache.add(event);

    if (cache.size() == cacheSize) {
      writeEventsFromCache();
      cache.clear();
    }
  }

  private void writeEventsFromCache() {
    for (Event e : cache) {
      super.logEvent(e);
    }
  }

  @PreDestroy
  public void destroy() {
    if (!cache.isEmpty()) {
      writeEventsFromCache();
    }
  }
}
