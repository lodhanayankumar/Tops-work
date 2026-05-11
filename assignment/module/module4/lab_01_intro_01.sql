/* Lab 1: Create a new database named school_db and a 
table called students with the 
following columns: student_id, student_name, age, class, and address. */

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
 