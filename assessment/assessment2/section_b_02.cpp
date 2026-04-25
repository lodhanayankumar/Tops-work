//2. Loops + Arrays
//Create a program that:
//? Accepts 7 days of screen time data
//? Calculates and prints:
//? Total screen time
//? Average screen time
//? Displays a warning if average exceeds healthy limi
#include<iostream>
using namespace std;

int main(){
    float hours[7];
    float total = 0;
    float average = 0;
    float healthy_limit = 2.0;
    
    string days[7] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    cout<<"       WEEKLY SCREEN TIME TRACKER           "<<endl;
    cout<<"============================================"<<endl;
    cout<<"Enter screen time in hours for each day:"<<endl;
    cout<<"--------------------------------------------"<<endl;
    
    for(int i = 0; i < 7; i++){
        cout<<days[i]<<": ";
        cin>>hours[i];
        while(hours[i] < 0 || hours[i] > 24){
            cout<<"Invalid! Enter hours between 0 and 24: ";
            cin>>hours[i];
        }   
        total = total + hours[i];
    }
    average = total / 7;
    cout<<"            WEEKLY REPORT                   "<<endl;
    cout<<"============================================"<<endl;
    cout<<"Day-by-Day Screen Time:"<<endl;
    cout<<"--------------------------------------------"<<endl;
    
    for(int i = 0; i < 7; i++){
        cout<<days[i]<<": "<<hours[i]<<" hours";
        
        if(hours[i] > healthy_limit){
            cout<<" [HIGH]";
        }
        else{
            cout<<" [OK]";
        }
        cout<<endl;
    }
    
    cout<<"--------------------------------------------"<<endl;
    cout<<"Total Screen Time  : "<<total<<" hours"<<endl;
    cout<<"Average Per Day    : "<<average<<" hours"<<endl;
    cout<<"Healthy Limit/Day  : "<<healthy_limit<<" hours"<<endl;
    cout<<"--------------------------------------------"<<endl;
    
    if(average > healthy_limit){
        cout<<"WARNING: Your average screen time exceeds"<<endl;
        cout<<"the healthy limit of "<<healthy_limit<<" hours/day!"<<endl;
        cout<<"Please reduce your screen time for better health."<<endl;
    }
    else if(average == healthy_limit){
        cout<<"NOTICE: You are exactly at the healthy limit."<<endl;
        cout<<"Try to reduce a bit more for better health."<<endl;
    }
    else{
        cout<<"GREAT JOB: Your screen time is within"<<endl;
        cout<<"the healthy limit. Keep it up!"<<endl;
    }
}
