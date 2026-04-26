//3. Inheritance Example 
//o Write a program that implements inheritance using a base class Person and derived 
//classes Student and Teacher. Demonstrate reusability through inheritance. 
//o Objective: Learn the concept of inheritance. 

#include <iostream>
using namespace std;

// Base class
class Person {
public:
    string name;
    int age;

    void getPersonData() {
        cout << "Enter name: ";
        cin >> name;
        cout << "Enter age: ";
        cin >> age;
    }

    void showPersonData() {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
    }
};

// Derived class Student
class Student : public Person {
public:
    int rollNo;

    void getStudentData() {
        getPersonData();
        cout << "Enter roll number: ";
        cin >> rollNo;
    }

    void showStudentData() {
        showPersonData();
        cout << "Roll No: " << rollNo << endl;
    }
};

// Derived class Teacher
class Teacher : public Person {
public:
    string subject;

    void getTeacherData() {
        getPersonData();
        cout << "Enter subject: ";
        cin >> subject;
    }

    void showTeacherData() {
        showPersonData();
        cout << "Subject: " << subject << endl;
    }
};

int main() {
    Student s;
    Teacher t;

    cout << "\n--- Enter Student Details ---" << endl;
    s.getStudentData();

    cout << "\n--- Enter Teacher Details ---" << endl;
    t.getTeacherData();

    cout << "\n--- Student Information ---" << endl;
    s.showStudentData();

    cout << "\n--- Teacher Information ---" << endl;
    t.showTeacherData();
}
