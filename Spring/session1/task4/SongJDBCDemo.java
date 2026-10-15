package com.example.playlist;

import org.springframework.jdbc.core.JdbcTemplate;

public class SongJDBCDemo {

    public static void main(String[] args) {

//JDBC is available
        System.out.println("Spring JDBC module loaded successfully!");

//Check JdbcTemplate
        System.out.println("JdbcTemplate class: " + JdbcTemplate.class.getName());
    }
}
