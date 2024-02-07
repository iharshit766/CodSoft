import java.util.Scanner;

public class calculategrade {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your marks out for 100 for each subject");
        System.out.println("Enter your marks in English: ");
        int eng = sc.nextInt();
        System.out.println("Enter your marks in Hindi: ");
        int hindi = sc.nextInt();
        System.out.println("Enter your marks in Science: ");
        int science = sc.nextInt();
        System.out.println("Enter your marks in Maths: ");
        int maths = sc.nextInt();
        System.out.println("Enter your marks in Social Studies: ");
        int ss = sc.nextInt();

        int totalmarks = total(eng, hindi, science, maths, ss);
        int average = avg(totalmarks);
        grade(average);
        sc.close();

    }

    public static int total(int eng, int hindi, int science, int maths, int ss) {
        int total = eng + hindi + science + maths + ss;
        System.out.println("Your Total Marks out of 500 is " + total);
        return total;

    }

    public static int avg(int total) {

        int avg = total / 5;
        System.out.println("Your Average Percentage is: " + avg);
        return avg;
    }

    public static void grade(int average) {
        if (average >= 80) {
            System.out.println("Your Acheived Grade is A");

        } else if (average <= 79 && average >= 65) {
            System.out.println("Your Acheived Grade is B");

        } else if (average <= 64 && average >= 33) {
            System.out.println("Your Acheived Grade is C");

        } else {
            System.out.println("Your Acheived Grade is D");

        }

    }

}
