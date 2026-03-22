//Write a C program that takes an integer from the user and calculates the sum of its digits
//using a while loop.
//? Challenge: Extend the program to reverse the digits of the number.
#include<stdio.h>
int main()
{
	int n,i,temp,c=0,sum=0,r;
	printf("enter a number : ");
	scanf("%d",&n);
	temp=n;
	while(temp != 0)
	{	
	i= temp%10;
	sum= sum+i;
	r = r * 10 + i;
	temp = temp/10;
	c++;
	}
	printf("digit = %d",c);
	printf("\nsum = %d",sum);
	printf("\nreverse = %d",r);
}
