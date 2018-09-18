import javax.swing.*;


public class JObjectArray {
    public static int sum(int[] ints) {
        int total = 0;
        for(int i = 0; i < ints.length; i++) {
            total += ints[i];
        }
        return total;
    }

    public static int avg(int[] ints) {
        return sum(ints) / (ints.length);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

