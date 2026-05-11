/* Lab 1: Write a stored procedure to retrieve all employees from the employees table based 
on department. 
Lab 2: Write a stored procedure that accepts course_id as input and returns the course 
details. */
CREATE DATABASE university_db;
USE university_db;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30)
);

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

INSERT INTO departments VALUES
(1, 'HR'),
(2, 'IT'),
(3, 'Finance'),
(4, 'Marketing');
DELETE FROM employees WHERE emp_id IN (101,102,103,104);

INSERT INTO employees VALUES
(101, 'NAYAN', 1),
(102, 'PARTH', 2),
(103, 'RIYA', 2),
(104, 'DAVE', 3);
SELECT * FROM employees;
ALTER TABLE employees
ADD salary INT;
UPDATE employees SET salary = 50000 WHERE emp_id = 101;
UPDATE employees SET salary = 60000 WHERE emp_id = 102;
UPDATE employees SET salary = 55000 WHERE emp_id = 103;
UPDATE employees SET salary = 45000 WHERE emp_id = 104;
-- lab 1
DELIMITER //
CREATE PROCEDURE get_emp_by_dept(IN d_id INT)
BEGIN
    SELECT * FROM employees WHERE dept_id = d_id;
END //
DELIMITER ;
CALL get_emp_by_dept(2);
-- lab 2
DELIMITER //
CREATE PROCEDURE get_course(IN c_id INT)
BEGIN
    SELECT * FROM courses WHERE course_id = c_id;
END //
DELIMITER ;
CALL get_course(1);