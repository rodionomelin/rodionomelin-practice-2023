package rodionomelin.com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        ReportBuilder reportBuilder = (ReportBuilder) context.getBean("reportBuilder");

        reportBuilder.buildReport("input.txt");
    }
}