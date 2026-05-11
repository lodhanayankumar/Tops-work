-- Lab 1: Write SQL queries to retrieve specific columns (student_name and age) from the 
-- students table. 

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