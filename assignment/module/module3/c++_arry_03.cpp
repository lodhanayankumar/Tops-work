//3. String Palindrome Check 
//o Write a C++ program to check if a given string is a palindrome (reads the same 
//forwards and backwards). 
//o Objective: Practice string operations.

#include <iostream>
using namespace std;

int main() 
{
    string str, rev;

    cout << "Enter a string: ";
    cin >> str;

    // Reverse the string
    for (int i = str.length() - 1; i >= 0; i--) 
	{
        rev += str[i];
    }

    // Check palindrome
    if (str == rev) 
	{
        cout << "The string is a Palindrome."<<endl;
    } 
    else 
	{
        cout << "The string is NOT a Palindrome."<<endl;
    }
}
