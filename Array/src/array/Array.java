package array;

import java.util.Scanner;

public class Array {

    public void printArrays(Array1[] a, Array2[] b) {

        for (int i = 0; i <a.length && i <b.length; i++) {

            System.out.println("Name: " + a[i].getName());
            System.out.println("Surname: " + a[i].getSurname());
            System.out.println("Number: " + b[i].getNum());

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Array1[] a = new Array1[2];
        Array2[] b = new Array2[2];

        for (int i = 0; i < a.length && i < b.length; i++) {
            System.out.println("Enter name");
            String name = in.next();

            System.out.println("Enter surname");
            String surname = in.next();

            System.out.println("Entter number");
            int num = in.nextInt();

            Array1 ar = new Array1();
            ar.setName(name);
            ar.setSurname(surname);
            a[i] = ar;

            Array2 arr = new Array2();
            arr.setNum(num);
            b[i] = arr;
        }
        //Array array = new Array();
        //array.printArrays(a, b);
    }

}
