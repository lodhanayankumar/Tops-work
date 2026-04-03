//Write a C program that counts the number of words in a sentence entered by the user. 
//? Challenge: Modify the program to find the longest word in the sentence. 

#include<stdio.h>

// Find length without strlen
int string_length(char str[], int start, int end)
{
    return end - start;
}

// Copy word without strcpy
void copy_word(char dest[], char src[], int start, int end)
{
    int i, j=0;
    for(i=start; i<end; i++)
    {
        dest[j] = src[i];
        j++;
    }
    dest[j] = '\0';
}

// Print string without puts
void print_string(char str[])
{
    int i;
    for(i=0; str[i]!='\0'; i++)
        printf("%c", str[i]);
    printf("\n");
}

void count_and_longest(char str[])
{
    int i;
    int word_count  = 0;
    int word_start  = -1;
    int max_len     = 0;
    int curr_len    = 0;
    int long_start  = 0;
    int long_end    = 0;
    char longest[100];

    for(i=0; str[i]!='\0'; i++)
    {
        // Word starts
        if(str[i] != ' ' && str[i] != '\n')
        {
            if(word_start == -1)
            {
                word_start = i;
            }
        }
        // Word ends
        else
        {
            if(word_start != -1)
            {
                word_count++;
                curr_len = string_length(str, word_start, i);
                if(curr_len > max_len)
                {
                    max_len    = curr_len;
                    long_start = word_start;
                    long_end   = i;
                }
                word_start = -1;
            }
        }
    }

    // Last word (no space at end)
    if(word_start != -1)
    {
        word_count++;
        curr_len = string_length(str, word_start, i);
        if(curr_len > max_len)
        {
            max_len    = curr_len;
            long_start = word_start;
            long_end   = i;
        }
    }

    // Copy longest word
    copy_word(longest, str, long_start, long_end);

    printf("\n--- Result ---\n");
    printf("Total Words   : %d\n", word_count);
    printf("Longest Word  : ");
    print_string(longest);
    printf("Word Length   : %d\n", max_len);
}

int main()
{
    char str[200];

    printf("Enter a sentence: ");
    fgets(str, sizeof(str), stdin);

    count_and_longest(str);

}
