//Write a C program that implements a simple number guessing game. The program should 
//generate a random number between 1 and 100, and the user should guess the number 
//within a limited number of attempts.
//Challenge: Provide hints to the user if the guessed number is too high or too low. 

#include<stdio.h>
#include<stdlib.h>

int generate_number()
{
    int seed;
    printf("Enter any number to start game: ");
    scanf("%d", &seed);
    srand(seed);
    return (rand() % 100) + 1;
}

// Check guess and give hint
int check_guess(int secret, int guess)
{
    if(guess == secret)
        return 0;   // correct
    else if(guess < secret)
        return -1;  // too low
    else
        return 1;   // too high
}

// Print attempts left bar
void print_attempts_bar(int attempts_left)
{
    int i;
    printf("Attempts Left : [");
    for(i = 0; i < 10; i++)
    {
        if(i < attempts_left)
            printf("*");
        else
            printf("-");
    }
    printf("] %d/10\n", attempts_left);
}

void play_game()
{
    int secret, guess, result;
    int attempts_used = 0;
    int max_attempts  = 10;
    int low_hint      = 1;
    int high_hint     = 100;

    secret = generate_number();

    printf("\n================================\n");
    printf("   Number Guessing Game Start!  \n");
    printf("================================\n");
    printf("Guess the number between 1-100\n");
    printf("You have 10 attempts!\n\n");

    while(attempts_used < max_attempts)
    {
        print_attempts_bar(max_attempts - attempts_used);
        printf("Range Hint    : [%d  to  %d]\n", low_hint, high_hint);
        printf("Enter guess   : ");
        scanf("%d", &guess);

        // Validate input range
        if(guess < 1 || guess > 100)
        {
            printf("!! Enter number between 1 and 100 !!\n\n");
            continue;
        }

        attempts_used++;
        result = check_guess(secret, guess);

        if(result == 0)
        {
            printf("\n================================\n");
            printf("  Correct! You guessed it!\n");
            printf("  Secret Number : %d\n", secret);
            printf("  Attempts Used : %d / 10\n", attempts_used);

            if(attempts_used == 1)
                printf("  Score         : LEGENDARY!\n");
            else if(attempts_used <= 3)
                printf("  Score         : EXCELLENT!\n");
            else if(attempts_used <= 5)
                printf("  Score         : GOOD!\n");
            else
                printf("  Score         : NICE TRY!\n");

            printf("================================\n");
            return;
        }
        else if(result == -1)
        {
            printf(">> Too LOW!  Go Higher.\n\n");
            if(guess > low_hint)
                low_hint = guess + 1;
        }
        else
        {
            printf(">> Too HIGH! Go Lower.\n\n");
            if(guess < high_hint)
                high_hint = guess - 1;
        }
    }

    printf("\n================================\n");
    printf("  GAME OVER! No attempts left.\n");
    printf("  Secret Number was : %d\n", secret);
    printf("================================\n");
}

int main()
{
    char play_again;

    printf("================================\n");
    printf("   Welcome to Guessing Game!   \n");
    printf("================================\n");

    do
    {
        play_game();
        printf("\nPlay again? (y/n): ");
        scanf(" %c", &play_again);
    }
    while(play_again == 'y' || play_again == 'Y');

    printf("\nThanks for playing! Goodbye!\n");
    return 0;
}
