//Write a C program that generates Pascal’s Triangle up to N rows using loops. 
//? Challenge: Implement the same program using a recursive function. 

#include<stdio.h>

// Factorial for combination
int factorial(int n)
{
    int result = 1, i;
    for(i = 1; i <= n; i++)
        result *= i;
    return result;
}

// Combination C(n,r) = n! / (r! * (n-r)!)
int combination(int n, int r)
{
    return factorial(n) / (factorial(r) * factorial(n - r));
}

// Recursive combination without factorial
int recur_combination(int n, int r)
{
    if(r == 0 || r == n)
        return 1;
    return recur_combination(n-1, r-1) + recur_combination(n-1, r);
}

// Print spaces for triangle shape
void print_spaces(int n, int row)
{
    int i;
    for(i = 0; i < n - row; i++)
        printf("   ");
}

// Iterative Pascal Triangle
void pascal_iterative(int n)
{
    int i, j;
    printf("\nIterative Pascal Triangle:\n\n");
    for(i = 0; i < n; i++)
    {
        print_spaces(n, i);
        for(j = 0; j <= i; j++)
        {
            printf("%4d ", combination(i, j));
        }
        printf("\n\n");
    }
}

// Recursive Pascal Triangle
void pascal_recursive(int n)
{
    int i, j;
    printf("\nRecursive Pascal Triangle:\n\n");
    for(i = 0; i < n; i++)
    {
        print_spaces(n, i);
        for(j = 0; j <= i; j++)
        {
            printf("%4d ", recur_combination(i, j));
        }
        printf("\n\n");
    }
}

int main()
{
    int n, choice;

    printf("--- Pascal Triangle ---\n");
    printf("1. Iterative\n");
    printf("2. Recursive\n");
    printf("3. Both\n");
    printf("Enter choice: ");
    scanf("%d", &choice);

    printf("Enter number of rows: ");
    scanf("%d", &n);

    if(choice == 1)
        pascal_iterative(n);
    else if(choice == 2)
        pascal_recursive(n);
    else if(choice == 3)
    {
        pascal_iterative(n);
        pascal_recursive(n);
    }
    else
        printf("Invalid choice!\n");
}
