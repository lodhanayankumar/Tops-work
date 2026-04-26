//2. Basic Input/Output 
//o Write a C++ program that accepts user input for their name and age and then 
//displays a personalized greeting. 
//o Objective: Practice input/output operations using cin and cout
#include<iostream>
using namespace std;

int main()
{
	string a;
	int b;
	cout<<"Enter your name :"<<endl;
	cin>>a;
	cout<<"Enter your age :"<<endl;
	cin>>b;
	cout<<"------------------------"<<endl;
	cout<<"your name is "<<a<<endl;
	cout<<"your age is "<<b;
}
