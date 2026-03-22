//Write a C program to check if a number is even or odd using an if-else
//statement. Extend the program using a switch statement to display the month
//name based on the user’s input (1 for January, 2 for February, etc.).
#include<stdio.h>
int main()
{
	int a,choice;
	printf("Enter a Number : ");
	scanf("%d",&a);
	if(a%2==0)
	printf("number %d is even",a);
	else
	printf("number %d is odd",a);
	
	printf("\n\nenter choice between 1-12 : ");
	scanf("%d",&choice);
	switch(choice)
		{
		case 1 :{
				printf("january");
			break;
		}
		
		case 2 :{
				printf("february");
			break;
		}
		case 3 :{
				printf("march");
			break;
		}
		case 4 :{
				printf("april");
			break;
		}
		case 5 :{
				printf("may");
			break;
		}
		case 6 :{
				printf("june");
			break;
		}
		case 7 :{
				printf("july");
			break;
		}
		case 8 :{
				printf("august");
			break;
		}
		case 9 :{
				printf("september");
			break;
		}
		case 10 :{
				printf("october");
			break;
		}
		case 11 :{
				printf("november");
			break;
		}
		case 12 :{
				printf("december");
			break;
		default :{
			printf("invalid input");
			break;
		}
		}	
		}
		
		
			
}
