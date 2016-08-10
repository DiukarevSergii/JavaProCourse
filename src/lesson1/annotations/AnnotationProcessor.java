package lesson1.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class AnnotationProcessor {
    static Map<String, Class<?>> map = new HashMap<>();
    static Map<String, Object> map2 = new HashMap<>();

    public static void main(String[] args) {
//        inspectService(SimpleService.class);
//        inspectService(LazyService.class);
//        inspectService(String.class);

//        loadService("annotations.SimpleService");
//        loadService("annotations.LazyService");
//        loadService("java.lang.String");

//        loadMethod(SimpleService.class);
//        loadMethod(LazyService.class);
//        loadMethod(String.class);

        change(LazyService.class);

//        System.out.println(map2);
    }

    static void change(Class<?> clazz) {
        try {
            Object obj = clazz.newInstance();
            Field field;
            if ((field = clazz.getDeclaredField("pri")) != null){
                field.setAccessible(true);
                System.out.println(field.getInt(obj));
                field.setInt(obj, 47);
                System.out.println(field.getInt(obj));
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    static void loadService(String name) {
        try {
            Class<?> clazz = Class.forName(name);
            if (clazz.isAnnotationPresent(Service.class)) {
                Object serviceObj = clazz.newInstance();
                map2.put(name, serviceObj);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    static void loadMethod(Class<?> service) {
        for (Method method : service.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                try {
                    Object serviceObj = service.newInstance();
                    method.invoke(serviceObj);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    Init init = method.getAnnotation(Init.class);
                    if (init.suppressException()) {
                        System.err.println(e.getMessage());
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }

    static void inspectService(Class<?> service) {
        for (Annotation annotation : service.getAnnotations()) {
            if (annotation.annotationType().getSimpleName().equals("Service")) {
                map.put(service.getAnnotation(Service.class).name(), service);
            } else {
                System.out.println("Not found: " + annotation.annotationType().getSimpleName());
            }
        }
    }
}
