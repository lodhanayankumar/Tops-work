//Write a C program that takes N numbers from the user and stores them in an array. The
//program should then calculate and display the sum of all array elements.
//? Challenge: Modify the program to also find the average of the numbers.
#include<stdio.h>
int main()
{
	int i,j,r,c,sum=0;
	printf("Enter row : ");
	scanf("%d",&r);
	printf("Enter colum : ");
	scanf("%d",&c);
	int matrix[r][c];
	for(i=0;i<r;i++)
	{
		for(j=0;j<c;j++)
		{
			 printf("matrix[%d][%d]\t",i,j);
			scanf("%d",&matrix[i][j]);
			sum+=matrix[i][j];
		}
		printf("\n");
	}
	for(i = 0; i < r; i++) {
        for(j = 0; j < c; j++) {
            printf("%d\t",matrix[i][j]);
        }
        printf("\n");
      
    }
      printf("\navreg : %d",sum/(r*c));
      
}
