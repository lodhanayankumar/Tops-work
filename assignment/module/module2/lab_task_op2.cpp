//Write a C program that takes an integer from the user and checks the following using
//different operators:
//o Whether the number is even or odd.
//o Whether the number is positive, negative, orzero.
//o Whether the number is a multiple of both 3 and 5.
#include<stdio.h>
int main()
{
	int a,b;
	printf("enter a number : ");
	scanf("%d",&a);
	printf("\n---------------even odd--------");
	if(a%2==0)
	{
		printf("Enter number %d is even",a);
	}
	else
	{
		printf("enter number %d is odd",a);
	}
	printf("\n-------positive,negative,zero--");
	if(a>0)
	{
		printf("Enter number %d is positive",a);
	}
	else if(a<0)
	{
		printf("enter number %d is negetive",a);
	}
	else
	{
		printf("\nenter number %d is zero",a);
	}
	printf("\n--------------3-5 multipalyer----");
	if(a%3==0 && a%5==0)
	{
		printf("\nenter number %d is divide by 5 and 3",a);
	}
	else if(a%3==0)
	{
		printf("\nenter number %d is divide by 3");
	}
	else if(a%5==0)
	{
		printf("\nenter number %d is divide by 5");
	}
	else
	{
		printf("\nenter number %d is not divide by 5 and 3");
	}
}
