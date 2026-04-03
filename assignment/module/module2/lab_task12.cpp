//Write a C program that defines a structure to store a student's details (name, 
//roll number, and marks). Use an array of structures to store details of 3 
//students and print them

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct student{
	char name[50];
	int roll_number;
	int mark;
};
int main()
{
	struct student a1[3];
	a1[0].roll_number = 1;
	strcpy(a1[0].name,"nayan");
	a1[0].mark= 98;
	
	a1[1].roll_number = 2;
	strcpy(a1[1].name,"parth");
	a1[1].mark= 97;
	
	a1[2].roll_number = 3;
	strcpy(a1[2].name,"riya");
	a1[2].mark= 96;
	
	printf("%d %s  %d\n",a1[0].roll_number,a1[0].name,a1[0].mark);
	printf("%d %s  %d\n",a1[1].roll_number,a1[1].name,a1[1].mark);
	printf("%d %s  %d\n",a1[2].roll_number,a1[2].name,a1[2].mark);
}
