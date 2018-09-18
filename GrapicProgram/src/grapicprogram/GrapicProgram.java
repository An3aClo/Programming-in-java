package grapicprogram;

import javax.swing.*;
import java.awt.event.*;

public class GrapicProgram {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Hello");

        String input = JOptionPane.showInputDialog("Enter a number");
        int number = Integer.parseInt(input);

        JOptionPane.showMessageDialog(null, "The input was: " + input);

        String in = JOptionPane.showInputDialog("Enter a number");
        int otherNumber = Integer.parseInt(in);

        int sum = number + otherNumber;
        JOptionPane.showMessageDialog(null, "The sum is: " + sum);

    }

}
