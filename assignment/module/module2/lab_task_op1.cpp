//Write a C program that acts as a simple calculator. The program should take two numbers
//and an operator as input from the user and perform the respective operation (addition,
//subtraction, multiplication, division, or modulus) using operators.
//? Challenge: Extend the program to handle invalid operator inputs.

#include<stdio.h>
int main()
{
	int no1,no2;
	char choice;
	printf("\n+ Addition\n- Subtraction \n* Multiplication \n/ Division \n%% Modulo \n0 exit");
	printf("\nEnter your choice : ");
	scanf("%c",&choice);
	printf("Enter no1 : ");
	scanf("%d",&no1);
	printf("Enter no2 : ");
	scanf("%d",&no2);
	switch(choice)
	{
		case '+':{
			printf("addition : %d + %d = %d ",no1,no2,no1 + no2);
			break;
		}
		case '-' :{
			printf("subtraction : %d - %d = %d ",no1,no2,no1-no2);
			break;
		}
		case '*' :{
			printf("multiplication : %d * %d = %d ",no1,no2,no1*no2);
			break;
		}
		case '/' :{
			if(no2==0)
			{
				printf("invalid input");
			}
			else
			{
				printf("divison : %d / %d = %d ",no1,no2,no1/no2);
			}
			break;
		}
		case '%' : {
			printf("modulo : %d %% %d = %d ",no1,no2,no1 % no2 );
			break;
		}	
		case 0 : {
			printf("exit......");
			break;
		}
		default :{
			printf("invalid input ");
			break;
		}
	}
}
