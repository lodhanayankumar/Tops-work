//Write a C program that takes a number as input and checks whether it is a palindrome using 
//a function. 
//? Challenge: Modify the program to check if a given string is a palindrome.

#include<stdio.h>
#include<string.h>

// Number Palindrome
int number_palindrome(int n)
{
    int reverse = 0, temp, digit;
    temp = n;
    while(temp != 0)
    {
        digit = temp % 10;
        reverse = reverse * 10 + digit;
        temp = temp / 10;
    }
    if(reverse == n)
        return 1;
    else
        return 0;
}

// String Palindrome
int string_palindrome(char str[])
{
    int i, len;
    len = strlen(str);
    for(i = 0; i < len/2; i++)
    {
        if(str[i] != str[len-1-i])
            return 0;
    }
    return 1;
}

int main()
{
    int num, choice;
    char word[100];

    printf("--- Palindrome Checker ---\n");
    printf("1. Number Palindrome\n");
    printf("2. String Palindrome\n");
    printf("Enter choice: ");
    scanf("%d", &choice);

    if(choice == 1)
    {
        printf("Enter a number: ");
        scanf("%d", &num);

        if(number_palindrome(num))
            printf("%d is a Palindrome\n", num);
        else
            printf("%d is NOT a Palindrome\n", num);
    }
    else if(choice == 2)
    {
        printf("Enter a string: ");
        scanf("%s", word);

        if(string_palindrome(word))
            printf("%s is a Palindrome\n", word);
        else
            printf("%s is NOT a Palindrome\n", word);
    }
    else
    {
        printf("Invalid choice!\n");
    }

    return 0;
}
