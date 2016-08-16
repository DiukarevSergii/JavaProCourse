package lesson02.examples.yahooFinanceXML;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "rate")
public class Rate {
    String id;
    String Name;
    double rate;
    String date;
    String time;
    String ask;
    String bid;

    public Rate() {
    }

    public Rate(String id, String name, double rate, String date, String time, String ask, String bid) {
        this.id = id;
        this.Name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

//    @XmlElement(name = "Name")
    public void setName(String name) {
        this.Name = name;
    }

    public double getRate() {
        return rate;
    }

    @XmlElement(name = "Rate")
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    @XmlElement(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    @XmlElement(name = "Time")
    public void setTime(String time) {
        this.time = time;
    }

    public String getAsk() {
        return ask;
    }

    @XmlElement(name = "Ask")
    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    @XmlElement(name = "Bid")
    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "\nRate{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ask='" + ask + '\'' +
                ", bid='" + bid + '\'' +
                "}";
    }
}
