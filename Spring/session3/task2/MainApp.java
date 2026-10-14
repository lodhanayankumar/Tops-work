package com.example.playlist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // Load Spring IoC container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        // Retrieve UserSession twice
        UserSession session1 =
                context.getBean("userSession", UserSession.class);

        UserSession session2 =
                context.getBean("userSession", UserSession.class);

        // Compare UserSession references
        System.out.println("\n===== Prototype Scope =====");
        System.out.println("Same object? " + (session1 == session2));
        System.out.println("Session 1 ID: "
                + System.identityHashCode(session1));
        System.out.println("Session 2 ID: "
                + System.identityHashCode(session2));

        // Retrieve AppConfig twice
        AppConfig config1 =
                context.getBean("appConfig", AppConfig.class);

        AppConfig config2 =
                context.getBean("appConfig", AppConfig.class);

        // Compare AppConfig references
        System.out.println("\n===== Singleton Scope =====");
        System.out.println("Same object? " + (config1 == config2));
        System.out.println("Config 1 ID: "
                + System.identityHashCode(config1));
        System.out.println("Config 2 ID: "
                + System.identityHashCode(config2));

        context.close();
    }
}
