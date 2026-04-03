//Write a C program that calculates the factorial of a given number using a function. 
//? Challenge: Implement both an iterative and a recursive version of the factorial function and 
//compare their performance for large numbers. 

#include<stdio.h>

int iter_steps = 0;
int recur_calls = 0;

// Iterative Factorial
long long factorial_iterative(int n)
{
    long long result = 1;
    int i;
    iter_steps = 0;
    for(i = 1; i <= n; i++)
    {
        result *= i;
        iter_steps++;
    }
    return result;
}

// Recursive Factorial
long long factorial_recursive(int n)
{
    recur_calls++;
    if(n == 0 || n == 1)
        return 1;
    return n * factorial_recursive(n - 1);
}

int main()
{
    int n;
    long long iter_result, recur_result;

    printf("Enter a number: ");
    scanf("%d", &n);

    // Iterative
    iter_result = factorial_iterative(n);
    printf("\nIterative Factorial(%d) = %lld", n, iter_result);
    printf("\nIterative Steps       = %d", iter_steps);

    // Recursive
    recur_calls = 0;
    recur_result = factorial_recursive(n);
    printf("\n\nRecursive Factorial(%d) = %lld", n, recur_result);
    printf("\nRecursive Calls        = %d", recur_calls);

    // Simple Comparison
    printf("\n\n--- Comparison ---");
    printf("\nIterative used %d steps", iter_steps);
    printf("\nRecursive used %d function calls", recur_calls);

    if(iter_steps <= recur_calls)
        printf("\nIterative is more efficient!\n");
    else
        printf("\nRecursive is more efficient!\n");

}
