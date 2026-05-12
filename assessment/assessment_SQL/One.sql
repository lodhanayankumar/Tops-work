CREATE DATABASE ExpenseTracker;
USE ExpenseTracker;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE Expenses (
    expense_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    category_id INT,
    amount DECIMAL(10,2) NOT NULL,
    expense_date DATE NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Insert Users
INSERT INTO Users (user_name, email)
VALUES
('Rahul', 'rahul@gmail.com'),
('Priya', 'priya@gmail.com'),
('amit', 'amit@gmail.com'),
('ganesh', 'ganesh@gmil.com'),
('mukund', 'mukund@gmail.com'),
('parth', 'parth@gmail.com');
select * from Users;
-- Insert Categories
INSERT INTO Categories (category_name)
VALUES
('Food'),
('Transport'),
('Shopping'),
('Bills');
select * from Categories;
-- Insert Expenses
INSERT INTO Expenses (user_id, category_id, amount, expense_date, description)
VALUES
(1, 1, 250.00, '2026-05-01', 'Lunch'),
(1, 2, 120.00, '2026-05-03', 'Auto Fare'),
(1, 4, 1500.00, '2026-05-05', 'Electricity Bill'),
(2, 3, 2000.00, '2026-05-02', 'Clothes Shopping'),
(3, 1, 350.00, '2026-05-01', 'Lunch'),
(4, 2, 160.00, '2026-05-05', 'Auto Fare'),
(5, 4, 1100.00, '2026-05-04', 'Electricity Bill'),
(6, 3, 2600.00, '2026-05-07', 'Clothes Shopping'),
(4, 1, 210.00, '2026-05-06', 'Lunch'),
(4, 2, 150.00, '2026-05-02', 'Auto Fare'),
(6, 4, 1700.00, '2026-05-04', 'Electricity Bill'),
(5, 3, 400.00, '2026-05-02', 'Clothes Shopping');
select * from expenses;
-- crud 1
-- create
INSERT INTO Expenses (user_id, category_id, amount, expense_date, description)
VALUES (2, 1, 450.00, '2026-05-10', 'Dinner');
-- read
SELECT
    e.expense_id,
    u.user_name,
    c.category_name,
    e.amount,
    e.expense_date,
    e.description
FROM Expenses e
JOIN Users u ON e.user_id = u.user_id
JOIN Categories c ON e.category_id = c.category_id
ORDER BY e.expense_id;
-- update
UPDATE Expenses
SET amount = 500.00,
    description = 'Dinner with Family'
WHERE expense_id = 13;
select * from Expenses;
-- delete
DELETE FROM Expenses
WHERE expense_id = 13;
select * from Expenses;
/* Stored Procedure: Calculate Monthly User Expense */
DELIMITER //

CREATE PROCEDURE GetMonthlyExpense(
    IN p_user_id INT,
    IN p_year INT,
    IN p_month INT
)
BEGIN
    SELECT
        u.user_name,
        p_year AS year,
        p_month AS month,
        SUM(e.amount) AS total_expense
    FROM Expenses e
    JOIN Users u ON e.user_id = u.user_id
    WHERE e.user_id = p_user_id
      AND YEAR(e.expense_date) = p_year
      AND MONTH(e.expense_date) = p_month
    GROUP BY u.user_name;
END //

DELIMITER ;
CALL GetMonthlyExpense(1, 2026, 5);
/* COMMIT Example */
START TRANSACTION;

INSERT INTO Expenses (user_id, category_id, amount, expense_date, description)
VALUES (3, 2, 75.00, '2026-05-12', 'Bus Fare');

COMMIT;
SELECT * FROM Expenses
WHERE description = 'Bus Fare';

/* ROLLBACK Example */
START TRANSACTION;

INSERT INTO Expenses (user_id, category_id, amount, expense_date, 
description)
VALUES (4, 3, 9999.00, '2026-05-12', 'Mistaken Purchase');

ROLLBACK;
SELECT * FROM Expenses
WHERE description = 'Mistaken Purchase';