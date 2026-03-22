//Write a C program that accepts two integers from the user and performs
//arithmetic, relational, and logical operations on them. Display the results.
#include<stdio.h>
int main()
{
	int a,b;
	printf("Enter no1 : ");
	scanf("%d",&a);
	printf("Enter no2 : ");
	scanf("%d",&b);
	
	printf("---arithmetic--");
	printf("\naddition       : %d + %d = %d",a,b,a+b);
	printf("\nsubtraction    : %d - %d = %d",a,b,a-b);
	printf("\nmultiplication : %d * %d = %d",a,b,a*b);
	printf("\nmodulus        : %d %% %d =%d",a,b,a%b);
	if(b==0)
	{
		printf("invalid input b");
	}
	else
	{
		printf("\ndivision  : %d / %d =%d",a,b,a/b);
	}
	
	printf("\n----relation operation---");
	printf("\n %d > %d : %d",a,b,a>b);
	printf("\n %d < %d : %d",a,b,a<b);
	printf("\n %d >= %d : %d",a,b,a>=b);
	printf("\n %d <= %d : %d",a,b,a<=b);
	printf("\n %d == %d : %d",a,b,a==b);
	printf("\n %d != %d : %d",a,b,a!=b);
	
	printf("\n-----logical operation---");
	printf("\n and operation: %d > 1 && %d > 1 = %d",a,b,a>1&&b>1);
	printf("\n or operation: %d > 1 || %d > 1 = %d",a,b,a>1||b>1);
	printf("\n not operation: !(%d > 1 && %d > 1) = %d",a,b,!(a>1&&b>1));
	
}
