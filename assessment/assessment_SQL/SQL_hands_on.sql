/* Given Database Schema (DO NOT MODIFY) 
users ( 
user_id INT PRIMARY KEY, 
name VARCHAR(50), 
email VARCHAR(100), 
created_at DATE 
); 
categories ( 
category_id INT PRIMARY KEY, 
category_name VARCHAR(50) 
);
expenses ( 
expense_id INT PRIMARY KEY, 
user_id INT, 
category_id INT, 
amount DECIMAL(10,2), 
expense_date DATE, 
FOREIGN KEY (user_id) REFERENCES users(user_id), 
FOREIGN KEY (category_id) REFERENCES categories(category_id) 
); 
*/
/*
1. DDL Understanding 
Without modifying the schema: 
● Explain why foreign keys are used: Specifically, why must user_id in 
the expenses table correspond to a real ID in the users table?
        --  Foreign keys are used to maintain referential integrity 
            between related tables.
		In the expenses table:
           -- user_id is a foreign key that references users(user_id)
           -- category_id is a foreign key that references 
              categories(category_id)
        This means:
		   -- Every expense must belong to a valid user already present 
              in the users table.
           -- Every expense must be assigned to a valid category already 
			  present in the categories table.
     --  Suppose we try to insert this record into expenses:
         [ INSERT INTO expenses
           VALUES (101, 999, 1, 500.00, '2026-05-12'); ]
	   -- Here, user_id = 999.
		If no such user exists in the users table, the database 
          will reject the insert because of the foreign key constraint.
		This prevents storing an expense that does not belong to 
           any real user.
        
 ● Mention one issue that would occur if foreign keys were removed: 
Describe the risk of "Orphaned Records" (e.g., an expense existing for a 
user who has been deleted). 
  -- Without foreign keys, the database would allow records in 
     expenses that reference non-existent users or categories       
*/
/* 
2. DML Operations 
Write SQL queries to: 
● Insert 5 users into the users table with unique names and emails. 
● Insert 3 categories (e.g., 'Food', 'Rent', 'Entertainment'). 
● Insert 10 expense records distributed across different users and 
categories. 
● Update one incorrect expense: Use the UPDATE command to change 
the amount of a specific expense_id. 
● Delete one expense: Remove a record where the amount is less than a 
specific value.

--Insert 5 Users
INSERT INTO users (user_id, name, email, created_at)
VALUES
(1, 'Rahul', 'rahul@gmail.com', '2026-05-01'),
(2, 'Priya', 'priya@gmail.com', '2026-05-01'),
(3, 'Amit', 'amit@gmail.com', '2026-05-02'),
(4, 'Sneha', 'sneha@gmail.com', '2026-05-02'),
(5, 'Karan', 'karan@gmail.com', '2026-05-03');

--Insert 3 Categories
INSERT INTO categories (category_id, category_name)
VALUES
(1, 'Food'),
(2, 'Rent'),
(3, 'Entertainment');

--Insert 10 Expense Records
INSERT INTO expenses (expense_id, user_id, category_id, amount, expense_date)
VALUES
(101, 1, 1, 250.00, '2026-05-01'),
(102, 1, 2, 8000.00, '2026-05-01'),
(103, 2, 1, 180.00, '2026-05-02'),
(104, 2, 3, 500.00, '2026-05-03'),
(105, 3, 2, 7500.00, '2026-05-03'),
(106, 3, 1, 220.00, '2026-05-04'),
(107, 4, 3, 650.00, '2026-05-04'),
(108, 4, 1, 140.00, '2026-05-05'),
(109, 5, 2, 9000.00, '2026-05-05'),
(110, 5, 3, 300.00, '2026-05-06');

--Update One Incorrect Expense
Change the amount of expense_id = 104 from 500.00 to 550.00.
UPDATE expenses
SET amount = 550.00
WHERE expense_id = 104;

-- Delete One Expense
Remove one expense where the amount is less than 150.00.
DELETE FROM expenses
WHERE amount < 150.00
LIMIT 1;
*/
/*
3. Data Retrieval 
Write queries to: 
● Display all expenses with details: Show the expense_date, amount, 
name (from users), and category_name (from categories) using INNER 
JOIN. 
● Show total expense amount per category: Use SUM(amount) and GROUP 
BY category_name. 
● Display users sorted by total spending: List user names and their total 
sum of expenses, ordered from highest to lowest. 


-- Display All Expenses with User and Category Details (INNER JOIN)

SELECT
    e.expense_date,
    e.amount,
    u.name,
    c.category_name
FROM expenses e
INNER JOIN users u
    ON e.user_id = u.user_id
INNER JOIN categories c
    ON e.category_id = c.category_id
ORDER BY e.expense_date;

-- Show Total Expense Amount per Category

SELECT
    c.category_name,
    SUM(e.amount) AS total_expense
FROM expenses e
INNER JOIN categories c
    ON e.category_id = c.category_id
GROUP BY c.category_name
ORDER BY total_expense DESC;

-- Display Users Sorted by Total Spending (Highest to Lowest

SELECT
    u.name,
    SUM(e.amount) AS total_spending
FROM expenses e
INNER JOIN users u
    ON e.user_id = u.user_id
GROUP BY u.name
ORDER BY total_spending DESC;
*/ 
/*
4. Views 
● Create a view named ActiveUsersView: This view should list the name 
and email of any user who has logged more than 5 individual expense 
records. 
● Query the view: Write a simple SELECT statement to show all data from 
ActiveUsersView.

-- Create ActiveUsersView
    This view displays the name and email of users who have 
	more than 5 expense records in the expenses table.
 
CREATE VIEW ActiveUsersView AS
SELECT
    u.name,
    u.email
FROM users u
INNER JOIN expenses e
    ON u.user_id = e.user_id
GROUP BY
    u.user_id,
    u.name,
    u.email
HAVING COUNT(e.expense_id) > 5;
SELECT * FROM ActiveUsersView;

