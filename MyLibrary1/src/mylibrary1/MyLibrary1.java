package mylibrary1;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyLibrary1 {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }

}

class MainFrame extends JFrame implements ActionListener {

    private JTable table;
    private JScrollPane scrollPane;

    private JButton addNewBookBt;

    public MainFrame() {
        setTitle("My Library");
        Container c = this.getContentPane();
        IntroPanel introPanel = new IntroPanel();
        c.add(introPanel, BorderLayout.NORTH);
        InstructionPanel instructionPanel = new InstructionPanel();
        c.add(instructionPanel);
        BookRelatedButtonsPanel bookRelatedButtonsPanel = new BookRelatedButtonsPanel();
        c.add(bookRelatedButtonsPanel, BorderLayout.SOUTH);
        pack();
    }

    class IntroPanel extends JPanel {

        public IntroPanel() {
            JLabel intoToMainFrame = new JLabel("WELCOME");
            add(intoToMainFrame);
        }
    }

    class InstructionPanel extends JPanel {

        public InstructionPanel() {
            JLabel instructionMessage = new JLabel("Please select action");
            add(instructionMessage);
        }
    }

    class BookRelatedButtonsPanel extends JPanel {

        public BookRelatedButtonsPanel() {
            addNewBookBt = new JButton("Add new book");
            add(addNewBookBt);
        }
    }

    class AddNewBookFrame extends JFrame {

        public void AddNewBookFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Add New Book - My Library");
            Container contentPane = this.getContentPane();

            pack();
        }
    }
   

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Add new book")) {
            new AddNewBookFrame();
        }
    }

}
