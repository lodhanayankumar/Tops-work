//Write a C program that takes a string from the user and counts the number of vowels and 
//consonants in the string. 
//? Challenge: Extend the program to also count digits and special characters. 

#include<stdio.h>

// Check vowel
int is_vowel(char ch)
{
    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
       ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
        return 1;
    return 0;
}

// Check alphabet
int is_alpha(char ch)
{
    if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
        return 1;
    return 0;
}

// Check digit
int is_digit(char ch)
{
    if(ch>='0' && ch<='9')
        return 1;
    return 0;
}

void count_all(char str[])
{
    int i;
    int vowels=0, consonants=0, digits=0, spaces=0, special=0;

    for(i=0; str[i]!='\0'; i++)
    {
        if(is_vowel(str[i]))
            vowels++;
        else if(is_alpha(str[i]))
            consonants++;
        else if(is_digit(str[i]))
            digits++;
        else if(str[i]==' ')
            spaces++;
        else
            special++;
    }

    printf("\n--- Result ---\n");
    printf("Vowels          : %d\n", vowels);
    printf("Consonants      : %d\n", consonants);
    printf("Digits          : %d\n", digits);
    printf("Spaces          : %d\n", spaces);
    printf("Special Chars   : %d\n", special);
}

int main()
{
    char str[200];

    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    count_all(str);

    return 0;
}
