package mini_project_C_jdbc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodDeliveryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuDAO menuDAO = new MenuDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Load menu from database
        ArrayList<MenuItem> menuList = menuDAO.loadMenu();

        while (true) {

            System.out.println("\n==================================");
            System.out.println("      FOOD DELIVERY SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Browse Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View My Order History");
            System.out.println("4. Exit");
            System.out.println("==================================");
            System.out.print("Enter Your Choice : ");

            try {

                int choice = sc.nextInt();

                switch (choice) {

                case 1:

                    // Reload latest menu
                    menuList = menuDAO.loadMenu();
                    menuDAO.displayMenu(menuList);
                    break;

                case 2:

                    try {

                        System.out.print("Enter Customer ID : ");
                        int customerId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Restaurant Name : ");
                        String restaurantName = sc.nextLine();

                        System.out.print("Enter Order Amount : ");
                        double amount = sc.nextDouble();

                        if (amount <= 0) {
                            System.out.println("Amount cannot be negative or zero.");
                            break;
                        }

                        orderDAO.placeOrder(customerId, restaurantName, amount);

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid Input! Please enter numeric values.");
                        sc.nextLine();
                    }

                    break;

                case 3:

                    try {

                        System.out.print("Enter Customer ID : ");
                        int customerId = sc.nextInt();

                        orderDAO.viewOrderHistory(customerId);

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid Customer ID.");
                        sc.nextLine();
                    }

                    break;

                case 4:

                    System.out.println("\nThank You!");
                    System.out.println("Visit Again.");
                    sc.close();
                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid Choice! Please select between 1 and 4.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter numbers only.");
                sc.nextLine();

            }

        }

    }

}