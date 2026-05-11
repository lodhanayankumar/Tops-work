-- Lab 1: Modify the courses table by adding a column course_duration 
-- using the ALTER command. 
-- Lab 2: Drop the course_credits column from the courses table. 
CREATE DATABASE  university_db;
USE  university_db;
DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
course_id INT, course_name VARCHAR(20),
course_credits INT
);
SELECT * FROM courses;
ALTER TABLE courses ADD course_duration INT;
SELECT * FROM courses;
-- lab task 2
ALTER TABLE courses
DROP COLUMN course_credits;
SELECT * FROM courses;
