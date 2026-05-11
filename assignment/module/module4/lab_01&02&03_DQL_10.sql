/* Lab 1: Retrieve all courses from the courses table using the 
SELECT statement. 
 Lab 2: Sort the courses based on 
 course_duration in descending order using ORDER BY. 
 Lab 3: Limit the results of the SELECT 
 query to show only the top two courses using LIMIT. */


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
INSERT INTO courses VALUES
(3, 'Chemistry', 4),
(4, 'Biology', 8),
(5, 'Computer', 9),
(6, 'English', 3),
(7, 'History', 6);
-- LAB 1
SELECT * FROM courses;
-- LAB 2
SELECT * FROM courses
ORDER BY course_duration DESC;
-- LAB 3
SELECT * FROM courses
ORDER BY course_duration DESC
LIMIT 2;