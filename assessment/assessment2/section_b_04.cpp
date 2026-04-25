//4. File handling
//Build a program that:
//? Writes daily goals to a file
//? Reads and displays them on program restart
//? Uses correct file modes

#include<iostream>
#include<fstream>
#include<string>
using namespace std;

void writeGoals(){
    ofstream file;
    file.open("goals.txt", ios::app);
    
    if(!file){
        cout<<"Error opening file!"<<endl;
        return;
    }
    
    int n;
    string goal;
    
    cout<<"How many goals to add? ";
    cin>>n;
    cin.ignore();
    
    for(int i = 0; i < n; i++){
        cout<<"Enter goal "<<(i+1)<<": ";
        getline(cin, goal);
        file<<goal<<endl;
    }
    
    file.close();
    cout<<"Goals saved successfully!"<<endl;
}

void readGoals(){
    ifstream file;
    file.open("goals.txt");
    
    if(!file){
        cout<<"No goals file found. Add some goals first!"<<endl;
        return;
    }
    
    string line;
    int count = 1;
    
    cout<<"====================================="<<endl;
    cout<<"         YOUR DAILY GOALS            "<<endl;
    cout<<"====================================="<<endl;
    
    while(getline(file, line)){
        cout<<count<<". "<<line<<endl;
        count++;
    }
    
    if(count == 1){
        cout<<"No goals written yet."<<endl;
    }
    
    file.close();
    cout<<"====================================="<<endl;
}

void clearGoals(){
    ofstream file;
    file.open("goals.txt", ios::trunc);
    file.close();
    cout<<"All goals cleared!"<<endl;
}

int main(){
    int choice;
    
    cout<<"====================================="<<endl;
    cout<<"      DAILY GOALS MANAGER            "<<endl;
    cout<<"====================================="<<endl;
    cout<<"1. Add new goals"<<endl;
    cout<<"2. View all goals"<<endl;
    cout<<"3. Clear all goals"<<endl;
    cout<<"4. Exit"<<endl;
    cout<<"====================================="<<endl;
    cout<<"Enter choice: ";
    cin>>choice;
    
    if(choice == 1){
        writeGoals();
    }
    else if(choice == 2){
        readGoals();
    }
    else if(choice == 3){
        clearGoals();
    }
    else if(choice == 4){
        cout<<"Goodbye!"<<endl;
    }
    else{
        cout<<"Invalid choice!"<<endl;
    }
    
    return 0;
}
