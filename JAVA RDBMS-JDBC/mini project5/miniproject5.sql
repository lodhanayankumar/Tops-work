CREATE TABLE expenses(

expense_id INT PRIMARY KEY AUTO_INCREMENT,

user_id INT,

amount DECIMAL(10,2),

expense_date DATE,

category_id INT,

description VARCHAR(200),

FOREIGN KEY(category_id)
REFERENCES SpendingCategory(id)

);