/* Lab 1: Write a PL/SQL block using an explicit cursor to retrieve and display employee details. 
Lab 2: Create a cursor to retrieve all courses and display them one by one. */
-- Create and use database
CREATE DATABASE IF NOT EXISTS university_db;
USE university_db;
DELIMITER //

CREATE PROCEDURE check_department_and_list()
BEGIN
    DECLARE v_dept_id INT;
    DECLARE v_emp_name VARCHAR(100) DEFAULT 'NAYAN';
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_name VARCHAR(100);

    -- Cursor for Lab 2
    DECLARE emp_cursor CURSOR FOR
        SELECT emp_name FROM employees;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    /* Lab 1: Check the department of a specific employee */
    SELECT dept_id
    INTO v_dept_id
    FROM employees
    WHERE emp_name = v_emp_name
    LIMIT 1;

    IF v_dept_id = 1 THEN
        SELECT CONCAT(v_emp_name, ' works in HR department') AS Message;
    ELSEIF v_dept_id = 2 THEN
        SELECT CONCAT(v_emp_name, ' works in IT department') AS Message;
    ELSEIF v_dept_id = 3 THEN
        SELECT CONCAT(v_emp_name, ' works in Finance department') AS Message;
    ELSE
        SELECT CONCAT(v_emp_name, ' works in Marketing department') AS Message;
    END IF;

    /* Lab 2: Display all employee names using FOR LOOP equivalent */
    OPEN emp_cursor;

    read_loop: LOOP
        FETCH emp_cursor INTO v_name;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT v_name AS Employee_Name;
    END LOOP;

    CLOSE emp_cursor;
END //

DELIMITER ;
CALL check_department_and_list();