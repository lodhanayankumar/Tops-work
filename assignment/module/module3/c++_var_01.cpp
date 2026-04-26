//1. Variables and Constants 
//o Write a C++ program that demonstrates the use of variables and constants. Create 
//variables of different data types and perform operations on them. 
//o Objective: Understand the difference between variables and constants. 

#include <iostream>
using namespace std;

int main() {

    // CONSTANTS — value never changes
    const float  PI        = 3.14159;
    const int    MAX_MARKS = 100;

    // VARIABLES — value can change
    int    age    = 20;
    float  radius = 5.5;
    char   grade  = 'A';
    bool   passed = true;

    // Show constants
    cout << "PI        = " << PI        << endl;
    cout<<"-----------------"<<endl;
    // Show variables
    cout << "Age       = " << age    << endl;
    cout << "Radius    = " << radius << endl;

    // Operation: area of circle
    float area = PI * radius * radius;
    cout << "Area      = " << area << endl;

    // Change a variable — allowed!
    age = 21;
    cout << "New Age   = " << age << endl;

    // PI  Cannot change a constant
}
