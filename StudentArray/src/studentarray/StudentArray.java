package studentarray;

import java.util.Scanner;

public class StudentArray {

    public static void printArray(Student[] p) {
        for(int i=0; i<p.length;i++) {
            System.out.println(p[i].getFName() + " " + p[i].getLName());
        }
    }

    public static void main(String[] args) {
        //Creat an array of students

        Scanner in = new Scanner(System.in);

        Student[] s = new Student[5];

        //create the first student object
        Student x = new Student();
        x.setFName("Donald");
        x.setLName("Trump");

        s[0] = x;
        
        //anothe approch
        s[1] = new Student();
        s[1].setFName("Andrea");
        s[1].setLName("Cloete");

        for (int i = 2; i <= 4; i++) {
            System.out.println("Enter first name");
            String fn = in.next();
            System.out.println("Enter last name");
            String ln = in.next();
            Student newStudent = new Student();
            newStudent.setFName(fn);
            newStudent.setLName(ln);
            s[i] = newStudent;
        }
        printArray(s);

    }

}
