package lesson02.withJSON.JSON1.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {

        byte[] buf;
        RandomAccessFile f = new RandomAccessFile("D:\\JAVA\\course\\JavaPro\\CodeSpace\\src\\lesson02\\withJSON\\JSON1\\json.txt", "r");
        try {
            buf = new byte[(int)f.length()];
            f.read(buf);
        } finally {
            f.close();
        }

        String result = new String(buf);

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(result, Person.class);

        System.out.print(person.name);
        System.out.print(person.address.city);
    }
}
