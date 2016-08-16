package lesson02.withXML.yahooFinanceXML;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "results")
public class Results {

    List<Rate> rate = new ArrayList<>();

    public List<Rate> getRate() {
        return rate;
    }

    @XmlElement
    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return  Arrays.deepToString(rate.toArray());
    }
}
