//Write a C program to print numbers from 1 to 10 using all three types of loops
//(while, for, do-while).
#include<stdio.h>
int main()
{
	int i=1,j=1,k=1;
	for(i=1;i<=10;i++)
    {
    	printf("\n%d",i);
		}	
		printf("\n---------------------");
    while(j<=10)
	{
		printf("\n%d",j);
		j++;
    }
    printf("\n----------------------------");
	do
	{
		printf("\n%d",k);
		k++;
			}
	while(k<=10);				
}
