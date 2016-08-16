package lesson02.withXML.TrainsInXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Trains trains = (Trains) unmarshaller.unmarshal(new File(
                    "D:\\JAVA\\MainWorkspace\\JavaProCourse\\src\\lesson02\\withJSON\\TrainsInXML\\trainsList.xml"));
            System.out.println(trains);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
