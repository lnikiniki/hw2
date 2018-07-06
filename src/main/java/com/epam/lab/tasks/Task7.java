package com.epam.lab.tasks;

import org.apache.log4j.Logger;

import java.lang.reflect.*;

class Task7<T> {
    private static final Logger LOG = Logger.getLogger(Task7.class);

    private T example;

    Task7(T example) {
        this.example = example;
    }

    void task7() {
        Class<?> cls = this.example.getClass();
        LOG.info(String.format("Class name: %s\nPackage: %s\nModifiers: %s", cls.getName(), cls.getPackage().getName(), Modifier.toString(cls.getModifiers())));
    }
}
