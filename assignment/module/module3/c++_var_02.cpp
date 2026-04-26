//2. Type Conversion 
//o Write a C++ program that performs both implicit and explicit type conversions and 
//prints the results. 
//o Objective: Practice type casting in C++. 

#include <iostream>
using namespace std;

int main() 
{
//IMPLICIT 
    int   a = 10;
    float b = 3.5;

    float sum = a + b;  
    int   cut = b;       

    cout << "Implicit: int + float = " << sum << endl;
    cout << "Implicit: float to int = " << cut << endl;
//EXPLICIT 

    int x = 7, y = 2;

    int   div1 = x / y;           // 7/2 = 3 (no decimal)
    float div2 = (float)x / y;    // 7/2 = 3.5 (with decimal)

    double d      = 9.99;
    int    chopped = (int)d;        // 9.99 to 9

    int  code   = 65;
    char letter = (char)code;      // 65 to 'A'

    cout << "Explicit: 7/2 (int)   = " << div1    << endl;
    cout << "Explicit: 7/2 (float) = " << div2    << endl;
    cout << "Explicit: 9.99 to int = " << chopped << endl;
    cout << "Explicit: 65 to char  = " << letter  << endl;
}
