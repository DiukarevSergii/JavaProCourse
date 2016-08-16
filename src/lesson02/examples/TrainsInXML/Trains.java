package lesson02.examples.TrainsInXML;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {

    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void add(Train train) {
        trains.add(train);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
