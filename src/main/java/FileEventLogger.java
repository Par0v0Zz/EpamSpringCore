import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + System.lineSeparator(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init() throws IOException {
        this.file = new File(filename);
        if(!(file.canWrite())) throw new IOException();
    }
}
