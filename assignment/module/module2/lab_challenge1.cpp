//Write a C program that checks whether a given number is an Armstrong number or not (e.g., 
//153 = 1^3 + 5^3 + 3^3). 
//? Challenge: Write a program to find all Armstrong numbers between 1 and 1000. 

#include<stdio.h>
int count_digits(int n)
{
    int count = 0;
    while(n != 0)
    {
        count++;
        n = n / 10;
    }
    return count;
}

// Power function without pow()
int power(int base, int exp)
{
    int result = 1;
    int i;
    for(i = 0; i < exp; i++)
        result *= base;
    return result;
}

// Check Armstrong
int is_armstrong(int n)
{
    int digits, digit, sum = 0, temp;
    temp   = n;
    digits = count_digits(n);

    while(temp != 0)
    {
        digit = temp % 10;
        sum   = sum + power(digit, digits);
        temp  = temp / 10;
    }

    if(sum == n)
        return 1;
    return 0;
}

// Find all Armstrong numbers 1 to 1000
void find_all_armstrong()
{
    int i;
    printf("\nArmstrong Numbers from 1 to 1000:\n");
    printf("----------------------------------\n");
    for(i = 1; i <= 1000; i++)
    {
        if(is_armstrong(i))
            printf("%d\n", i);
    }
}

int main()
{
    int num, choice;

    printf("--- Armstrong Number Program ---\n");
    printf("1. Check Single Number\n");
    printf("2. Find All Armstrong (1 to 1000)\n");
    printf("3. Both\n");
    printf("Enter choice: ");
    scanf("%d", &choice);

    if(choice == 1)
    {
        printf("Enter a number: ");
        scanf("%d", &num);
        if(is_armstrong(num))
            printf("%d is an Armstrong Number!\n", num);
        else
            printf("%d is NOT an Armstrong Number!\n", num);
    }
    else if(choice == 2)
    {
        find_all_armstrong();
    }
    else if(choice == 3)
    {
        printf("Enter a number: ");
        scanf("%d", &num);
        if(is_armstrong(num))
            printf("%d is an Armstrong Number!\n", num);
        else
            printf("%d is NOT an Armstrong Number!\n", num);

        find_all_armstrong();
    }
    else
    {
        printf("Invalid choice!\n");
    }
}
