package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter year of birth: ");

        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle next line character (enter key)

            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            int age = 2020 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ", and you're " + age + " years old (as of 2020)");
            } else {
                System.out.println("Invalid year of birth, " + name + " you incompetent penis...");
            }
        } else {
            System.out.println("Unable to parse year of birth, you absolute fucking retard!!!");
        }

        scanner.close();
    }
}
