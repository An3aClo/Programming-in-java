package three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Three {

    public static void main(String[] args) {

        MyFrame mf = new MyFrame();
        mf.setVisible(true);
    }

}

class MyFrame extends JFrame {

    public MyFrame() {

        this.setTitle("Calc");
        Container contentPane = this.getContentPane();
        MyPanel panel = new MyPanel();
        contentPane.add(panel);
        pack();
    }
}

class MyPanel extends JPanel implements ActionListener {

    JLabel l1;
    JLabel l2;
    JLabel l3;

    JButton b;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    JTextField a1;
    JTextField a2;
    JTextField a3;

    public MyPanel() {

        JPanel p = new JPanel();
        b = new JButton();
        b.setText("+");
        b1 = new JButton("-");
        b2 = new JButton("/");
        b3 = new JButton("*");
        b4 = new JButton("C");
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);

        l1 = new JLabel("First Number");
        l2 = new JLabel("Second numbre");
        l3 = new JLabel("Result");
        p.add(l1);
        p.add(l2);
        p.add(l3);

        a1 = new JTextField(5);
        a2 = new JTextField(5);
        a3 = new JTextField(5);
        p.add(a1);
        p.add(a2);
        p.add(a3);

        add(p);

        //Register each button with actionListener
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("+")) {
            //addition code goes here
            int a = Integer.parseInt(a1.getText());
            int b = Integer.parseInt(a2.getText());
            int sum = a + b;
            a3.setText(" " + sum);
        }

        if (evt.getActionCommand().equals("-")) {

            int a = Integer.parseInt(a1.getText());
            int b = Integer.parseInt(a2.getText());
            int sum = a - b;
            a3.setText(" " + sum);
        }
        if (evt.getActionCommand().equals("*")) {

            int a = Integer.parseInt(a1.getText());
            int b = Integer.parseInt(a2.getText());
            int sum = a * b;
            a3.setText(" " + sum);

        }
        if (evt.getActionCommand().equals("/")) {

            int a = Integer.parseInt(a1.getText());
            int b = Integer.parseInt(a2.getText());
            int sum = a / b;
            a3.setText(" " + sum);

        }

    }

}
