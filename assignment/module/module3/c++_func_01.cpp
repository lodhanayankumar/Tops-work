//1. Simple Calculator Using Functions 
//o Write a C++ program that defines functions for basic arithmetic operations (add, 
//subtract, multiply, divide). The main function should call these based on user input. 
//o Objective: Practice defining and using functions in C++. 

#include <iostream>
using namespace std;

// Function definitions
int add(int a, int b) 
{
    return a + b;
}

int subtract(int a, int b) 
{
    return a - b;
}

int multiply(int a, int b) 
{
    return a * b;
}

float divide(int a, int b) 
{
    return (float)a / b;
}

int main() 
{
    int a, b, choice;

    cout << "Enter numbers01: ";
    cin >> a;
    cout << "Enter numbers02: ";
    cin >>b;

    cout << "\nChoose operation:" << endl;
    cout << "1. Add\n2. Subtract\n3. Multiply\n4. Divide" << endl;
    cout << "Enter choice: ";
    cin >> choice;

    if (choice == 1) 
	{
        cout << "Result: " << add(a, b) << endl;
    }
    else if (choice == 2) 
	{
        cout << "Result: " << subtract(a, b) << endl;
    }
    else if (choice == 3) 
	{
        cout << "Result: " << multiply(a, b) << endl;
    }
    else if (choice == 4) 
	{
        if (b != 0)
            cout << "Result: " << divide(a, b) << endl;
        else
            cout << "Error: Division by zero!" << endl;
    }
    else 
	{
        cout << "Invalid choice!" << endl;
    }
}
