//Student Productivity Tracker
//Objective
//Build a console-based Student Productivity Tracker that logs daily study hours and
//generates a weekly report.
//Your application must:
//1. Menu-driven program
//2. Log daily study hours
//3. Generate weekly report
//4. Store data using files

#include<iostream>
#include<fstream>
#include<string>
#include<cstdlib>
using namespace std;

// ================================================
//   FUNCTION 1: LOG DAILY STUDY HOURS
// ================================================
void logStudyHours(){
    ofstream file;
    file.open("study_log.txt", ios::app);

    if(!file){
        cout<<"ERROR: Cannot open file!"<<endl;
        return;
    }

    string day, subject;
    float hours;

    cout<<"\n====================================="<<endl;
    cout<<"         LOG STUDY HOURS             "<<endl;
    cout<<"====================================="<<endl;

    cout<<"Enter Day (e.g. Monday): ";
    getline(cin, day);

    cout<<"Enter Subject: ";
    getline(cin, subject);

    cout<<"Enter Hours Studied: ";
    cin>>hours;

    if(hours < 0 || hours > 24){
        cout<<"Invalid hours! Enter between 0 and 24."<<endl;
        file.close();
        return;
    }

    file<<day<<","<<subject<<","<<hours<<"\n";
    file.close();

    cout<<"-------------------------------------"<<endl;
    cout<<"  Study log saved successfully!"<<endl;
    cout<<"====================================="<<endl;
}

// ================================================
//   FUNCTION 2: VIEW ALL LOGS
// ================================================
void viewAllLogs(){
    ifstream file;
    file.open("study_log.txt");

    if(!file){
        cout<<"\nNo study logs found. Log hours first!"<<endl;
        return;
    }

    string line, day, subject, hours;
    int count = 0;

    cout<<"\n====================================="<<endl;
    cout<<"          ALL STUDY LOGS              "<<endl;
    cout<<"====================================="<<endl;
    cout<<"No.  Day         Subject      Hours"<<endl;
    cout<<"-------------------------------------"<<endl;

    while(getline(file, line)){
        if(line == "") continue;

        int c1 = line.find(',');
        int c2 = line.find(',', c1+1);

        if(c1 == -1 || c2 == -1) continue;

        day     = line.substr(0, c1);
        subject = line.substr(c1+1, c2-c1-1);
        hours   = line.substr(c2+1);

        count++;
        cout<<count<<".   ";

        cout<<day;
        for(int i = day.length(); i < 12; i++) cout<<" ";

        cout<<subject;
        for(int i = subject.length(); i < 13; i++) cout<<" ";

        cout<<hours<<" hrs"<<endl;
    }

    if(count == 0){
        cout<<"  File is empty. No logs yet."<<endl;
    }

    file.close();
    cout<<"====================================="<<endl;
    cout<<"  Total entries: "<<count<<endl;
    cout<<"====================================="<<endl;
}

// ================================================
//   FUNCTION 3: WEEKLY REPORT
// ================================================
void weeklyReport(){
    ifstream file;
    file.open("study_log.txt");

    if(!file){
        cout<<"\nNo study logs found. Log hours first!"<<endl;
        return;
    }

    string line, day, subject;
    float total    = 0;
    float maxHours = 0;
    float minHours = -1;
    int   count    = 0;
    string bestDay = "";
    string bestSub = "";

    string days[7]     = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    float  dayTotal[7] = {0,0,0,0,0,0,0};
    int    dayCount[7] = {0,0,0,0,0,0,0};

    while(getline(file, line)){
        if(line == "") continue;

        int c1 = line.find(',');
        int c2 = line.find(',', c1+1);

        if(c1 == -1 || c2 == -1) continue;

        day     = line.substr(0, c1);
        subject = line.substr(c1+1, c2-c1-1);

        // FIX: atof() works in all C++ versions including old Dev-C++
        string hStr = line.substr(c2+1);
        float h = atof(hStr.c_str());

        total += h;
        count++;

        if(h > maxHours){
            maxHours = h;
            bestDay  = day;
            bestSub  = subject;
        }

        if(minHours < 0 || h < minHours){
            minHours = h;
        }

        for(int i = 0; i < 7; i++){
            if(day == days[i]){
                dayTotal[i] += h;
                dayCount[i]++;
            }
        }
    }

    file.close();

    if(count == 0){
        cout<<"No data to generate report!"<<endl;
        return;
    }

    float average  = total / count;
    float avgDaily = total / 7;

    cout<<"\n====================================="<<endl;
    cout<<"        WEEKLY STUDY REPORT           "<<endl;
    cout<<"====================================="<<endl;
    cout<<"Day-wise Breakdown:"<<endl;
    cout<<"-------------------------------------"<<endl;

    for(int i = 0; i < 7; i++){
        if(dayCount[i] > 0){
            cout<<days[i];
            for(int j = days[i].length(); j < 12; j++) cout<<" ";
            cout<<": "<<dayTotal[i]<<" hrs  [";

            int bars = (int)dayTotal[i];
            if(bars > 10) bars = 10;
            for(int b = 0; b < bars; b++)  cout<<"#";
            for(int b = bars; b < 10; b++) cout<<"-";
            cout<<"]"<<endl;
        }
    }

    cout<<"-------------------------------------"<<endl;
    cout<<"Total Hours This Week : "<<total<<" hrs"<<endl;
    cout<<"Average Per Session   : "<<average<<" hrs"<<endl;
    cout<<"Most Productive Day   : "<<bestDay<<" ("<<bestSub<<")"<<endl;
    cout<<"Highest Session       : "<<maxHours<<" hrs"<<endl;
    cout<<"Lowest Session        : "<<minHours<<" hrs"<<endl;
    cout<<"Total Sessions Logged : "<<count<<endl;
    cout<<"-------------------------------------"<<endl;

    cout<<"\nWeekly Status: ";
    if(avgDaily >= 6){
        cout<<"EXCELLENT! You are a study champion!"<<endl;
    }
    else if(avgDaily >= 4){
        cout<<"GREAT WORK! Keep pushing forward!"<<endl;
    }
    else if(avgDaily >= 2){
        cout<<"GOOD! Try to increase study hours."<<endl;
    }
    else{
        cout<<"WARNING! Study more for better results."<<endl;
    }

    cout<<"====================================="<<endl;
}

// ================================================
//   FUNCTION 4: CLEAR ALL LOGS
// ================================================
void clearLogs(){
    char confirm;
    cout<<"\nAre you sure? Clear all logs? (y/n): ";
    cin>>confirm;
    cin.ignore();

    if(confirm == 'y' || confirm == 'Y'){
        ofstream file;
        file.open("study_log.txt", ios::trunc);
        file.close();
        cout<<"All study logs cleared!"<<endl;
    }
    else{
        cout<<"Clear cancelled."<<endl;
    }
}

// ================================================
//   MAIN MENU
// ================================================
int main(){
    int choice;

    cout<<"\n====================================="<<endl;
    cout<<"   STUDENT PRODUCTIVITY TRACKER      "<<endl;
    cout<<"====================================="<<endl;
    cout<<"  Track your study hours daily and"<<endl;
    cout<<"  generate your weekly report!"<<endl;
    cout<<"====================================="<<endl;

    do{
        cout<<"\n----------- MENU ----------------"<<endl;
        cout<<"  1. Log todays study hours"<<endl;
        cout<<"  2. View all study logs"<<endl;
        cout<<"  3. Generate weekly report"<<endl;
        cout<<"  4. Clear all logs"<<endl;
        cout<<"  5. Exit"<<endl;
        cout<<"---------------------------------"<<endl;
        cout<<"  Enter choice: ";
        cin>>choice;
        cin.ignore();

        switch(choice){
            case 1: logStudyHours(); break;
            case 2: viewAllLogs();   break;
            case 3: weeklyReport();  break;
            case 4: clearLogs();     break;
            case 5:
                cout<<"\n====================================="<<endl;
                cout<<"  Keep studying! Goodbye!"<<endl;
                cout<<"====================================="<<endl;
                break;
            default:
                cout<<"Invalid choice! Enter 1 to 5."<<endl;
        }

    }while(choice != 5);

    return 0;
}
