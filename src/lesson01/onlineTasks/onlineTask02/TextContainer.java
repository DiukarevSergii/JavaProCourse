package lesson01.onlineTasks.onlineTask02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@TextContainer.SaveTo
public class TextContainer {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface SaveTo{
        String path() default "D:/files/container.txt";

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Saver{

    }

    String text = "texttext";

    @Saver
    public void save(String path){
        try (FileWriter writer = new FileWriter(new File(path))){
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        SaveTo saveTo = container.getClass().getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = container.getClass().getDeclaredMethods();
        for (Method method: methods){
            if (method.isAnnotationPresent(Saver.class)){
                container.save(path);
            }
        }
    }
}
