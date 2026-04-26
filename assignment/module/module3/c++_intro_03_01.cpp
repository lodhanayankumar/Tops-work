//3. POP vs. OOP Comparison Program 
//o Write two small programs: one using Procedural Programming (POP) to calculate the 
//area of a rectangle, and another using Object-Oriented Programming (OOP) with a 
//class and object for the same task. 
//o Objective: Highlight the difference between POP and OOP approaches.
//1.pop

#include <iostream>
using namespace std;

float calculateArea(float length, float width) 
{
    return length * width;
}
int main() 
{
    float length = 7.0;
    float width  = 4.0;
    float area = calculateArea(length, width);
    cout << "[POP] Area = "<< area << endl;
}
