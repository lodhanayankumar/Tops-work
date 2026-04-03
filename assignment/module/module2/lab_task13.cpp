//Write a C program to create a file, write a string into it, close the file, then 
//open the file again to read and display its contents.
#include<stdio.h>
#include<stdlib.h>

int main()
{
    char userstring[100];
    FILE* file;

    // ---- WRITE ----
    file = fopen("file.txt", "w");
    if(file == NULL)
    {
        printf("Error opening file for writing!\n");
        exit(1);
    }

    printf("Enter a string to write in file : ");
    fgets(userstring, sizeof(userstring), stdin);

    fprintf(file, "%s", userstring);
    printf("String written to file successfully.\n");
    fclose(file);

    // ---- READ ----
    file = fopen("file.txt", "r");
    if(file == NULL)
    {
        printf("Error opening file for reading!\n");
        exit(1);
    }

    printf("\nReading from file:\n");
    printf("------------------\n");
    while(fgets(userstring, sizeof(userstring), file) != NULL)
    {
        printf("%s", userstring);
    }
    printf("------------------\n");
    fclose(file);

    return 0;
}
