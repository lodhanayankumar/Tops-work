package com.example.playlist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//IoC container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

// Get bean
        UserProfile userProfile = context.getBean("userProfile", UserProfile.class);

        userProfile.sendNotification();

        context.close();
    }
}
