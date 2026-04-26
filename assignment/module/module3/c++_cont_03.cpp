//3. Multiplication Table 
//o Write a C++ program to display the multiplication table of a given number using a for 
//loop. 
//o Objective: Practice using loops. 
#include <iostream>
using namespace std;

int main() {
    int num;

    cout << "Enter a number: ";
    cin >> num;

    cout << "Multiplication Table of " << num << ":" << endl;

    for (int i = 1; i <= 10; i++) {
        cout << num << " x " << i << " = " << num * i << endl;
    }
}
