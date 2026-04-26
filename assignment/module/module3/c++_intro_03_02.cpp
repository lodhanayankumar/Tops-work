//3. POP vs. OOP Comparison Program 
//o Write two small programs: one using Procedural Programming (POP) to calculate the 
//area of a rectangle, and another using Object-Oriented Programming (OOP) with a 
//class and object for the same task. 
//o Objective: Highlight the difference between POP and OOP approaches.
//1.oop
#include <iostream>
using namespace std;

class Rectangle 
{
  private:
    float length;
    float width;

  public:
    // Constructor
    Rectangle(float l, float w) 
	{
        length = l;
        width  = w;
    }
    float calculateArea() 
	{
        return length * width;
    }
};
int main() 
{
    Rectangle rect(7.0, 4.0);
    cout << "[OOP] Area = "<< rect.calculateArea()<<endl;
}
