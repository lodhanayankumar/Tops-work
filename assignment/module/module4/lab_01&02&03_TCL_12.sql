/* Lab 1: Insert a few rows into the courses table 
          and use COMMIT to save the changes. 
 Lab 2: Insert additional rows, then use ROLLBACK 
        to undo the last insert operation. 
 Lab 3: Create a SAVEPOINT before updating the courses table, 
        and use it to roll back specific changes. */


CREATE DATABASE university_db;
USE university_db;
DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(20),
    course_duration INT
);
INSERT INTO courses VALUES
(1, 'Maths', 6),
(2, 'Physics', 5);
-- LAB 1
START TRANSACTION;
INSERT INTO courses VALUES
(3, 'Chemistry', 4),
(4, 'Biology', 8),
(5, 'Computer', 9),
(6, 'English', 3),
(7, 'History', 6);
COMMIT;
SELECT * FROM courses;
-- LAB 2
START TRANSACTION;
INSERT INTO courses VALUES 
(8, 'Geography', 4),
(9, 'Economics', 5);
ROLLBACK;
SELECT * FROM courses;
-- LAB 3
START TRANSACTION; 
SAVEPOINT sp1;
UPDATE courses
SET course_duration = 99
WHERE course_id IN (1, 2, 3);
SELECT * FROM courses;
ROLLBACK TO SAVEPOINT sp1;
COMMIT;
SELECT * FROM courses;