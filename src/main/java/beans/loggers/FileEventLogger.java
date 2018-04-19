package beans.loggers;

import beans.Event;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fileEventLogger")
@PropertySource("app.properties")
public class FileEventLogger implements EventLogger {

  @Value("${logfile:}")
  private String filename;

  private File file;

  @Override
  public void logEvent(Event event) {
    try {
      FileUtils.writeStringToFile(file, event.toString() + System.lineSeparator(), true);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @PostConstruct
  public void init() throws IOException {
    this.file = new File(filename);
    if (!(file.canWrite())) {
      throw new IOException();
    }
  }
}
