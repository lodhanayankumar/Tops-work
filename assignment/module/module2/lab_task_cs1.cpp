//write a C program that takes the marks of a student as input and displays the corresponding
//grade based on the following conditions:
//o Marks > 90: Grade A
//o Marks > 75 and <= 90: Grade B
//o Marks > 50 and <= 75: Grade C
//o Marks <= 50: Grade D
//? Use if-else orswitch statements for the decision-making process.
#include<stdio.h>
int main()
{
	int m,n;
	printf("Enter marks :  ");
	scanf("%d",&m);
	if(m>90)
	{
		printf("Excellent : %d  marks : A grade",m);
	}
	else if(m>75 && m<=90)
	{
		printf("very good : %d marks : B grade",m);
	}
	else if(m>50 && m<=75)
	{
		printf("good : %d marks : C grade",m);
	}
	else
	{
		printf("improve youre mark : %d marks : D grade",m);
	}
	n=m/10;
	switch(n)
	{
		case 10 :{
			printf("\nExcellent : %d  marks : A grade",m);
			break;
		}
		case 9 :{
			printf("\nExcellent : %d  marks : A grade",m);
			break;
		}
		case 8 :{
			printf("\nvery good : %d  marks : B grade",m);
			break;
		}
		case 7 :{
			printf("\nvery good : %d  marks : B grade",m);
			break;
		}
		case 6 :{
			printf("\ngood : %d  marks : C grade",m);
			break;
		}
		case 5 :{
			printf("\ngood : %d  marks : C grade",m);
			break;	
		}
		default :
			{
				printf("\nimprove youre mark : %d marks : D grade",m);
				 break;
			}
	}
}
