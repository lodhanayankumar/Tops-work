/* Lab 1: Create two tables: departments and employees. Perform an INNER 
JOIN to display employees along with their respective departments. 
Lab 2: Use a LEFT JOIN to show all departments, even those without employees.
*/
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
-- LAB 1
SELECT e.emp_id, e.emp_name, d.dept_name
FROM employees e
INNER JOIN departments d
ON e.dept_id = d.dept_id;
-- lab 2
SELECT d.dept_id, d.dept_name, e.emp_name
FROM departments d
LEFT JOIN employees e
ON d.dept_id = e.dept_id;