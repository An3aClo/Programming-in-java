package calcarea;

public class CalcArea {
    //We are overloading  the area method
    //method 1

    public static int area(int lenght, int breadth) {
        int answer = lenght * breadth;
        return answer;
    }

    //copying a into lenght and b into breath is called PARAMETER PASSING by VALUE
    //method 2
    public static double area(double l, double b) {
        double ans = l * b;
        return ans;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        //assignment statement using a static method

        int c = area(a, b);//match method 1
        System.out.println("The area is " + c);

        double x = 6.5;
        double y = 8.2;
        double z = area(x, y);//match method 2
        System.out.println("The double area is " + z);
    }

}
