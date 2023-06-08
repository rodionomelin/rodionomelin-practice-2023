package rodionomelin_task2_annotations;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static rodionomelin_task2_annotations.Colors.*;

public class Main {
    public static  void main(String[] args) {
        print(new Messages());
    }

    //
    public static void print(Messages messages) {
        Class<Messages> messagesClass = Messages.class;
        Print classAnnotation = messagesClass.getAnnotation(Print.class);
        Method[] methods = messagesClass.getDeclaredMethods();

        for (Method method : methods) {
            Print methodAnnotation = method.getAnnotation(Print.class);

            String style;
            String color;
            if (methodAnnotation != null) {
                style = methodAnnotation.style();
                color = methodAnnotation.color();
            } else {
                style = classAnnotation.style();
                color = classAnnotation.color();
            }

            try {
                String message = (String) method.invoke(messages);
                System.out.println(color + style + " " + message + " " + style + RESET);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

