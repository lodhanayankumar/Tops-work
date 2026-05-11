-- Lab 1: Modify the courses table by adding a column course_duration 
-- using the ALTER command. 
-- Lab 2: Drop the course_credits column from the courses table. 


CREATE DATABASE  university_db;
USE  university_db;
CREATE TABLE courses (
course_id INT, course_name VARCHAR(20),
course_cradits INT
);

ALTER TABLE course ADD course_duration INT;