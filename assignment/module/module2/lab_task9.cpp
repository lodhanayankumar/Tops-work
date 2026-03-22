//Write a C program that stores 5 integers in a one-dimensional array and prints
//them. Extend this to handle a two-dimensional array (3x3 matrix) and
//calculate the sum of all elements
#include<stdio.h>
int main()
{
	int arry[5],i;
    for(i=0;i<5;i++)
    {
    	printf("arry[%d] =  ",i);
    	scanf("%d",&arry[i]);
	}
	for(i=0;i<5;i++)
    {
    	printf("%d  ",arry[i]);
    	
	}
	int ar[3][3],k,j,sum;
	for(k=0;k<3;k++)
	{
		for(j=0;j<3;j++)
		{
			printf("\nar[%d][%d] : ",k,j);
			scanf("%d",&ar[k][j]);
			sum+=ar[k][j];
		}
		printf("\n");
	}
	printf("%d",sum);
}
