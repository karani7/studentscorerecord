import java.util.Scanner;

public class StudentScoreRecord
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1️⃣ Input School Details ---
        System.out.println("--- Enter School Details ---");
        System.out.print("Enter School Name: ");
        String schoolName = scanner.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = scanner.nextLine();

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        // --- 2️⃣ Input Student Records ---
        int minStudents = 12;
        System.out.print("Enter number of students (min " + minStudents + "): ");
        int numStudents = scanner.nextInt();

        // Validation warning (optional, but good practice)
        if (numStudents < minStudents) {
            System.out.println("Warning: The requirement is at least 12 students.");
        }

        // Initialize Arrays
        String[] names = new String[numStudents];
        // 2D Array for marks: [Student][Subject]
        // Subjects: 0:Eng, 1:Math, 2:Hist, 3:Geog, 4:Sci, 5:Prog
        double[][] marks = new double[numStudents][6];
        double[] totalMarks = new double[numStudents];
        char[] ranks = new char[numStudents];

        scanner.nextLine(); // Consume leftover newline

        // Input Loop
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            names[i] = scanner.nextLine();

            System.out.print("Marks for English: ");
            marks[i][0] = scanner.nextDouble();
            System.out.print("Marks for Math: ");
            marks[i][1] = scanner.nextDouble();
            System.out.print("Marks for History: ");
            marks[i][2] = scanner.nextDouble();
            System.out.print("Marks for Geography: ");
            marks[i][3] = scanner.nextDouble();
            System.out.print("Marks for Science: ");
            marks[i][4] = scanner.nextDouble();
            System.out.print("Marks for Programming: ");
            marks[i][5] = scanner.nextDouble();

            scanner.nextLine(); // Consume newline after numbers

            // --- 3️⃣ Compute Results (Total & Rank per Student) ---
            double sum = 0;
            for (double mark : marks[i]) {
                sum += mark;
            }
            totalMarks[i] = sum;

            // Determine Rank
            if (sum >= 540.0) ranks[i] = 'A';
            else if (sum >= 480.0) ranks[i] = 'B';
            else if (sum >= 420.0) ranks[i] = 'C';
            else if (sum >= 360.0) ranks[i] = 'D';
            else ranks[i] = 'F';
        }

        // --- 4️⃣ Compute Class Statistics ---
        double[] subjectTotals = new double[6];
        double[] subjectAvgs = new double[6];
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        // Calculate Subject Totals and Count Ranks
        for (int i = 0; i < numStudents; i++) {
            for (int sub = 0; sub < 6; sub++) {
                subjectTotals[sub] += marks[i][sub];
            }

            switch (ranks[i]) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'F': countF++; break;
            }
        }

        // Calculate Subject Averages
        for (int sub = 0; sub < 6; sub++) {
            subjectAvgs[sub] = subjectTotals[sub] / numStudents;
        }

        double classGrandTotal = 0;
        for (double t : totalMarks) classGrandTotal += t;
        double classGrandAvg = classGrandTotal / numStudents;

        // --- 5️⃣ Output Format (Replicating the Sample) ---

        System.out.println("\n\n");
        String dashLine = "----------------------------------------------------------------------------------------------------------------";
        System.out.println(dashLine);

        // Header
        // Using approximate centering based on string length
        System.out.printf("%60s %s\n", "School Name:", schoolName);
        System.out.printf("%60s %s\n", "Teacher:", teacherName);
        System.out.printf("%60s %s\n", "Grade:", grade);
        System.out.printf("%60s %d\n", "Year:", year);
        System.out.println(dashLine);

        // Table Header
        // %-20s means left-align 20 chars, %9s means right-align 9 chars
        System.out.printf("%-20s %9s %9s %9s %9s %9s %12s %9s %4s\n",
                "Student Name", "English", "Math", "History", "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println(dashLine);

        // Student Rows
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s %9.2f %9.2f %9.2f %9.2f %9.2f %12.2f %9.2f %4c\n",
                    names[i],
                    marks[i][0], marks[i][1], marks[i][2], marks[i][3], marks[i][4], marks[i][5],
                    totalMarks[i], ranks[i]);
        }

        System.out.println(dashLine);

        // Subject Totals Row
        System.out.printf("%20s %9.2f %9.2f %9.2f %9.2f %9.2f %12.2f %9.2f\n",
                " ", // Empty space for name column
                subjectTotals[0], subjectTotals[1], subjectTotals[2],
                subjectTotals[3], subjectTotals[4], subjectTotals[5], classGrandTotal);

        System.out.println(dashLine);

        // Subject Averages Row
        System.out.printf("%20s %9.2f %9.2f %9.2f %9.2f %9.2f %12.2f %9.2f\n",
                " ",
                subjectAvgs[0], subjectAvgs[1], subjectAvgs[2],
                subjectAvgs[3], subjectAvgs[4], subjectAvgs[5], classGrandAvg);

        System.out.println(dashLine);

        // Rank Counts Footer
        System.out.printf("       Ranks      A's: %d      B's: %d      C's: %d      D's: %d      F's: %d\n",
                countA, countB, countC, countD, countF);

        System.out.println(dashLine);
        scanner.close();
    }
}