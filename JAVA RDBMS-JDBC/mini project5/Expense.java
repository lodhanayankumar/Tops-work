/*1.Create a MySQL table named 'SpendingCategory' with columns id (INT, PK, AUTO_INCREMENT) and name (VARCHAR), 
 * then insert 5 sample categories like 'Food', 'Travel', 'Shopping', 'Bills', 'Entertainment'.
 */
package jdbc_mini_project5;

public class Expense {

    private int id;
    private int userId;
    private double amount;
    private String date;
    private int categoryId;
    private String description;

    // Constructor
    public Expense(int userId, double amount, String date, int categoryId, String description) {
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.categoryId = categoryId;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}