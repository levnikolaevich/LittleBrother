package ru.levnikolaevich.littlebrother;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("xml-beans-student.xml");
    }
}
