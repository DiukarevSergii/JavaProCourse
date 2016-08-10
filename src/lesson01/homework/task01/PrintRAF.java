package lesson01.homework.task01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class PrintRAF {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("D://files/file.txt"), "rw")) {
            System.out.println("Class: " + randomAccessFile.getClass().getName() + "\n");

            allIntrefaces(randomAccessFile);
            allConstructor(randomAccessFile);
            allFields(randomAccessFile);
            allMethods(randomAccessFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void allIntrefaces(RandomAccessFile randomAccessFile) {
        Class<?>[] interfaces = randomAccessFile.getClass().getInterfaces();
        System.out.println("All implemented  interfaces: " + interfaces.length);
        for (Class<?> interfacee : interfaces) {
            System.out.println("\t" + interfacee.getName());
        }
        System.out.println();
    }

    public static void allConstructor(RandomAccessFile randomAccessFile) {
        Constructor[] constructors = randomAccessFile.getClass().getDeclaredConstructors();
        System.out.println("All the constructors. These are public, protected, default (package) access," +
                " and private constructors: " + constructors.length);
        for (Constructor constructor : constructors) {
            System.out.print("\t" + constructor.getName());
            if (constructor.getParameterCount() > 0) {
                System.out.print("(");
                Parameter[] parameters = constructor.getParameters();
                for (int i = 0; i < parameters.length; ) {
                    System.out.print(parameters[i].getType());
                    i++;
                    if (i != parameters.length) {
                        System.out.print(", ");
                    } else {
                        System.out.println(")");
                    }
                }
            }
        }
        System.out.println();
    }

    public static void allFields(RandomAccessFile randomAccessFile) {
        Field[] fields = randomAccessFile.getClass().getDeclaredFields();
        System.out.println("All the fields. " +
                "Includes public, protected, default (package) access, and private fields," +
                " but excludes inherited fields: " + fields.length);
        for (Field field : fields) {
            System.out.println("\t" + field.getName());
        }
        fields = randomAccessFile.getClass().getFields();
        System.out.println("\nAll the accessible public fields: " + fields.length);
        if (fields.length == 0) {
            System.out.println("");
        } else {
            for (Field field : fields) {
                System.out.println("\t" + field.getName());
            }
        }
    }

    public static void allMethods(RandomAccessFile randomAccessFile) {
        Method[] methods = randomAccessFile.getClass().getDeclaredMethods();
        System.out.println("All the declared methods. " +
                "Public, protected, default (package) access, and private methods, but excluding inherited methods: "
                + methods.length);
        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }
        methods = randomAccessFile.getClass().getMethods();
        System.out.println("\nAll the public methods. " +
                "Including those declared by the class or interface " +
                "and those inherited from superclasses and superinterfaces: " + methods.length);
        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }
    }


}

