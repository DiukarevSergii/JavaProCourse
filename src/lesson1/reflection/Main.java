package lesson1.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Znachenie z = new Znachenie();
        System.out.println(z.getI());

        Field[] fields = z.getClass().getDeclaredFields();

        for (Field field: fields){
            if(field.getModifiers() == Modifier.PRIVATE){
                field.setAccessible(true);
                try {
                    field.setInt(z, 45);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(z.getI());
        //
    }
}
