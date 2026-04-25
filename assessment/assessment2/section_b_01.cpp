//1. Conditional Logic Implementation
//Design a “Study Mood Assistant” that:
//? Takes user input: hours studied today
//? Displays motivation messages based on conditions
//? Uses if-else ladder or switch case

#include<iostream>
#include<string>
using namespace std;

int main(){
    int hours;
    cout<<"       STUDY MOOD ASSISTANT          "<<endl;
    cout<<"-------------------------------------"<<endl;
    cout<<"Enter hours studied today: ";
    cin>>hours;
    cout<<"-------------------------------------"<<endl;
    if(hours < 0){
        cout<<"Invalid input! Hours cannot be negative."<<endl;
    }
    else if(hours == 0){
        cout<<"MOOD   : Lazy Day "<<endl;
        cout<<"Message: You haven't studied yet today!"<<endl;
        cout<<"Tip    : Even 30 minutes can make a difference."<<endl;
        cout<<"Start small - open your book right now!"<<endl;
    }
    else if(hours >= 1 && hours <= 2){
        cout<<"MOOD   : Just Getting Started "<<endl;
        cout<<"Message: Good, you made a start today!"<<endl;
        cout<<"Tip    : Try to add one more hour if possible."<<endl;
        cout<<"Every minute of study counts!"<<endl;
    }
    else if(hours >= 3 && hours <= 4){
        cout<<"MOOD   : On Track "<<endl;
        cout<<"Message: You are doing well today!"<<endl;
        cout<<"Tip    : Take a short break then keep going."<<endl;
        cout<<"Consistency is the key to success!"<<endl;
    }
    else if(hours >= 5 && hours <= 6){
        cout<<"MOOD   : Great Progress "<<endl;
        cout<<"Message: Excellent effort today!"<<endl;
        cout<<"Tip    : Make sure to review what you studied."<<endl;
        cout<<"You are ahead of most students today!"<<endl;
    }
    else if(hours >= 7 && hours <= 8){
        cout<<"MOOD   : Study Champion "<<endl;
        cout<<"Message: Wow, you are crushing it today!"<<endl;
        cout<<"Tip    : Do not forget to eat and drink water."<<endl;
        cout<<"Your hard work will pay off soon!"<<endl;
    }
    else if(hours > 8 && hours <= 12){
        cout<<"MOOD   : Overachiever "<<endl;
        cout<<"Message: Amazing dedication and focus!"<<endl;
        cout<<"Tip    : Rest is also part of learning."<<endl;
        cout<<"Make sure to sleep well tonight!"<<endl;
    }
    else if(hours > 12){
        cout<<"MOOD   : Need Rest! "<<endl;
        cout<<"Message: That is too many hours in one day!"<<endl;
        cout<<"Tip    : Your brain needs rest to store memories."<<endl;
        cout<<"Please take a proper break now!"<<endl;
    } 
    cout<<"********************************"<<endl;
    cout<<"Keep studying and never give up!"<<endl;
}
