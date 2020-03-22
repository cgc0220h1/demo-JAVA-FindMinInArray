import java.util.Scanner;

public class NumberArray {
    public static void displayArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.printf("%5d", array[index]);
        }
        System.out.println();
    }

    public static void addElement(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < array.length; index++) {
            System.out.print("Add element " + index + ": ");
            array[index] = scanner.nextInt();
        }
    }

    public static void randomElement(int[] array) {
        for (int index = 0; index < array.length; index++) {
            array[index] = (int) Math.floor(Math.random() * 10);
        }
    }

    public static int[] findMinElement(int[] array) {
        int min = array[0];
        int position = 0;
        int[] result = new int[2];
        for (int index = 1; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
                position = index;
            }
        }
        result[0] = position;
        result[1] = min;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidNumber = false;
        int size;

        do {
            System.out.print("Enter size of array: ");
            size = scanner.nextInt();
            if (size >= 0 && size <= 10) {
                isValidNumber = true;
            } else {
                System.out.println("Invalid Input! Minimum is 0 and Maximum is 10");
            }
        } while (!isValidNumber);

        int[] demoArray = new int[size];
        System.out.println();

        int choice;
        boolean isValidChoice = false;
        do {
            System.out.println("1. Add integer to array");
            System.out.println("2. Random integer to array");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice! Choose again");
            } else {
                isValidChoice = true;
            }
        } while (!isValidChoice);
        System.out.println();

        switch (choice) {
            case 1:
                addElement(demoArray);
                break;
            case 2:
                randomElement(demoArray);
                break;
        }

        System.out.println("Here is your array: ");
        displayArray(demoArray);
        System.out.println();
        System.out.println("Let me find the minimum element for you: ");
        int[] result = findMinElement(demoArray);
        System.out.printf("The minimum element is at %d with a value of %d", result[0], result[1]);
    }
}