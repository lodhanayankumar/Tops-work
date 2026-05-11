/* Lab 1: Create a trigger to automatically log changes to the employees 
table when a new employee is added. 
 Lab 2: Create a trigger to update the last_modified timestamp whenever 
an employee record is updated. */

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

CREATE TABLE employee_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    action VARCHAR(50),
    log_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- lab 1
DELIMITER //

CREATE TRIGGER after_employee_insert
AFTER INSERT ON employees
FOR EACH ROW
BEGIN
    INSERT INTO employee_log(emp_id, action)
    VALUES (NEW.emp_id, 'Employee Added');
END //

DELIMITER ;
INSERT INTO employees VALUES (105, 'AMAN', 1, 50000);
SELECT * FROM employee_log;
ALTER TABLE employees
ADD last_modified TIMESTAMP;

-- lab 2
DELIMITER //

CREATE TRIGGER before_employee_update
BEFORE UPDATE ON employees
FOR EACH ROW
BEGIN
    SET NEW.last_modified = CURRENT_TIMESTAMP;
END //

DELIMITER ;
UPDATE employees
SET salary = 60000
WHERE emp_id = 101;

SELECT * FROM employees;