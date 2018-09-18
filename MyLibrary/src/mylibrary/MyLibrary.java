package mylibrary;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyLibrary {

    public static void main(String[] args) {

        FirstFarame ff = new FirstFarame();
        ff.setVisible(true);
        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ff.setSize(400, 300);

    }
}

class FirstFarame extends JFrame {

    private JLabel intro;
    private JButton newBooking;
    private JButton updateStudentInfo;
    private JButton updateBookInfo;
    private JButton addStudent;
    private JButton viewStudentInfo;
    private JButton returnBook;
    private JButton addNewBook;
    private JButton viewBookInfo;

    public FirstFarame() {
        setTitle("My Library");
        Container contentPane = this.getContentPane();

        IntroPanel introPanel = new IntroPanel();
        contentPane.add(introPanel, BorderLayout.NORTH);

        Buttons buttons = new Buttons();
        contentPane.add(buttons, BorderLayout.SOUTH);

        IntroMessage introMessage = new IntroMessage();
        contentPane.add(introMessage, BorderLayout.CENTER);

        pack();
    }

    class IntroPanel extends JPanel {

        public IntroPanel() {

            intro = new JLabel("WELCOME !");
            add(intro);

        }
    }

    class IntroMessage extends JPanel {

        public IntroMessage() {

            JLabel message = new JLabel("Please select action below: ");
            add(message);
        }

    }

    class Buttons extends JFrame implements ActionListener {

        public Buttons() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);

            JPanel p = new JPanel();
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            newBooking = new JButton("New Booking");
            addStudent = new JButton("Add Student");
            viewStudentInfo = new JButton("View Student Information");
            returnBook = new JButton("Reurn Book");
            addNewBook = new JButton("Add New Book");
            viewBookInfo = new JButton("View Book Information");
            updateStudentInfo = new JButton("Update Student Information");
            updateBookInfo = new JButton("Update Book Information");

            p.add(newBooking);
            newBooking.addActionListener(this);
            p.add(returnBook);
            p.add(addStudent);
            p.add(updateStudentInfo);
            p.add(viewStudentInfo);
            p.add(addNewBook);
            p.add(updateBookInfo);
            p.add(viewBookInfo);
            p.add(p);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("newBooking")) {

            }
        }
    }

}
