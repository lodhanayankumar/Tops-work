//Write a C program that accepts two 2x2 matrices from the user and adds them. Display the
//resultant matrix.
//? Challenge: Extend the program to work with 3x3 matrices and matrix multiplication.
#include <stdio.h>

int main() {

    int a[3][3], b[3][3],add[3][3], mul[3][3];
    int i, j, k;
    printf("Enter Matrix a (3x3):\n");
    for (i = 0; i < 3; i++)
        for (j = 0; j < 3; j++)
            scanf("%d", &a[i][j]);
    printf("Enter Matrix b (3x3):\n");
    for (i = 0; i < 3; i++)
	{
        for (j = 0; j < 3; j++)
		{
            scanf("%d", &b[i][j]);
        }
    }
    for (i = 0; i < 3; i++)
    {
		    for (j = 0; j < 3; j++)
        {
		    add[i][j] = a[i][j] + b[i][j];
        }
	}
    for (i = 0; i < 3; i++)
     {
		   for (j = 0; j < 3; j++) {
            mul[i][j] = 0;
            for (k = 0; k < 3; k++)
                mul[i][j] += a[i][k] * b[k][j];
        }
    }
    printf("\nMatrix a:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++)
          {
	       printf("  %d  ", a[i][j]);
	       }
        printf("\n");
    
    }
    printf("\nMatrix b:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++){
		
            printf("  %d  ", b[i][j]);
        }
		printf("\n");
    }
    printf("\na + b:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++){
            printf("  %d  ", add[i][j]);
        }
        printf("\n");
    }
    printf("\na x b:\n");
    for (i = 0; i < 3; i++) {
        for (j = 0; j < 3; j++)
         {
			   printf("  %d  ", mul[i][j]);
        }
		printf("\n");
    }
}
