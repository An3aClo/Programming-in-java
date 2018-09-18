package firstarray;

public class FirstArray {

    public static void printArray(int[] b) {
        
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    public static void main(String[] args) {

        //datatype[] name= new datatype[size]---this instansiates a array
        //this array have 7 elements
        int[] a = new int[7];

        //This populates the array
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
        a[3] = 7;
        a[4] = 8;
        a[5] = 9;
        a[6] = 10;

        printArray(a);
    }

}
