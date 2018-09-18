package mysupperarray;
//array cannot grow but an array list can grow

import java.util.Arrays;
import java.util.Scanner;

public class MySupperArray {

    public static double[] inputArray() {
        double[] anArray;
        double[] newArray;
        
        int count;

        Scanner in = new Scanner(System.in);
        anArray = new double[0];
        count = 0;

        System.out.println("Enter a number");
        double value = in.nextDouble();

        while (value != -999.0) {

            newArray = new double[anArray.length + 1];

            for (int i = 0; i < anArray.length; i++) //how we copy
            {
                newArray[i] = anArray[i];
            }
            newArray[count] = value;
            anArray = newArray;
            count++;
            System.out.println("Enter a number");
            value = in.nextDouble();

        }
        return anArray;
    }

    public static double add(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + number;
        }
        /*   for (int i = 0; i < numbers.length; i++) {
            sum = sum+ numbers[i]; This can also be writtena as ---- sum+=numbers[i]
        }*/

        return sum;
    }

    public static double avg(double[] numbers) {
        double average = 0;
        for (int i = 0; i < numbers.length; i++) {
            average = add(numbers) / numbers.length;
        }

        return average;
    }

    public static double max(double[] numbers) {
        double max = 0;// pretent 0 is the biggest and then search for something to be bigger.
        for (double num : numbers) {
            if (max < num) {
                max = num;
            }
        }
        /*for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }*/
        // you can also sent the position of the maximun number in the array
        return max;
    }

    public static double min(double[] numbers) {
        double min = numbers[0];
        for (double n : numbers) {
            if (min > n) {
                min = n;
            }
        }
        /*for (int i = 0; i < numbers.length; i++) {
        
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }*/
        return min;
    }

    public static double[] clone(double[] numbers) {
        double[] copy = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }
        return copy;
    }

    public static int find(double[] numbers, double target) {
        // linear search
        int position = -1;//-1 is the sif]gnal that nothing is found.
        boolean found = false;
        for (int i = 0; i < numbers.length && !found; i++) {//once one of the conditions are false it will exit the loop
            if (numbers[i] == target) {
                found = true;
                position = i;
            }
        }
        return position;
    }

    public static void printArray(double[] numbers) {
        for (double number : numbers) {//fany way to do a loop
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] numbers;
        numbers = inputArray();

        System.out.println("The sum is: " + add(numbers));
        System.out.println("The average is " + avg(numbers));
        System.out.println("The maximun is " + max(numbers));
        System.out.println("The minimum is " + min(numbers));

        /*System.out.println("Enter search value: ");
        double target = in.nextDouble();
        System.out.println("The target " + target + " is at position: " + find(numbers, target));*/
        Arrays.sort(numbers);
//Build in sorting algrithm - allow you to sort the array- when stuff is sorted it is easyier to search 
//- you can then use a binary search which is faser
        printArray(numbers);
        System.out.println("Enter search value: ");
        double target = in.nextDouble();
        double x=Arrays.binarySearch(numbers, target);
        System.out.println("The target " + target + " is at position: "+x );

    }
}
