package ru.levnikolaevich.littlebrother;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionServer {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("xml-beans.xml");
    }
}
