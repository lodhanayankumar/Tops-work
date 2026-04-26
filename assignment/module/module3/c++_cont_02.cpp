//2. Number Guessing Game 
//o Write a C++ program that asks the user to guess a number between 1 and 100. The 
//program should provide hints if the guess is too high or too low. Use loops to allow 
//the user multiple attempts. 
//o Objective: Understand while loops and conditional logic.
 #include <iostream>
using namespace std;

int main() {
    int number = 42;   // fixed number
    int guess;

    cout << "Guess the number (between 1 and 100):" << endl;

    while (true) {
        cout << "Enter your guess: ";
        cin >> guess;

        if (guess > number) {
            cout << "Too high! Try again." << endl;
        }
        else if (guess < number) {
            cout << "Too low! Try again." << endl;
        }
        else {
            cout << "Correct! You guessed the number." << endl;
            break;
        }
    }
}
