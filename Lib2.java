package lib2;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Lib2 {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}

class MainFrame extends JFrame  {

    private JButton searchBook;
    private JButton addNewBook;
    private JButton updateBookInfo;
    private JButton viewBookInfo;

    private JButton searchStudent;
    private JButton viewStudentInfo;
    private JButton updateStudentInfo;
    private JButton addStudent;

    private JButton searchBooking;
    private JButton newBooking;
    private JButton returnBook;
    private JButton deleteBooking;

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("My Library");
        Container contentPane = this.getContentPane();

        IntroPanel introPanel = new IntroPanel();
        contentPane.add(introPanel);

        IntroMessage introMessage = new IntroMessage();
        contentPane.add(introMessage);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(17);
        gridLayout.setColumns(1);
        this.setLayout(gridLayout);

        JLabel heading1 = new JLabel("   Books:    ");
        JLabel heading2 = new JLabel("   Students:     ");
        JLabel heading3 = new JLabel("   Booking:      ");
        searchBook = new JButton("Search Book");
        searchStudent = new JButton("Search Student");
        searchBooking = new JButton("Search Booking");
        newBooking = new JButton("New Booking");
        addStudent = new JButton("Add New Student");
        viewStudentInfo = new JButton("View Student Information");
        returnBook = new JButton("Return Book");
        addNewBook = new JButton("Add New Book");
        viewBookInfo = new JButton("View Book Information");
        updateStudentInfo = new JButton("Update Student Information");
        updateBookInfo = new JButton("Update Book Information");
        deleteBooking = new JButton("Delete Booking");

        add(heading1);
        add(searchBook);
       // searchBook.addActionListener(this);
        add(addNewBook);
        //addNewBook.addActionListener(this);
        add(updateBookInfo);
        //updateBookInfo.addActionListener(this);
        add(viewBookInfo);
        //viewBookInfo.addActionListener(this);

        add(heading2);
        add(searchStudent);
        //searchStudent.addActionListener(this);
        add(viewStudentInfo);
        //viewStudentInfo.addActionListener(this);
        add(updateStudentInfo);
        //updateStudentInfo.addActionListener(this);
        add(addStudent);
        //addStudent.addActionListener(this);

        add(heading3);
        add(searchBooking);
        //searchBooking.addActionListener(this);
        add(newBooking);
        //newBooking.addActionListener(this);
        add(returnBook);
        //returnBook.addActionListener(this);
        add(deleteBooking);
       // deleteBooking.addActionListener(this);

        //pack();
    }

    class IntroPanel extends JPanel {

        public IntroPanel() {

            JLabel intro = new JLabel("        WELCOME !       ");
            add(intro);
        }
    }

    class IntroMessage extends JPanel {

        public IntroMessage() {

            JLabel message = new JLabel("Please select action below: ");
            add(message);
        }

    }

    class AddNewBookFrame extends JFrame {

        public AddNewBookFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Add New Book - My Library");
            setSize(500, 500);

            Container contentPane = this.getContentPane();

            AddBookTitle title = new AddBookTitle();
            contentPane.add(title, BorderLayout.NORTH);

            AddBookLabels addBookLabels = new AddBookLabels();
            contentPane.add(addBookLabels, BorderLayout.WEST);

            AddBookText addBookText = new AddBookText();
            contentPane.add(addBookText, BorderLayout.EAST);

            AddBookButton addBookButton = new AddBookButton();
            contentPane.add(addBookButton, BorderLayout.SOUTH);

            pack();

        }

    }

    class AddBookTitle extends JPanel {

        public AddBookTitle() {
            JLabel message = new JLabel("Add New Book");
            add(message);
        }
    }

    class AddBookLabels extends JPanel {

        public AddBookLabels() {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            JLabel isbnNum = new JLabel("ISBN Number:");
            JLabel bookTitle = new JLabel("Book Title:");
            JLabel author = new JLabel("Author:");
            JLabel year = new JLabel("Published Year:");
            JLabel edition = new JLabel("Edition:");
            JLabel category = new JLabel("Category:");
            JLabel publisher = new JLabel("Publisher:");
            JLabel numberOfCopies = new JLabel("Number of copies:  ");

            add(isbnNum);
            add(bookTitle);
            add(author);
            add(year);
            add(edition);
            add(category);
            add(publisher);
            add(numberOfCopies);
        }

    }

    class AddBookText extends JPanel {

        public AddBookText() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            JTextField isbnNumText = new JTextField(20);
            JTextField bookTitleText = new JTextField(20);
            JTextField authorText = new JTextField(20);
            JTextField yearText = new JTextField(20);
            JTextField editionText = new JTextField(20);
            JTextField categoryText = new JTextField(20);
            JTextField publisherText = new JTextField(20);
            JTextField numberOfCopiesText = new JTextField(20);

            add(isbnNumText);
            add(bookTitleText);
            add(authorText);
            add(yearText);
            add(editionText);
            add(categoryText);
            add(publisherText);
            add(numberOfCopiesText);
        }
    }

    class AddBookButton extends JPanel {

        public AddBookButton() {
            JButton done = new JButton("DONE");
            add(done);
             AddBookButtonListener  AddBookButtonListener = new AddBookButtonListener ();
            done.addActionListener(AddBookButtonListener);
           
           
        }

    }

    class AddBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            if (evt.getActionCommand().equals("Add New Book")) {
                display();
            }
        }

        public void display() {
            try {
                String filename = "jdbc:ucanaccess://C://Users//andre//Desktop//MyDB.accdb";
                Connection conn = DriverManager.getConnection(filename);
                Statement s = conn.createStatement();
                String query = "SELECT * FROM Book";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("ISBNNumber")
                            + " " + rs.getString("BookTitle")
                            + " " + rs.getString("Author")
                            + " " + rs.getString("Year"));
                }
            } catch (SQLException exp) {
                System.out.println("Something's wrong!");
                exp.printStackTrace();
            }
        }
    }
}
