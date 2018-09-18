package lib1;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Lib1 {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}

class MainFrame extends JFrame implements ActionListener {

    private JTextField isbnNumText, bookTitleText, authorText, yearText, editionText, categoryText, publisherText, numberOfCopiesText;
    private JTextField SudentNumText, studentTitleText, SudentNameText, SudentSurnameText, cellNumText, addressText;
    private JTextField ReferenceNumText, bookingDateText, isbnNumberText, bookTitleTextBooking,
            studentNumText, studentNameText, returnDateText, studentSurnameTextBooking;

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
        searchBook.addActionListener(this);
        add(addNewBook);
        addNewBook.addActionListener(this);
        add(updateBookInfo);
        updateBookInfo.addActionListener(this);
        add(viewBookInfo);
        viewBookInfo.addActionListener(this);

        add(heading2);
        add(searchStudent);
        searchStudent.addActionListener(this);
        add(viewStudentInfo);
        viewStudentInfo.addActionListener(this);
        add(updateStudentInfo);
        updateStudentInfo.addActionListener(this);
        add(addStudent);
        addStudent.addActionListener(this);

        add(heading3);
        add(searchBooking);
        searchBooking.addActionListener(this);
        add(newBooking);
        newBooking.addActionListener(this);
        add(returnBook);
        returnBook.addActionListener(this);
        add(deleteBooking);
        deleteBooking.addActionListener(this);

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

    class SearchBookFrame extends JFrame {

        private JTable table;
        private JScrollPane scrollPane;

        public SearchBookFrame() {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Search Book - My Library");
            Container contentPane = this.getContentPane();

            SearchBookTitle searchBookTitle = new SearchBookTitle();
            contentPane.add(searchBookTitle, BorderLayout.NORTH);

            SearchBookLabel searchBookLabel = new SearchBookLabel();
            contentPane.add(searchBookLabel, BorderLayout.WEST);

            SearchBookText searchBookText = new SearchBookText();
            contentPane.add(searchBookText, BorderLayout.EAST);

            SearchBookButton searchBookButton = new SearchBookButton();
            contentPane.add(searchBookButton, BorderLayout.SOUTH);
            pack();

        }
    }

    class SearchBookTitle extends JPanel {

        public SearchBookTitle() {
            JLabel message = new JLabel("Search Book");
            add(message);
        }
    }

    class SearchBookLabel extends JPanel {

        public SearchBookLabel() {
            JLabel search = new JLabel("Enter detail:");
            add(search);
        }
    }

    class SearchBookText extends JPanel {

        public SearchBookText() {
            JTextField searchText = new JTextField(20);
            add(searchText);
        }
    }

    class SearchBookButton extends JPanel {

        public SearchBookButton() {
            JButton done = new JButton("Search");
            add(done);
            SerachBookButtonListener serachBookButtonListener = new SerachBookButtonListener();
            done.addActionListener(serachBookButtonListener);
        }

    }

    class dbConnection {

        public void dbConnection() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class SerachBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Search")) {
                searchBook();
            }
        }

        public void searchBook() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
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

            /*JTextField isbnNumText = new JTextField(20);
            JTextField bookTitleText = new JTextField(20);
            JTextField authorText = new JTextField(20);
            JTextField yearText = new JTextField(20);
            JTextField editionText = new JTextField(20);
            JTextField categoryText = new JTextField(20);
            JTextField publisherText = new JTextField(20);
            JTextField numberOfCopiesText = new JTextField(20);*/
            isbnNumText = new JTextField(20);
            bookTitleText = new JTextField(20);
            authorText = new JTextField(20);
            yearText = new JTextField(20);
            editionText = new JTextField(20);
            categoryText = new JTextField(20);
            publisherText = new JTextField(20);
            numberOfCopiesText = new JTextField(20);
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
            AddBookButtonListener addBookButtonListener = new AddBookButtonListener();
            done.addActionListener(addBookButtonListener);
        }
    }

    class AddBookButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                insertBook();
            }
        }

        public void insertBook() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement pst = null;
            try {

                String sql = "Insert into books(ISBNNumber,BookTitle,Author,Year,Edition,Category,Publiser,NumberOfCopiesText)values (?,?,?,?,?,?,?,?)";

                Connection conn = DriverManager.getConnection(url, usrename, password);
                pst = conn.prepareStatement(sql);
                pst.setString(1, isbnNumText.getText());
                pst.setString(2, bookTitleText.getText());
                pst.setString(3, authorText.getText());
                pst.setString(4, yearText.getText());
                pst.setString(5, editionText.getText());
                pst.setString(6, categoryText.getText());
                pst.setString(7, publisherText.getText());
                pst.setString(8, numberOfCopiesText.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Book is saved");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
            }
        }
    }

    class UpdateBookInformationFrame extends JFrame {

        public UpdateBookInformationFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Update Book - My Library");
            Container contentPane = this.getContentPane();

            UpdateBookInfoIntro updateBookInfoIntro = new UpdateBookInfoIntro();
            contentPane.add(updateBookInfoIntro, BorderLayout.NORTH);

            UpdateBookInfoMessage updateBookInfoMessage = new UpdateBookInfoMessage();
            contentPane.add(updateBookInfoMessage, BorderLayout.WEST);

            UpdateBookInfoText updateBookInfoText = new UpdateBookInfoText();
            contentPane.add(updateBookInfoText, BorderLayout.EAST);

            UpdateBookInfoButton updateBookInfoButton = new UpdateBookInfoButton();
            contentPane.add(updateBookInfoButton, BorderLayout.SOUTH);

            pack();

        }
    }

    class UpdateBookInfoIntro extends JPanel {

        public UpdateBookInfoIntro() {
            JLabel message = new JLabel("Update Book Information");
            add(message);
        }
    }

    class UpdateBookInfoMessage extends JPanel {

        public UpdateBookInfoMessage() {
            JLabel instruction = new JLabel("Enter detail of book");
            add(instruction);
        }
    }

    class UpdateBookInfoText extends JPanel {

        public UpdateBookInfoText() {

            JTextField searchBookToUpdateText = new JTextField(20);
            add(searchBookToUpdateText);
        }
    }

    class UpdateBookInfoButton extends JPanel {

        public UpdateBookInfoButton() {
            JButton done = new JButton("DONE");
            add(done);
            UpdateBookInfoButtonListener updateBookInfoButtonListener = new UpdateBookInfoButtonListener();
            done.addActionListener(updateBookInfoButtonListener);
        }
    }

    class UpdateBookInfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                updateBook();
            }
        }

        public void updateBook() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class ViewBookInformationFrame extends JFrame {

        public ViewBookInformationFrame() {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("View Book Information - My Library");
            Container c = this.getContentPane();

            ViewBookInfoLabel viewBookInfoLabel = new ViewBookInfoLabel();
            c.add(viewBookInfoLabel, BorderLayout.NORTH);

            ViewBookInfoMessage viewBookInfoMessage = new ViewBookInfoMessage();
            c.add(viewBookInfoMessage, BorderLayout.WEST);

            ViewBookInfoText viewBookInfoText = new ViewBookInfoText();
            c.add(viewBookInfoText, BorderLayout.EAST);

            ViewBookInfoButton viewBookInfoButton = new ViewBookInfoButton();
            c.add(viewBookInfoButton, BorderLayout.SOUTH);

            pack();

        }
    }

    class ViewBookInfoLabel extends JPanel {

        public ViewBookInfoLabel() {
            JLabel message = new JLabel("View Book Information");
            add(message);

        }
    }

    class ViewBookInfoMessage extends JPanel {

        public ViewBookInfoMessage() {
            JLabel instruction = new JLabel("Enter detail of the book you want to update:");
            add(instruction);
        }
    }

    class ViewBookInfoText extends JPanel {

        public ViewBookInfoText() {
            JTextField searchBookToViewText = new JTextField(20);
            add(searchBookToViewText);
        }
    }

    class ViewBookInfoButton extends JPanel {

        public ViewBookInfoButton() {
            JButton search = new JButton("Search");
            add(search);
            ViewBookInfoButtonListener viewBookInfoButtonListener = new ViewBookInfoButtonListener();
            search.addActionListener(viewBookInfoButtonListener);
        }
    }

    class ViewBookInfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Search")) {
                showMe();
            }
        }

        public void showMe() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }

    }

    class SearchStudentFrame extends JFrame {

        public SearchStudentFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Search Student - My Library");
            Container c = this.getContentPane();

            SearchStudentIntro searchStudentIntro = new SearchStudentIntro();
            c.add(searchStudentIntro, BorderLayout.NORTH);

            SearchStudentLabel searchStudentLabel = new SearchStudentLabel();
            c.add(searchStudentLabel, BorderLayout.WEST);

            SearchStudentText searchStudentText = new SearchStudentText();
            c.add(searchStudentText, BorderLayout.EAST);

            SearchStudentButton searchStudentButton = new SearchStudentButton();
            c.add(searchStudentButton, BorderLayout.SOUTH);

            pack();
        }
    }

    class SearchStudentIntro extends JPanel {

        public SearchStudentIntro() {
            JLabel message = new JLabel("Search Student");
            add(message);
        }
    }

    class SearchStudentLabel extends JPanel {

        public SearchStudentLabel() {
            JLabel search = new JLabel("Enter student number, name or surname:");
            add(search);
        }
    }

    class SearchStudentText extends JPanel {

        public SearchStudentText() {
            JTextField searchText = new JTextField(20);
            add(searchText);

        }
    }

    class SearchStudentButton extends JPanel {

        public SearchStudentButton() {
            JButton done = new JButton("Search");
            add(done);
            SearchStudentButtonListener searchStudentButtonListener = new SearchStudentButtonListener();
            done.addActionListener(searchStudentButtonListener);
        }
    }

    class SearchStudentButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Search")) {
                searchStudent();
            }
        }

        public void searchStudent() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class ViewStudentInfoFrame extends JFrame {

        public ViewStudentInfoFrame() {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("View Student Information - My Library");
            Container c = this.getContentPane();

            ViewStudentMessage viewStudentMessage = new ViewStudentMessage();
            c.add(viewStudentMessage, BorderLayout.NORTH);

            ViewStudentLabel viewStudentLabel = new ViewStudentLabel();
            c.add(viewStudentLabel, BorderLayout.WEST);

            ViewStudentText ViewStudentText = new ViewStudentText();
            c.add(ViewStudentText, BorderLayout.EAST);

            ViewStudentButton viewStudentButton = new ViewStudentButton();
            c.add(viewStudentButton, BorderLayout.SOUTH);

            pack();
        }
    }

    class ViewStudentMessage extends JPanel {

        public ViewStudentMessage() {
            JLabel message = new JLabel("View Student Information: ");
            add(message);
        }
    }

    class ViewStudentLabel extends JPanel {

        public ViewStudentLabel() {
            JLabel instruction = new JLabel("Enter student number:");
            add(instruction);
        }
    }

    class ViewStudentText extends JPanel {

        public ViewStudentText() {
            JTextField searchBookToViewText = new JTextField(20);
            add(searchBookToViewText);
        }
    }

    class ViewStudentButton extends JPanel {

        public ViewStudentButton() {
            JButton search = new JButton("Search");
            add(search);
            ViewStudentButtonListener viewStudentButtonListener = new ViewStudentButtonListener();
            search.addActionListener(viewStudentButtonListener);
        }
    }

    class ViewStudentButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Search")) {
                searchStudent();
            }
        }

        public void searchStudent() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }

    }

    class UpdateStudentInformationFrame extends JFrame {

        public UpdateStudentInformationFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Update Student Information - My Library");
            Container c = this.getContentPane();

            UpdateStudentInfoIntro updateStudentInfoIntro = new UpdateStudentInfoIntro();
            c.add(updateStudentInfoIntro, BorderLayout.NORTH);

            UpdateStudentInfoMessage updateStudentInfoMessage = new UpdateStudentInfoMessage();
            c.add(updateStudentInfoMessage, BorderLayout.WEST);

            UpdateStudentInfoText UpdateStudentInfoText = new UpdateStudentInfoText();
            c.add(UpdateStudentInfoText, BorderLayout.EAST);

            UpdateStudentInfoButton updateStudentInfoButton = new UpdateStudentInfoButton();
            c.add(updateStudentInfoButton, BorderLayout.SOUTH);

            pack();
        }
    }

    class UpdateStudentInfoIntro extends JPanel {

        public UpdateStudentInfoIntro() {

            JLabel intro = new JLabel("Update Student Information");
            add(intro);
        }
    }

    class UpdateStudentInfoMessage extends JPanel {

        public UpdateStudentInfoMessage() {
            JLabel message = new JLabel("Enter student detail");
            add(message);
        }
    }

    class UpdateStudentInfoText extends JPanel {

        public UpdateStudentInfoText() {
            JTextField UpdateStudentInfoText = new JTextField(20);
            add(UpdateStudentInfoText);
        }
    }

    class UpdateStudentInfoButton extends JPanel {

        public UpdateStudentInfoButton() {
            JButton done = new JButton("DONE");
            add(done);
            UpdateStudentInfoButtonListener updateStudentInfoButtonListener = new UpdateStudentInfoButtonListener();
            done.addActionListener(updateStudentInfoButtonListener);
        }
    }

    class UpdateStudentInfoButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                updateStudent();
            }
        }

        public void updateStudent() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class AddStudentFrame extends JFrame {

        public AddStudentFrame() {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Add New Student - My Library");
            Container c = this.getContentPane();

            AddStudentIntro addStudentIntro = new AddStudentIntro();
            c.add(addStudentIntro, BorderLayout.NORTH);

            AddStudentLabel addStudentLabel = new AddStudentLabel();
            c.add(addStudentLabel, BorderLayout.WEST);

            AddStudentText addStudentText = new AddStudentText();
            c.add(addStudentText, BorderLayout.EAST);

            AddStudentButton addStudentButton = new AddStudentButton();
            c.add(addStudentButton, BorderLayout.SOUTH);
            pack();
        }
    }

    class AddStudentIntro extends JPanel {

        public AddStudentIntro() {
            JLabel message = new JLabel("Add New Student");
            add(message);
        }
    }

    class AddStudentLabel extends JPanel {

        public AddStudentLabel() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(6);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            JLabel studentNum = new JLabel("Student Number:      ");
            JLabel studentTitle = new JLabel("Title:    ");
            JLabel studentName = new JLabel("Full Name:     ");
            JLabel studentSurname = new JLabel("Surname:     ");
            JLabel cellNum = new JLabel("Cell Number:     ");
            JLabel address = new JLabel("Address:     ");

            add(studentNum);
            add(studentTitle);
            add(studentName);
            add(studentSurname);
            add(cellNum);
            add(address);
        }
    }

    class AddStudentText extends JPanel {

        public AddStudentText() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(6);
            gridLayout.setColumns(2);
            this.setLayout(gridLayout);

            SudentNumText = new JTextField(20);
            studentTitleText = new JTextField(20);
            SudentNameText = new JTextField(20);
            SudentSurnameText = new JTextField(20);
            cellNumText = new JTextField(20);
            addressText = new JTextField(20);

            add(SudentNumText);
            add(studentTitleText);
            add(SudentNameText);
            add(SudentSurnameText);
            add(cellNumText);
            add(addressText);
        }
    }

    class AddStudentButton extends JPanel {

        public AddStudentButton() {
            JButton done = new JButton("DONE");
            add(done);
            AddStudentButtonListenr addStudentButtonListenr = new AddStudentButtonListenr();
            done.addActionListener(addStudentButtonListenr);
        }
    }

    class AddStudentButtonListenr implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                insertStudent();
            }
        }

        public void insertStudent() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement pst = null;
            try {
                String sql = "Insert into student (StudentNumber, Title, StudentName, StudentSurname, CellNumber, Address) values (?,?,?,?,?,?)";
                Connection conn = DriverManager.getConnection(url, usrename, password);
                pst = conn.prepareStatement(sql);
                pst.setString(1, SudentNumText.getText());
                pst.setString(2, studentTitleText.getText());
                pst.setString(3, SudentNameText.getText());
                pst.setString(4, SudentSurnameText.getText());
                pst.setString(5, cellNumText.getText());
                pst.setString(6, addressText.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Saved");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something is wrong" + e);
            }
        }
    }

    class SearchBookingFrame extends JFrame {

        public SearchBookingFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Search Booking - My Library");
            Container c = this.getContentPane();

            SearchBookingIntro searchBookingIntro = new SearchBookingIntro();
            c.add(searchBookingIntro, BorderLayout.NORTH);

            SearchBookingLabel searchBookingLabel = new SearchBookingLabel();
            c.add(searchBookingLabel, BorderLayout.WEST);

            SearchBookingText searchBookingText = new SearchBookingText();
            c.add(searchBookingText, BorderLayout.EAST);

            SearchBookingButton searchBookingButton = new SearchBookingButton();
            c.add(searchBookingButton, BorderLayout.SOUTH);

            pack();

        }
    }

    class SearchBookingIntro extends JPanel {

        public SearchBookingIntro() {
            JLabel intro = new JLabel("Serach Booking ");
            add(intro);
        }
    }

    class SearchBookingLabel extends JPanel {

        public SearchBookingLabel() {
            JLabel message = new JLabel("Enter booking detail: ");
            add(message);
        }
    }

    class SearchBookingText extends JPanel {

        public SearchBookingText() {
            JTextField searchingBox = new JTextField(20);
            add(searchingBox);
        }
    }

    class SearchBookingButton extends JPanel {

        public SearchBookingButton() {
            JButton search = new JButton("Search");
            add(search);
            SearchBookingButtonListener searchBookingButtonListener = new SearchBookingButtonListener();
            search.addActionListener(searchBookingButtonListener);
        }
    }

    class SearchBookingButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Search")) {
                searchBooking();
            }
        }

        public void searchBooking() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class NewBookingFrame extends JFrame {

        public NewBookingFrame() {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setTitle("New Booking - My Library");
            setVisible(true);
            Container c = this.getContentPane();

            AddBookingIntro addBookingIntro = new AddBookingIntro();
            c.add(addBookingIntro, BorderLayout.NORTH);

            AddBookingLabel addBookingLabel = new AddBookingLabel();
            c.add(addBookingLabel, BorderLayout.WEST);

            AddBookingText addBookingText = new AddBookingText();
            c.add(addBookingText, BorderLayout.EAST);

            AddBookingButton addBookingButton = new AddBookingButton();
            c.add(addBookingButton, BorderLayout.SOUTH);

            pack();
        }
    }

    class AddBookingIntro extends JPanel {

        public AddBookingIntro() {

            JLabel message = new JLabel("New Booking:");
            add(message);
        }
    }

    class AddBookingLabel extends JPanel {

        public AddBookingLabel() {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(2);
            this.setLayout(gridLayout);

            JLabel bookingDate = new JLabel("Booking date:     ");
            JLabel isbnNumber = new JLabel("ISBN Number:   ");
            JLabel studentNum = new JLabel("Student Number:   ");
            JLabel bookTitle = new JLabel("Book Title:   ");
            JLabel ReferenceNum = new JLabel("Reference Number:      ");
            JLabel studentName = new JLabel("Student Name:   ");
            JLabel studentSurname = new JLabel("Student Surname:   ");
            JLabel returnDate = new JLabel("Return Date:   ");

            add(bookingDate);
            add(ReferenceNum);
            add(isbnNumber);
            add(bookTitle);
            add(studentName);
            add(studentSurname);
            add(studentNum);
            add(returnDate);
        }
    }

    class AddBookingText extends JPanel {

        public AddBookingText() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(2);
            this.setLayout(gridLayout);

            ReferenceNumText = new JTextField(20);
            bookingDateText = new JTextField(20);
            isbnNumberText = new JTextField(20);
            bookTitleTextBooking = new JTextField(20);
            studentNumText = new JTextField(20);
            studentNameText = new JTextField(20);
            studentSurnameTextBooking = new JTextField(20);
            returnDateText = new JTextField(20);

            add(bookingDateText);
            add(ReferenceNumText);
            add(isbnNumberText);
            add(bookTitleTextBooking);
            add(studentNameText);
            add(studentSurnameTextBooking);
            add(studentNumText);
            add(returnDateText);

        }
    }

    class AddBookingButton extends JPanel {

        public AddBookingButton() {
            JButton doneNewBooking = new JButton("DONE");
            add(doneNewBooking);
            AddBookingButtonListener addBookingButtonListener = new AddBookingButtonListener();
            doneNewBooking.addActionListener(addBookingButtonListener);
        }
    }

    class AddBookingButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                booking();
            }
        }

        public void booking() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement pst = null;
            try {
                String sql = "Insert into bookings(ReferenceNumber, BookingDate, ISBNNumber, BookTitle, StudentName, StudentSurname, StudentNumber, ReturnDate) values (?,?,?,?,?,?,?,?)";
                Connection conn = DriverManager.getConnection(url, usrename, password);
                pst = conn.prepareStatement(sql);
                pst.setString(1, ReferenceNumText.getText());
                pst.setString(2, bookingDateText.getText());
                pst.setString(3, isbnNumberText.getText());
                pst.setString(4, bookTitleTextBooking.getText());
                pst.setString(5, studentNameText.getText());
                pst.setString(6, studentSurnameTextBooking.getText());
                pst.setString(7, studentNumText.getText());
                pst.setString(8, returnDateText.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Saved");

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class ReturnBookFrame extends JFrame {

        public ReturnBookFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setTitle("Return Booking - My Library");
            setVisible(true);
            Container c = this.getContentPane();

            ReturnBookingIntro returnBookingIntro = new ReturnBookingIntro();
            c.add(returnBookingIntro, BorderLayout.NORTH);

            ReturnBookingLabels returnBookingLabels = new ReturnBookingLabels();
            c.add(returnBookingLabels, BorderLayout.WEST);

            ReturnBookingText returnBookingText = new ReturnBookingText();
            c.add(returnBookingText, BorderLayout.EAST);

            ReturnBookingButton returnBookingButton = new ReturnBookingButton();
            c.add(returnBookingButton, BorderLayout.SOUTH);
            pack();

        }
    }

    class ReturnBookingIntro extends JPanel {

        public ReturnBookingIntro() {
            JLabel message = new JLabel("Return Book:");
            add(message);
        }
    }

    class ReturnBookingLabels extends JPanel {

        public ReturnBookingLabels() {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(2);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            JLabel isbnNum = new JLabel("ISBN number:    ");
            JLabel bookTitle = new JLabel("Titler:    ");
            add(isbnNum);
            add(bookTitle);
        }
    }

    class ReturnBookingText extends JPanel {

        public ReturnBookingText() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(2);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            JTextField isbnNumText = new JTextField(20);
            JTextField bookTitleText = new JTextField(20);

            add(isbnNumText);
            add(bookTitleText);
        }
    }

    class ReturnBookingButton extends JPanel {

        public ReturnBookingButton() {
            JButton done = new JButton("DONE");
            add(done);
            ReturnBookingButtonListener returnBookingButtonListener = new ReturnBookingButtonListener();
            done.addActionListener(returnBookingButtonListener);
        }
    }

    class ReturnBookingButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DONE")) {
                returnBook();
            }
        }

        public void returnBook() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    class DeleteBookingFrame extends JFrame {

        public DeleteBookingFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Delete Booking - My Library");
            Container c = this.getContentPane();

            DeleteBookingIntro deleteBookingIntro = new DeleteBookingIntro();
            c.add(deleteBookingIntro, BorderLayout.NORTH);
            DeleteBookingLabels deleteBookingLabels = new DeleteBookingLabels();
            c.add(deleteBookingLabels, BorderLayout.WEST);
            DeleteBookingText deleteBookingText = new DeleteBookingText();
            c.add(deleteBookingText, BorderLayout.EAST);
            DeleteBookingButton deleteBookingButton = new DeleteBookingButton();
            c.add(deleteBookingButton, BorderLayout.SOUTH);

            pack();
        }
    }

    class DeleteBookingIntro extends JPanel {

        public DeleteBookingIntro() {
            JLabel intro = new JLabel("Delete Booking");
            add(intro);
        }
    }

    class DeleteBookingLabels extends JPanel {

        public DeleteBookingLabels() {
            JLabel refNum = new JLabel("REference Numbebr: ");
            add(refNum);
        }
    }

    class DeleteBookingText extends JPanel {

        public DeleteBookingText() {
            JTextField refNumText = new JTextField(20);
            add(refNumText);
        }
    }

    class DeleteBookingButton extends JPanel {

        public DeleteBookingButton() {
            JButton deleteBooking = new JButton("DELETE");
            add(deleteBooking);
            DeleteBookingButtonListener deleteBookingButtonListener = new DeleteBookingButtonListener();
            deleteBooking.addActionListener(deleteBookingButtonListener);
        }
    }

    class DeleteBookingButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("DELETE")) {
                deleteBooking();
            }
        }

        public void deleteBooking() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("ISBNNumber") + " "
                            + rs.getString("BookTitle") + " "
                            + rs.getString("Author") + " "
                            + rs.getString("Year") + " "
                            + rs.getString("Edition")
                            + rs.getString("Category") + " "
                            + rs.getString("Publiser"));
                }
                conn.close();

            } catch (Exception e) {
                System.out.println("OOPS");
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Search Book")) {
            new SearchBookFrame();
        }

        if (evt.getActionCommand().equals("Add New Book")) {
            new AddNewBookFrame();
        }

        if (evt.getActionCommand().equals("Update Book Information")) {
            new UpdateBookInformationFrame();
        }

        if (evt.getActionCommand().equals("View Book Information")) {
            new ViewBookInformationFrame();
        }

        if (evt.getActionCommand().equals("Search Student")) {
            new SearchStudentFrame();
        }

        if (evt.getActionCommand().equals("View Student Information")) {
            new ViewStudentInfoFrame();
        }
        if (evt.getActionCommand().equals("Update Student Information")) {
            new UpdateStudentInformationFrame();
        }
        if (evt.getActionCommand().equals("Add New Student")) {
            new AddStudentFrame();
        }
        if (evt.getActionCommand().equals("Search Booking")) {
            new SearchBookingFrame();
        }

        if (evt.getActionCommand().equals("New Booking")) {
            new NewBookingFrame();
        }

        if (evt.getActionCommand().equals("Return Book")) {
            new ReturnBookFrame();
        }
        if (evt.getActionCommand().equals("Delete Booking")) {
            new DeleteBookingFrame();
        }
    }
}
