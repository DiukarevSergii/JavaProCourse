package lesson02.withJSON.JSON3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\JAVA\\MainWorkspace\\JavaProCourse\\src\\lesson02\\withJSON\\JSON3\\json.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().create();
        JSON3 json3 = gson.fromJson(builder.toString(), JSON3.class);
        System.out.println(json3.name);
        System.out.println(json3.surname);
        System.out.println(Arrays.deepToString(json3.phones));
        System.out.println(Arrays.deepToString(json3.sites));
        System.out.println(json3.address.country);
        System.out.println(json3.address.city);
        System.out.println(json3.address.street);
    }
}
