/* Lab 1: Create a view to show all employees along with their department names. 
 Lab 2: Modify the view to exclude employees whose salaries are below $50,000. */

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
CREATE VIEW emp_dept_view AS
SELECT e.emp_id, e.emp_name, d.dept_name, e.salary
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id;
SELECT * FROM emp_dept_view;
-- lab 2
CREATE OR REPLACE VIEW emp_dept_view AS
SELECT e.emp_id, e.emp_name, d.dept_name, e.salary
FROM employees e
JOIN departments d
ON e.dept_id = d.dept_id
WHERE e.salary >= 50000;
SELECT * FROM emp_dept_view;