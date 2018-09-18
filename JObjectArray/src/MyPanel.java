
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stef on 2017/03/07.
 */
public class MyPanel extends JPanel implements ActionListener {
    JLabel[] labels = new JLabel[5];
    JLabel outLabel, outLabel2;
    JTextField[] textFields = new JTextField[5];
    JButton[] buttons = new JButton[2];

    public MyPanel() {
        setLayout(new GridLayout(7, 2));

        outLabel = new JLabel();
        outLabel2 = new JLabel();
        buttons[0] = new JButton("Calculate Sum");
        buttons[1] = new JButton("Calculate Average");

        for(int i = 0; i < 5; i++) {
            labels[i] = new JLabel("Number " + (i+1));
            textFields[i] = new JTextField();
        }

        for(int i = 0; i < 5; i++) {
            add(labels[i]);
            add(textFields[i]);
        }

        add(buttons[0]);
        add(buttons[1]).doLayout();
        add(outLabel);
        add(outLabel2);

        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Calculate Sum")) {
            int[] intArr = new int[textFields.length];
            for(int i = 0; i < textFields.length; i++) {
                intArr[i] = Integer.parseInt(textFields[i].getText());
            }
            int sum = JObjectArray.sum(intArr);
            outLabel.setText("Sum: ");
            outLabel2.setText(String.valueOf(sum));
        } else if(e.getActionCommand().equals("Calculate Average")) {
            int[] intArr = new int[textFields.length];
            for(int i = 0; i < textFields.length; i++) {
                intArr[i] = Integer.parseInt(textFields[i].getText());
            }
            int avg = JObjectArray.avg(intArr);
            outLabel.setText("Average: ");
            outLabel2.setText(String.valueOf(avg));
        }
    }
}
