package threeb;

import javax.swing.*;

import java.awt.*;

public class ThreeB {

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

    public MyPanel() {

        JPanel p = new JPanel();
        JButton b = new JButton();
        b.setText("+");
        JButton b1 = new JButton("-");
        JButton b2 = new JButton("/");
        JButton b3 = new JButton("*");
        JButton b4 = new JButton("C");
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);

        JLabel l1 = new JLabel("First Number");
        JLabel l2 = new JLabel("Second numbre");
        JLabel l3 = new JLabel("Result");
        p.add(l1);
        p.add(l2);
        p.add(l3);

        // JTextArea a1 = new JTextArea("                  ");
        // JTextArea a2 = new JTextArea("                  ");
        //JTextArea a3 = new JTextArea("                  ");
        //p.add(a1);
        //p.add(a2);
        //p.add(a3);
        JTextField f1 = new JTextField(20);
        JTextField f2 = new JTextField(20);
        JTextField f3 = new JTextField(20);
        p.add(f1);
        p.add(f2);
        p.add(f3);
        add(p);
        
        //Register each button with actionListener
        
        
    }

    public void ActionPerformed(ActionEvent evt) {
        
    }
}
