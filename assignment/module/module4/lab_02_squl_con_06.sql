/*Lab 2: Implement a FOREIGN KEY constraint to relate the teacher_id from the 
teachers table with the students table. */ 
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
 ALTER TABLE students ADD teacher_id INT; 
  SELECT * FROM students;
 CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY,
    teacher_name VARCHAR(50) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);
INSERT INTO teachers VALUES
(1, 'Mr. Sharma', 'Mathematics', 'sharma@school.com'),
(2, 'Ms. Patel',  'Science',     'patel@school.com'),
(3, 'Mr. Mehta',  'English',     'mehta@school.com');

SELECT * FROM teachers;
ALTER TABLE students
ADD CONSTRAINT fk_teacher
FOREIGN KEY (teacher_id)
REFERENCES teachers(teacher_id);
