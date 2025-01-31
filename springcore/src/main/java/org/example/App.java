package org.example;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // Retrieve the Student bean
        Student student = (Student) context.getBean("student");

        // Print the student details
        System.out.println(student);
    }
}
