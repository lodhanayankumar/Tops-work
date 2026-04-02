//C Programming Assessment Test
//• Write a program to demonstrate a Food Billing System.
#include<stdio.h>
int main()
{
	int quantity,choice,temp=0,amount,total=0;
	char y,loop_contin;
	loop_contin = 'y';    //if choice is y so loop exicute again.
	while(loop_contin=='y')
{
	
	printf("------menu-------");
	printf("\n1.Pizza      price = 180rs/pcs\n2.Burger    price = 100rs/pcs\n3.Dosa    price = 150rs/pcs\n4.Idli    price = 50rs/pcs");
	printf("\nPlease Enter your choose... : ");
	scanf("%d",&choice);       //iteam choice
	switch(choice)
	{
		case 1:{
			printf("\nYou Have Selected Pizza.");
			temp=180;    //temp valy is pizza price
			break;
		}
		case 2:{
			printf("\nYou Have Selected Burger.");
			temp=100;    //temp valy is burger price
			break;
		}
		case 3:{
			printf("\nYou Have Selected Dosa.");
			temp=150;     //temp valy is dosa price
			break;
		}
		case 4:{
			printf("\nYou Have Selected Idli.");
			temp=50;       //temp valy is idli price   
			break;
		}
		default: {
	      printf("Invalid choice!\n"); temp = 0; break;
	      }
	}
	printf("Enter the quantity : ");
	scanf("%d",&quantity);
	amount = temp*quantity;
	total = total+amount;      //total bill after all iteam adds.
	printf("Amount : %d",amount);
	printf("\nTotal amount is = %d",total);
	printf("\nDo you went to more orders ? y & n:");
	scanf(" %c",&loop_contin);
	}
	
}
	

