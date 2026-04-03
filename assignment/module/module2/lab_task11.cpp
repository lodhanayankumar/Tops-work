//Write a C program that takes two strings from the user and concatenates 
//them using strcat(). Display the concatenated string and its length using 
//strlen(). 

//Write a C program that takes two strings from the user and concatenates
//them using strcat(). Display the concatenated string and its length using
//strlen().
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char string1[50];
char string2[50];

int main()
{
    printf("Enter first string  : ");
    scanf("%s", string1);
    printf("Enter second string : ");
    scanf("%s", string2);
    strcat(string1, string2);
    printf("Concatenated string : %s\n", string1);
    printf("Length of string    : %d\n", strlen(string1));
}
