Student Grade Report System
     Project Overview
This project is a Java-based Console Application designed to automate the generation of school report cards. It functions as a digital gradebook that accepts raw student data, processes academic performance metrics, and renders a highly formatted, professional grade sheet.

The system is built to replicate specific reporting standards, ensuring precise alignment of names, scores, and calculated statistics in a tabular format. It handles data entry for multiple students and subjects, enforcing specific grading logic to determine student rankings.

Language: Java (JDK 8+) Interface: Command Line / Terminal

    Key Features
1. Comprehensive Data Input
The system allows for dynamic input of institutional and student details using the Scanner class:
School Metadata: Captures School Name, Teacher Name, Grade Level, and Academic Year.
Student Records: Accepts data for a class of students (minimum requirement of 12), including names and raw marks for 6 subjects:
English, Math, History, Geography, Science, Programming.

2. Automated Calculations
The application eliminates manual errors by automatically computing:
Total Score: Sum of marks across all 6 subjects per student.
Rank Assignment: Automatically assigns a letter grade (A, B, C, D, F) based on total score thresholds.
Class Statistics: Calculates the total marks and average marks for each subject across the entire class.
Grade Distribution: Counts the total number of A's, B's, C's, etc., to provide a summary of class performance.

3. Grading Logic
The system implements the following grading scale based on the Total Score:

Total Marks Range	Rank / Grade
≥ 540.0	A
≥ 480.0 and < 540.0	B
≥ 420.0 and < 480.0	C
≥ 360.0 and < 420.0	D
< 360.0	F

Export to Sheets

4. Precision Formatting
A key feature of this project is the formatted console output. It uses Java's System.out.printf to ensure:
Student names are left-aligned.
Numerical scores are right-aligned.
All floating-point numbers are displayed with exactly two decimal places for consistency.
The final output replicates a printed report card structure.

     Technical Implementation
This project demonstrates core Computer Science and Java programming concepts:

Data Structures (Arrays):
Parallel Arrays: Used 1D arrays for Student Names, Total Marks, and Ranks to keep data synchronized.
2D Arrays: Used a double[students][subjects] matrix to store and manipulate subject marks efficiently.
Control Flow:
Loops: Nested for loops are used for input validation, traversing the 2D array for calculations, and printing rows.
Switch Statements: Used to efficiently tally the count of each Rank (A-F).
Input Handling: Robust handling of mixed input types (Integers, Strings, Doubles) using java.util.Scanner.
   How to Run the Application
Prerequisites
Java Development Kit (JDK) installed.
A terminal or IDE (VS Code, IntelliJ, Eclipse).

Step 1: Compile
Open your terminal/command prompt, navigate to the folder containing StudentReportCard.java, and run:
Bash
javac StudentReportCard.java
Step 2: Execute
Run the compiled class file:
Bash
java StudentReportCard
Step 3: Usage
Follow the on-screen prompts.
Enter the School Details when asked.
Enter the number of students.
For each student, input the Name followed by the marks for the 6 subjects.

The system will generate and print the final table immediately after data entry is complete.

   Sample Output
The final output is rendered as a structured table:
Plaintext

-------------------------------------------------------------------------
                          School Name: Ronald Reagan High School
                              Teacher: Mr. Paul Swatz
                                Grade: 10
                                 Year: 2018
-------------------------------------------------------------------------
Student Name       English    Math History Geography  Science Programming   Total Rank
-------------------------------------------------------------------------
Alice Arnold         76.00   65.00   91.00     89.00    98.00      100.00  519.00    B
Cory Brown           67.00   88.00   87.80     67.90    60.90       69.90  441.50    C
...
-------------------------------------------------------------------------
Subject Totals     1154.20 1205.50 1213.10   1244.90  1207.10     1180.70 7205.50
Subject Averages     76.95   80.37   80.87     82.99    80.47       78.71  480.37
-------------------------------------------------------------------------
       Ranks      A's: 4      B's: 4      C's: 4      D's: 2      F's: 1
 Author
Name: MORRIS.K.N Date:9 December 2025 Course: OBJECT ORIENTED PROGRAMMING
