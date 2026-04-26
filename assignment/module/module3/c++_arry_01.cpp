//1. Array Sum and Average 
//o Write a C++ program that accepts an array of integers, calculates the sum and 
//average, and displays the results. 
//o Objective: Understand basic array manipulation. 

#include <iostream>
using namespace std;

int main() {
    int n, sum = 0;

    cout << "Enter number of elements: ";
    cin >> n;

    int arr[n];

    cout << "Enter " << n << " elements:" << endl;
    for (int i = 0; i < n; i++) 
	{
        cin >> arr[i];
        sum += arr[i];
    }
    float average = (float)sum / n;
    cout << "Sum = " << sum << endl;
    cout << "Average = " << average << endl;
}
