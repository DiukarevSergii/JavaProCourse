package lesson1.annotations.annotation1;

import java.lang.reflect.Field;

public class MyClass {
    @MyAnnotation1
    static String str;

    public String getStr() {
        return str;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        MyClass myClass = new MyClass();
        System.out.println(myClass.getStr());

//        Class cls = myClass.getClass();
//        Field field = cls.getDeclaredField("str");

        Field field = MyClass.class.getDeclaredField("str");

        MyAnnotation1 myAnnotation1 = field.getAnnotation(MyAnnotation1.class);
        System.out.println(myAnnotation1.str());
    }
}
