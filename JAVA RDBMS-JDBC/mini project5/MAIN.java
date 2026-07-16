package jdbc_mini_project5;

import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Assume user is already logged in
        int userId = 1;

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println(" SMART EXPENSE TRACKER ");
            System.out.println("=================================");
            System.out.println("1. Add Expense");
            System.out.println("2. Monthly Report");
            System.out.println("3. AI Budget Tips");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ExpenseController.addExpense(userId);
                    break;

                case 2:
                    MonthlyReport.report();
                    break;

                case 3:
                    AITips.showTips();
                    break;

                case 4:
                    System.out.println("Thank You for Using Smart Expense Tracker.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}