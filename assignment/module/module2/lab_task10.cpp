/*Write a C program to demonstrate pointer usage. Use a pointer to modify the 
value of a variable and print the result.*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int var = 10;
int *ptr_var;

int main()
{
    ptr_var = &var;

    printf("Value of var              : %d\n", var);
    printf("Address of var            : %p\n", var);          // var holds address of var
    printf("Value stored in ptr_var   : %p\n", ptr_var);      // address stored in pointer
    printf("Value pointed by ptr_var  : %d\n", *ptr_var);     // value at that address

    *ptr_var = 50;

    printf("New value of var          : %d\n", var);

    return 0;
}

