import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Date;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event) {

        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");

        App app = ctx.getBean(App.class);

        Event event = ctx.getBean(Event.class);
        event.setMsg("Event 1");
        app.logEvent(event);

        event = ctx.getBean(Event.class);
        event.setMsg("Event 2");
        app.logEvent(event);

        ctx.close();
    }
}
