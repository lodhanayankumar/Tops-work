//2. Matrix Addition 
//o Write a C++ program to perform matrix addition on two 2x2 matrices. 
//o Objective: Practice multi-dimensional arrays.
#include <iostream>
using namespace std;

int main() {
    // 1. Declare 2x2 multidimensional arrays
    int mat1[2][2], mat2[2][2], sum[2][2];

    // 2. Input elements for the first matrix
    cout << "Enter 4 elements for Matrix 1 :" << endl;
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            cin >> mat1[i][j];
        }
    }

    // 3. Input elements for the second matrix
    cout << "Enter 4 elements for Matrix 2 :" << endl;
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            cin >> mat2[i][j];
        }
    }

    // 4. Perform matrix addition
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            sum[i][j] = mat1[i][j] + mat2[i][j];
        }
    }

    // 5. Display the resulting sum matrix
    cout << "\nSum of the matrices:" << endl;
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            cout << sum[i][j] << " ";
        }
        cout << endl;
    }
}
 
