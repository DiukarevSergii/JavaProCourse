package lesson02.withXML.TrainsInXML;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter02 extends XmlAdapter<String,Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }
}
