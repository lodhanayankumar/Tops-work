/* Lab 1: Insert three records into the courses table using the INSERT command. 
Lab 2: Update the course duration of a specific course using the UPDATE command. 
Lab 3: Delete a course with a specific course_id from the courses table using the DELETE 
command. */  
CREATE DATABASE university_db;
USE university_db;
DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(20),
    course_duration INT
);
-- Lab 1
INSERT INTO courses VALUES
(1, 'Maths', 6),
(2, 'Physics', 5),
(3, 'Chemistry', 4);
-- Lab 2
UPDATE courses
SET course_duration = 7
WHERE course_id = 2;
-- Lab 3
DELETE FROM courses
WHERE course_id = 3;
SELECT * FROM courses;