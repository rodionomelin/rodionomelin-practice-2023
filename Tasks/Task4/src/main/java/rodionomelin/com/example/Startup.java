package rodionomelin.com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Startup {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        ReportBuilder reportBuilder = (ReportBuilder) context.getBean("reportBuilder");

        reportBuilder.buildReport("input.txt");
    }
}