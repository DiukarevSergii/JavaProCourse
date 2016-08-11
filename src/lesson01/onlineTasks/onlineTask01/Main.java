package lesson01.onlineTasks.onlineTask01;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Main main = new Main();
        Method[] methods = main.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                main.saver(test.a(), test.b());
            }
        }
    }

    @Test
    public void saver(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
