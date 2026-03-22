//Write a C program that calculates the factorial of a number using a function.
//Include function declaration, definition, and call.
 #include<stdio.h>
 int factorial(int a)
 {
 	int i,ans;
 	int fact=1;
 	for(i=1;i<=a;i++)
 	{
 		ans = fact * i;
 		fact = ans;
	 }return fact;
 }
 int main()
 {
 	int n;
 	printf("Enter numer : ");
 	scanf("%d",&n);
 	printf("factorial of %d = %d",n,factorial(n));
 }
