//Write a C program that takes an integer input from the user and prints its multiplication
//table using a for loop.
//? Challenge: Allow the user to input the range of the multiplication table (e.g., from 1 to N).
#include<stdio.h>
int main()
{
	int n,i,j;
	printf("Enter a number : ");
	scanf("%d",&n);
	printf("range of multiplication : ");
	scanf("%d",&i);
	for(j=1;j<=i;j++)
	{
		printf("\n %d * %d = %d",n,j,n*j);
	}
}
