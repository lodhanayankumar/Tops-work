//Write a C program that checks whether a given number is a prime number or not using a for
//loop.
//? Challenge: Modify the program to print all prime numbers between 1 and a given number
#include<stdio.h>
int main()
{
	int a,n,i,j,flag;
	printf("enter a number : ");
	scanf("%d",&a);
	n=a-1;
	if(a==2)
	{ 
	printf("enterd number is prime");
	}
    else if(a%2==0)
	{
		printf("enterd number is not prime");
	}
	else if(a%n==0)
	{
		printf("enterd number is not prime");
	}
	else
	{
		printf("entered number is prime");
	}
	for (j = 2; j <= a; j++) {   

        flag = 0;                

        for (i = 2; i < j; i++) {
            if (j % i == 0) {
                flag = 1;        
                break;
            }
        }

        if (flag == 0) {
            printf("\n%d ", j);    
        }
    }
    printf("\n");
}
