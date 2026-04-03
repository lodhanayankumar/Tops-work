//Write a C program that generates the Fibonacci sequence up to N terms using a recursive 
//function. 
//? Challenge: Modify the program to calculate the Nth Fibonacci number using both iterative 
//and recursive methods. Compare their efficiency.
#include<stdio.h>
// Iterative Fibonacci 
void fibo_iterative(int no)
{
    int i, a=0, b=1, temp=0;
    printf("\nIterative Fibonacci Sequence:\n");
    for(i=0; i<no; i++)
    {
        printf("%d\t", a);
        temp = a + b;
        a = b;
        b = temp;
    }
    printf("\n");
}
// Recursive 
int fibo_recursive(int n)
{
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fibo_recursive(n-1) + fibo_recursive(n-2);
}
// Prints Fibonacci sequence using recursion
void recur_sequence(int no)
{
    int i;
    printf("\nRecursive Fibonacci Sequence:\n");
    for(i=0; i<no; i++)
    {
        printf("%d\t", fibo_recursive(i));
    }
    printf("\n");
}
// ---- Efficiency Comparison ----
int fibo_iterative_nth(int n, int *steps)
{
    int a=0, b=1, temp, i;
    *steps = 0;
    if(n == 0) return 0;
    for(i=1; i<n; i++)
    {
        (*steps)++;
        temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
// Recursive: returns Nth Fibonacci number + counts calls
int fibo_recursive_nth(int n, int *calls)
{
    (*calls)++;
    if(n == 0) return 0;
    if(n == 1) return 1;
    return fibo_recursive_nth(n-1, calls) + fibo_recursive_nth(n-2, calls);
}
int main()
{
    int n;
    int iter_steps = 0, recur_calls = 0;
    int iter_result, recur_result;

    printf("Enter number of terms (N): ");
    scanf("%d", &n);

    // Print sequences
    fibo_iterative(n);
    recur_sequence(n);

    // Efficiency comparison for Nth term
    iter_result  = fibo_iterative_nth(n, &iter_steps);
    recur_result = fibo_recursive_nth(n, &recur_calls);

    printf("\n--- Efficiency Comparison (for Nth = %d) ---\n", n);
    printf("%-25s %-15s %-15s\n", "Method", "Result", "Operations");
    printf("%-25s %-15d %-15d\n", "Iterative",  iter_result,  iter_steps);
    printf("%-25s %-15d %-15d\n", "Recursive",  recur_result, recur_calls);

    printf("\nConclusion:\n");
    printf("  Iterative used  : %d operations\n", iter_steps);
    printf("  Recursive used  : %d function calls\n", recur_calls);

    if(recur_calls > iter_steps)
        printf("  >> Iterative is MORE efficient (fewer operations).\n");
    else
        printf("  >> Recursive is MORE efficient (fewer operations).\n");

    return 0;
} 
