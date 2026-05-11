-- Lab 1: Create a table teachers with the following columns: teacher_id (Primary Key), 
-- teacher_name (NOT NULL), subject (NOT NULL), and email (UNIQUE). 
CREATE DATABASE school_db;
USE school_db;
DROP TABLE IF EXISTS students;
CREATE TABLE students (
    student_id INT,
    student_name VARCHAR(50),
    age INT,
    class INT,
    address VARCHAR(100)
);
SELECT * FROM students;
 insert INTO students values(011001,'NAYANKUMAR',20,12,'DEESA'),
 (011002,'PARTH',19,11,'amreli'),
 (011003,'riya',18,10,'ahmedabad'),
 (011004,'bhavesh',19,11,'gandhinagar'),
 (011005,'ashok',22,12,'ahmedabad');
 SELECT * FROM students;
 select student_name,age from students;
 SELECT * FROM students where age>10;
 
 CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY,
    teacher_name VARCHAR(50) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);
SELECT * FROM teachers;