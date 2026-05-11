/* Lab 1: Create two new users user1 and user2 and grant user1 permission to SELECT 
from the courses table. 
 Lab 2: Revoke the INSERT permission from user1 and give it to user2. */

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

CREATE USER 'user1'@'localhost' IDENTIFIED BY 'pass123';
CREATE USER 'user2'@'localhost' IDENTIFIED BY 'pass123';

GRANT SELECT ON university_db.courses TO 'user1'@'localhost';
-- LAB 2
REVOKE INSERT ON university_db.courses FROM 'user1'@'localhost';
GRANT INSERT ON university_db.courses TO 'user2'@'localhost';