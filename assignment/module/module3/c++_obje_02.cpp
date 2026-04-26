//2. Class for Bank Account 
//o Create a class BankAccount with data members like balance and member functions 
//like deposit and withdraw. Implement encapsulation by keeping the data members 
//private. 
//o Objective: Understand encapsulation in classes.

#include <iostream>
using namespace std;

class BankAccount {
private:
    double balance;   // private data member (encapsulation)

public:
    // Constructor to initialize balance
    BankAccount(double b) {
        balance = b;
    }

    // Function to deposit money
    void deposit(double amount) {
        balance += amount;
        cout << "Amount deposited successfully." << endl;
    }

    // Function to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            cout << "Amount withdrawn successfully." << endl;
        } else {
            cout << "Insufficient balance!" << endl;
        }
    }

    // Function to display balance
    void displayBalance() {
        cout << "Current Balance: " << balance << endl;
    }
};

int main() {
    BankAccount account(1000);  // initial balance
    
    int choice;
    double amount;
    do {
        cout << "\n--- Bank Menu ---" << endl;
        cout << "1. Deposit\n2. Withdraw\n3. Show Balance\n4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            cout << "Enter amount to deposit: ";
            cin >> amount;
            account.deposit(amount);
        }
        else if (choice == 2) {
            cout << "Enter amount to withdraw: ";
            cin >> amount;
            account.withdraw(amount);
        }
        else if (choice == 3) {
            account.displayBalance();
        }
        else if (choice == 4) {
            cout << "Thank you for using the bank system." << endl;
        }
        else {
            cout << "Invalid choice!" << endl;
        }
    } while (choice != 4);
}
