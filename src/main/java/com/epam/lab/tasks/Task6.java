package com.epam.lab.tasks;

import java.lang.reflect.InvocationTargetException;

class Task6 {
    private static void myMethod(String a, int... args) {

    }

    private static void myMethod(int... args) {

    }

    static void task6() {
        try {
            Task6.class.getDeclaredMethod("myMethod", int[].class).invoke(null, (Object) new int[]{4, 3, 2, 5});
            Task6.class.getDeclaredMethod("myMethod", String.class, int[].class).invoke(null, "A", new int[]{4, 3, 2, 5});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
