package reversedintarray;

public class ReversedIntArray {

    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < number.length / 2; i++) {

            int temp = number[i];
            number[i] = number[number.length - 1 - i];
            number[number.length - 1 - i] = temp;

        }
       System.out.println("Reversed Array: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(+number[i]+" ");
        }

    }
}
