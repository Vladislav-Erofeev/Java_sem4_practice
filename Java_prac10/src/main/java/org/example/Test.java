package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigClass.class);
        MagicanList list = context.getBean(MagicanList.class);
        list.magic();
        list.magic();
        list.magic();
        list.magic();
        context.close();
    }
}
