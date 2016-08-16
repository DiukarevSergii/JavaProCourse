package lesson02.withXML.TrainsInXML;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


public class Train {

    private String from;
    private String to;
    private Date date;
    private Date departure;

    public Train() {
    }

    public Train(String from, String to, Date date, Date departure) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public Date getDate() {
        return date;
    }


    @XmlElement(required = true)
    @XmlJavaTypeAdapter(DateAdapter01.class)
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeparture() {
        return departure;
    }
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(DateAdapter02.class)
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "from = '" + from + '\'' +
                ", to = '" + to + '\'' +
                ", date = " + date +
                ", departure = " + departure +
                "}\n";
    }
}
