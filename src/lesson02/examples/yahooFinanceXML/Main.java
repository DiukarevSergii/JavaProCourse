package lesson02.examples.yahooFinanceXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Query query = (Query) unmarshaller.unmarshal(new URL(request));

            System.out.println(query);

            for (Rate rate: query.results.rate){
                System.out.println(rate.id + " = " + rate.rate);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
