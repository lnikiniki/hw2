package com.epam.lab.tasks;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

class Task4 {

    private static Logger LOG = Logger.getLogger(Task4.class);

    private static void method1(int a) {
        LOG.info(a);
    }

    private static String method2() {
        return "Method 2";
    }

    private static int method3(String string) {
        return string.length();
    }

    static void task4() {
        try {
            Task4.class.getDeclaredMethod("method1", int.class).invoke(null, 3);
            LOG.info(Task4.class.getDeclaredMethod("method2").invoke(null));
            LOG.info(Task4.class.getDeclaredMethod("method3", String.class).invoke(null, "aaaaaaa"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
