package com.epam.lab.tasks;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.epam.lab.tasks.Task4.task4;
import static com.epam.lab.tasks.Task6.task6;

public class Task2 {

    private static final Logger LOG = Logger.getLogger(Task2.class);

    @MyAnnotation(1)
    private String name;
    @MyAnnotation(2)
    private String age;
    private int id;

    private static void task2() {
        for (Field field : Task2.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                LOG.info(field.getName());
            }
        }
    }

    private static void task3() {
        for (Field field : Task2.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                LOG.info(String.format("@MyAnnotation(value = %s)", field.getAnnotation(MyAnnotation.class).value()));
            }
        }
    }

    private static void task51(Class<?> cls, Object a) {
        Task2 task = new Task2();
        try {
            Field field = Task2.class.getDeclaredField("id");
            if (field.getType().equals(cls)) {
                field.set(task, a);
                LOG.info(task.id);
            } else {
                LOG.info(String.format("Type of field id is not a %s", cls.getName()));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void task5() {
        Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();
        map.put(long.class, 234567890L);
        map.put(double.class, 123.2);
        map.put(float.class, 121.4f);
        map.put(boolean.class, true);
        map.put(byte.class, 32);
        map.put(char.class, "d");
        map.put(String.class, "String");
        map.put(int.class, 10);
        for (Map.Entry entry : map.entrySet()) {
            task51((Class<?>) entry.getKey(), entry.getValue());
        }

    }

    public static void main(String[] args) {
        task2();
        task3();
        task4();
        task5();
        task6();
        Task7<Integer> task = new Task7<Integer>(2);
        task.task7();
    }
}
