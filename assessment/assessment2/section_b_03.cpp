//3. Functions & Pointers
//Write a program to:
//? Swap two numbers using a user-defined function
//? Implement swapping using pointers
//? Explain why pass-by-reference is necessary here

#include<iostream>
using namespace std;

void swapNumbers(int *a, int *b){
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

void swapWithoutPointers(int a, int b){
    int temp;
    temp = a;
    a = b;
    b = temp;
    cout<<"Inside function (no pointers): a="<<a<<" b="<<b<<endl;
}

int main(){
    int x, y;
    
    cout<<"====================================="<<endl;
    cout<<"    SWAP NUMBERS USING POINTERS      "<<endl;
    cout<<"====================================="<<endl;
    
    cout<<"Enter first number  : ";
    cin>>x;
    cout<<"Enter second number : ";
    cin>>y;
    
    cout<<"-------------------------------------"<<endl;
    cout<<"Before swap: x="<<x<<" y="<<y<<endl;
    
    cout<<"\n--- Without Pointers (pass by value) ---"<<endl;
    swapWithoutPointers(x, y);
    cout<<"After function call : x="<<x<<" y="<<y<<endl;
    cout<<"(No change! Values not swapped)"<<endl;
    
    cout<<"\n--- With Pointers (pass by reference) ---"<<endl;
    swapNumbers(&x, &y);
    cout<<"After swap: x="<<x<<" y="<<y<<endl;
    cout<<"(Values actually swapped!)"<<endl;
    
    cout<<"====================================="<<endl;
    cout<<"WHY POINTERS ARE NEEDED:"<<endl;
    cout<<"Pass by value copies the variable."<<endl;
    cout<<"Original values do NOT change."<<endl;
    cout<<"Pointers pass the memory ADDRESS."<<endl;
    cout<<"So the original variables change."<<endl;
}
