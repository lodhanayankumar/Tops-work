//Write a C program that takes a string as input and reverses it using a function. 
//? Challenge: Write the program without using built-in string handling functions

#include<stdio.h>

// Find length without strlen
int string_length(char str[])
{
    int len = 0;
    while(str[len] != '\0')
    {
        len++;
    }
    return len;
}

// Reverse string without strrev
void reverse_string(char str[])
{
    int i, len;
    char temp;
    len = string_length(str);

    for(i = 0; i < len/2; i++)
    {
        temp          = str[i];
        str[i]        = str[len-1-i];
        str[len-1-i]  = temp;
    }
}

// Print string without printf %s
void print_string(char str[])
{
    int i;
    for(i = 0; str[i] != '\0'; i++)
    {
        printf("%c", str[i]);
    }
    printf("\n");
}

// Copy string without strcpy
void copy_string(char dest[], char src[])
{
    int i = 0;
    while(src[i] != '\0')
    {
        dest[i] = src[i];
        i++;
    }
    dest[i] = '\0';
}

int main()
{
    char original[100];
    char reversed[100];

    printf("Enter a string: ");
    scanf("%s", original);

    // Copy original to reversed
    copy_string(reversed, original);

    // Reverse the copied string
    reverse_string(reversed);

    printf("\nOriginal String : ");
    print_string(original);
    printf("Reversed String : ");
    print_string(reversed);
}
