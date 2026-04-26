//1. Grade Calculator 
//o Write a C++ program that takes a student’s marks as input and calculates the grade 
//based on if-else conditions. 
//o Objective: Practice conditional statements (if-else).
 #include <iostream>
using namespace std;

int main() {
    int marks;

    cout << "Enter student's marks: ";
    cin >> marks;

    if (marks >= 90) {
        cout << "Grade: A" << endl;
    } 
    else if (marks >= 75) {
        cout << "Grade: B" << endl;
    } 
    else if (marks >= 60) {
        cout << "Grade: C" << endl;
    } 
    else if (marks >= 50) {
        cout << "Grade: D" << endl;
    } 
    else {
        cout << "Grade: F" << endl;
    }
}
