package factorial;
//factorial(5)=5*4*3*2*1 
//factorial(5)=5*factorial(4) called recursive case 
//factorial(1)=1  called BASE CASE

import java.util.Scanner;

public class Factorial {

    public static int factorial(int n) {
        int v = 1;

        for (int i = 1; i <= n; i++) {
            v = v * i;
        }
        return v;
    }

    public static int fact(int n) {

        if (n == 1) {//BASE CASE 
            return 1;
        } else {//RECURSIVE CASE
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = in.nextInt();
        System.out.println("The factorial of the number you gave is: " + factorial(x));
        System.out.println("The factorial of the number you gave is: " + fact(5));
    }

}
