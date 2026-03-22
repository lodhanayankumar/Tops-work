//C Programming Assessment Test
//• Write a program to demonstrate a Food Billing System.
#include<stdio.h>
int main()
{

	int i,choice,a,amount,total=0;
	char y,n,yn;
	yn= 'y';
	while(yn=='y')
{
	
	printf("------menu-------");
	printf("\n1.Pizza      price = 180rs/pcs\n2.Burger    price = 100rs/pcs\n3.Dosa    price = 150rs/pcs\n4.Idli    price = 50rs/pcs");
	printf("\nPlease Enter your choose... : ");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:{
			printf("\nYou Have Selected Pizza.");
			a=180;
			break;
		}
		case 2:{
			printf("\nYou Have Selected Burger.");
			a=100;
			break;
		}
		case 3:{
			printf("\nYou Have Selected Dosa.");
			a=150;
			break;
		}
		case 4:{
			printf("\nYou Have Selected Idli.");
			a=50;
			break;
		}
		default: {
	      printf("Invalid choice!\n"); a = 0; break;
	      }
	}
	printf("Enter the quantity : ");
	scanf("%d",&i);
	amount = a*i;
	total = total+amount;
	printf("Amount : %d",amount);
	printf("\nTotal amount is = %d",total);
	printf("\nDo you went to more orders ? y & n:");
	scanf(" %c",&yn);
	}
	
}
	

