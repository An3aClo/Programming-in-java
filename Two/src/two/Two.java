package two;

import javax.swing.*;
import java.awt.*;

public class Two extends JFrame {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Two");
        jf.setVisible(true);
        

        JPanel panel = new JPanel();
        Container contentPane = jf.getContentPane();
        contentPane.add(panel);

        JLabel l = new JLabel("Hello");
       // l.setText("Hello");
        panel.add(l);
        //JButton b1 = new JButton("Hello");
    }

}
