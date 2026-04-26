//1. Class for a Simple Calculator 
//o Write a C++ program that defines a class Calculator with functions for addition, 
//subtraction, multiplication, and division. Create objects to use these functions. 
//o Objective: Introduce basic class structure. 

#include <iostream>
using namespace std;

class Calculator 
{
public:
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
        if (b != 0)
            return (float)a / b;
        else 
		{
            cout << "Error: Division by zero!" << endl;
            return 0;
        }
    }
};

int main() 
{
    Calculator calc;  // object of class
    int a, b, choice;

    cout << "Enter two numbers: ";
    cin >> a >> b;

    cout << "\nChoose operation:" << endl;
    cout << "1. Add\n2. Subtract\n3. Multiply\n4. Divide" << endl;
    cout << "Enter choice: ";
    cin >> choice;

    if (choice == 1) 
	{
        cout << "Result: " << calc.add(a, b) << endl;
    }
    else if (choice == 2) 
	{
        cout << "Result: " << calc.subtract(a, b) << endl;
    }
    else if (choice == 3) 
	{
        cout << "Result: " << calc.multiply(a, b) << endl;
    }
    else if (choice == 4) 
	{
        cout << "Result: " << calc.divide(a, b) << endl;
    }
    else 
	{
        cout << "Invalid choice!" << endl;
    }
}

