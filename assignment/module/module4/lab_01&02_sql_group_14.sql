/* Lab 1: Group employees by department and count the number of 
employees in each department using GROUP BY. 
Lab 2: Use the AVG aggregate function to find the average salary of 
employees in each department. */

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
SELECT dept_id, COUNT(emp_id) AS total_employees
FROM employees
GROUP BY dept_id;
-- lab 2
SELECT dept_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY dept_id;