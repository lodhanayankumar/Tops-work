//3. Variable Scope 
//o Write a program that demonstrates the difference between local and global 
//variables in C++. Use functions to show scope. 
//o Objective: Reinforce the concept of variable scope. 

#include <iostream>
using namespace std;

// Global variable: Declared outside all functions
int globalVar = 100;

void testFunction() {
    // Local variable: Declared inside a function
    // Only accessible within this function
    int localVar = 20;

    cout << "--- Inside testFunction ---" << endl;
    cout << "Local Variable : " << localVar << endl;
    cout << "Global Variable : " << globalVar << endl << endl;
}

int main() {
    // Local variable specific to main()
    int mainVar = 50;

    cout << "--- Inside main ---" << endl;
    cout << "Main Local Variable : " << mainVar << endl;
    cout << "Global Variable : " << globalVar << endl << endl;

    // Call function to show scope differences
    testFunction();
}

