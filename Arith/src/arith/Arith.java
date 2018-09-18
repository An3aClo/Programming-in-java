package arith;

public class Arith {

    public double add(double a, double b) {
        double ans = a + b;
        return ans;
    }

    public double mult(double a, double b) {
        double ans = a * b;
        return ans;
    }

    public double sub(double a, double b) {
        double ans = a - b;
        return ans;
    }

    public double div(double a, double b) {
        double ans = a / b;
        return ans;
    }

    public int add(int a, int b) {
        int ans = a + b;
        return ans;
    }

    public int mult(int a, int b) {
        int ans = a * b;
        return ans;
    }

    public int sub(int a, int b) {
        int ans = a - b;
        return ans;
    }

    public int div(int a, int b) {
        int ans = a / b;
        return ans;
    }

    public static void main(String[] args) {
        //Instantiate an instance if Arith

        Arith ar = new Arith();

        //Send a messaage asking for addition to happen
        int sumint = ar.add(5, 10);
        double sumdouble = ar.add(5.5, 10.0);
        System.out.println("The sum of integer number is " + sumint);
        System.out.println("The sum of doubles number is " + sumdouble);
        System.out.println();
        // To send a message means to invoke a method

        int productInt = ar.mult(5, 10);
        double productDouble = ar.mult(5.5, 10.0);
        System.out.println("The product of integer numbers is " + productInt);
        System.out.println("The product of double  number is " + productDouble);
        System.out.println();
        
        int subInt = ar.sub(5, 10);
        double subDouble = ar.sub(5.5, 10.0);
        System.out.println("The subtraction of integer number is " + subInt);
        System.out.println("The substraction of double number is " + subDouble);
        System.out.println();
        
        int divInt = ar.div(5, 10);
        double divDouble = ar.div(5.5, 10.0);
        System.out.println("The division of integer number is " + divInt);
        System.out.println("The division of integer number is " + divDouble);
    }
}
