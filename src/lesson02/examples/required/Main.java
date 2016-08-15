package lesson02.examples.required;

import javax.xml.bind.*;
import java.io.File;

public class Main {

    public static void main(String[] args)  {
        try {
            File f = new File(
                    "D:\\JAVA\\course\\JavaPro\\CodeSpace\\src\\lesson02\\examples\\required\\required.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Required.class);

            Required required = new Required();

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(required, f);
            marshaller.marshal(required, System.out);
            System.out.println();

            File file = new File(
                    "D:\\JAVA\\course\\JavaPro\\CodeSpace\\src\\lesson02\\examples\\required\\requiredFalse.xml");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Required required1 = (Required) unmarshaller.unmarshal(file);
            System.out.println(required1.getS());
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
