import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private Random rand = new Random();

    private int id = rand.nextInt(100);
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date; this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
