//Write a C program that takes three numbers from the user and determines:
//o The largest number.
//o The smallest number.
//? Challenge: Solve the problem using both if-else and switch-case statements.
#include<stdio.h>
int main()
{
	int m,n,p,no,mo;
	printf("enter a no1 : ");
	scanf("%d",&m);
	printf("enter a no2 : ");
	scanf("%d",&n);
	printf("enter a no3 : ");
	scanf("%d",&p);
	if(m>=n && m>=p)
	{
		printf("%d is largest number",m);
		no = 1;
	}
	else if(n>=m && n>=p)
	{
		printf("%d is largest number",n);
		no = 2;
	}
	else 
	{
		printf("%d is largest number",p);
		no = 3;
	}
    if(m<=n && m<=p)
		{
		printf("\n%d is lowest number",m);
		mo = 4;
	}
	else if(n<=m && n<=p)
	{
		printf("\n%d is lowest number",n);
		mo =5;
	}
	else 
	{
		printf("\n%d is lowest number",p);
		mo = 6;
	}
	printf("\n--------------------------switch---");
	switch(no)
	{
		case 1:{
			printf("\n%d is largest number",m);
			break;
		}
		case 2:{
			printf("\n%d is largest number",n);
			break;
		}
		case 3:	{
			printf("\n%d is largest number",p);
			break;
		}
	} 
	switch(mo)
	{
	
		case 4:{
			printf("\n%d is lowest number",m);
			break;
		}
		case 5:{
			printf("\n%d is lowest number",n);
			break;
		}
		case 6:	{
			printf("\n%d is lowest number",p);
			break;
		}
	}

}
