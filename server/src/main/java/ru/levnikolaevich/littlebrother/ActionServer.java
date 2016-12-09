package ru.levnikolaevich.littlebrother;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionServer {

    public static void main(String[] args) {
//        new ClassPathXmlApplicationContext(new String[]{"xml-beans.xml", "META-INF/persistence.xml"});

        new ClassPathXmlApplicationContext(new String[]{"xml-beans.xml"});
    }
}
