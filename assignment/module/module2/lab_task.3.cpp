//Write a C program that includes variables, constants, and comments. Declare
//and use different data types (int, char, float) and display their values.
#include<stdio.h>
int main()
{ 
   int a;//intiger data type
    char b;//character data type
    float c;//float data type
   printf("enter intiger : ");
   scanf("%d",&a);
  
   printf("enter character : ");
   scanf(" %c", &b);
  
   printf("enter float : ");
   scanf("%f",&c);
   printf("\n intiger : %d\ncharacter : %c\nfloat : %f",a,b,c);
}
