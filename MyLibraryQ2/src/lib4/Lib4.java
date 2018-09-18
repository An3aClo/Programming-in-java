package lib4;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Lib4 {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
    }
}

class MainFrame extends JFrame implements ActionListener {

    private JTextField isbnNumText, bookTitleText, authorText, yearText, editionText, categoryText, publisherText,
            numberOfCopiesText;
    private JTextField SudentNumText, studentTitleText, SudentNameText, SudentSurnameText, cellNumText, addressText;
    private JTextField ReferenceNumText, bookingDateText, isbnNumberText, bookTitleTextBooking,
            studentNumText, studentNameText, returnDateText, studentSurnameTextBooking;
    private JTextField searchText, searchTextStudent, searchingBox, deleteText;
    private JTextField SudentNumTextUpdate, studentTitleTextUpdate, SudentNameTextUpdate, SudentSurnameTextUpdate,
            cellNumTextUpdate, addressTextUpdate;
    private JTextField isbnNumTextUpgarde, bookTitleTextUpgarde, authorTextUpgarde, yearTextUpgarde, editionTextUpgarde,
            categoryTextUpgarde, publisherTextUpgarde, numberOfCopiesTextUpgarde;
    private final JButton searchBook;
    private final JButton addNewBook;
    private final JButton updateBookInfo;
    private final JButton viewBookInfo;
    private final JButton searchStudent;
    private final JButton viewStudentInfo;
    private final JButton updateStudentInfo;
    private final JButton addStudent;
    private final JButton searchBooking;
    private final JButton viewAllBookings;
    private final JButton newBooking;
    private final JButton deleteBooking;
    private JTable table;
    private JScrollPane scrollPane;
    JButton done;

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
        addNewBook = new JButton("Add New Book");
        viewBookInfo = new JButton("View Book Information");
        updateStudentInfo = new JButton("Update Student Information");
        updateBookInfo = new JButton("Update Book Information");
        deleteBooking = new JButton("Delete Booking");
        viewAllBookings = new JButton("View All Bookings");

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
        add(viewAllBookings);
        viewAllBookings.addActionListener(this);
        add(newBooking);
        newBooking.addActionListener(this);
        add(deleteBooking);
        deleteBooking.addActionListener(this);
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

            SearchBookText searchBookText = new SearchBookText();
            contentPane.add(searchBookText);

            SearcgBookTable searcgBookTable = new SearcgBookTable();
            contentPane.add(searcgBookTable, BorderLayout.PAGE_END);
            pack();

        }
    }

    class SearchBookTitle extends JPanel {

        public SearchBookTitle() {
            JLabel message = new JLabel("Search Book");
            add(message);
        }
    }

    class SearchBookText extends JPanel {

        public SearchBookText() {

            JLabel search = new JLabel("Enter ISBN number:");
            done = new JButton("Search Book");
            searchText = new JTextField(20);
            dbSearch dbSearch = new dbSearch();
            done.addActionListener(dbSearch);
            add(search);
            add(searchText);
            add(done);
        }
    }

    class SearcgBookTable extends JPanel {

        public SearcgBookTable() {
            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
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
                s.execute(driver);
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                conn.close();

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
               JOptionPane.showMessageDialog(null,"Something is wrong: "+ e);
            }
        }
    }

    class dbSearch implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {

            int num = 0;
            if (evt.getActionCommand().equals("Search Book")) {
                num = 1;
            }
            if (evt.getActionCommand().equals("Search Student")) {
                num = 2;
            }
            if (evt.getActionCommand().equals("Search Booking")) {
                num = 3;
            }
            switch (num) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    searchBooking();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please select correct search option");
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
                String query = "select * from books where (ISBNNumber = '" + searchText.getText() + "');";

                ResultSet rs = s.executeQuery(query);

                DefaultTableModel tableModel = new DefaultTableModel();
                ResultSetMetaData metaData = rs.getMetaData();

                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnLabel(i));
                }

                Object[] row = new Object[columnCount];

                while (rs.next()) {
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(row);
                }

                table.setModel(tableModel);
                rs.close();
                s.close();
                conn.close();
               

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
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
                String query = "select * from student where (StudentNumber = '" + searchTextStudent.getText() + "');";
                ResultSet rs = s.executeQuery(query);

                DefaultTableModel tableModel = new DefaultTableModel();
                ResultSetMetaData metaData = rs.getMetaData();

                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnLabel(i));
                }

                Object[] row = new Object[columnCount];

                while (rs.next()) {
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(row);
                }

                table.setModel(tableModel);
                rs.close();
                s.close();
                conn.close();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
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
                String query = "select * from bookings where (ReferenceNumber = '" + searchingBox.getText() + "');";
                ResultSet rs = s.executeQuery(query);

                DefaultTableModel tableModel = new DefaultTableModel();
                ResultSetMetaData metaData = rs.getMetaData();

                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnLabel(i));
                }

                Object[] row = new Object[columnCount];

                while (rs.next()) {
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(row);
                }

                table.setModel(tableModel);
                rs.close();
                s.close();
                conn.close();

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
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
            JButton done = new JButton("Save Book");
            add(done);
            dbInsert dbInsert = new dbInsert();
            done.addActionListener(dbInsert);
        }
    }

    class dbInsert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Save Book")) {
                insertBook();
            }
            if (evt.getActionCommand().equals("Save Student")) {
                insertStudent();
            }
        }

        public void insertBook() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement pst ;
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

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
            }
        }

        public void insertStudent() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";
            PreparedStatement pst;
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
                JOptionPane.showMessageDialog(null, "Student is inserted");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something is wrong "+e);
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

    class UpdateBookInfoText extends JPanel {

        public UpdateBookInfoText() {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(8);
            gridLayout.setColumns(1);
            this.setLayout(gridLayout);

            isbnNumTextUpgarde = new JTextField(20);
            bookTitleTextUpgarde = new JTextField(20);
            authorTextUpgarde = new JTextField(20);
            yearTextUpgarde = new JTextField(20);
            editionTextUpgarde = new JTextField(20);
            categoryTextUpgarde = new JTextField(20);
            publisherTextUpgarde = new JTextField(20);
            numberOfCopiesTextUpgarde = new JTextField(20);
            add(isbnNumTextUpgarde);
            add(bookTitleTextUpgarde);
            add(authorTextUpgarde);
            add(yearTextUpgarde);
            add(editionTextUpgarde);
            add(categoryTextUpgarde);
            add(publisherTextUpgarde);
            add(numberOfCopiesTextUpgarde);
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

        @Override
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

                String query = "UPDATE books SET BookTitle =  '" + bookTitleTextUpgarde.getText()
                        + "',Author='" + authorTextUpgarde.getText()
                        + "',Year='" + yearTextUpgarde.getText()
                        + "',Edition='" + editionTextUpgarde.getText()
                        + "',Category='" + categoryTextUpgarde.getText()
                        + "', Publiser='" + publisherTextUpgarde.getText()
                        + "',NumberOfCopiesText='" + numberOfCopiesTextUpgarde.getText()
                        + "'Where ISBNNumber =  '" + isbnNumTextUpgarde.getText() + "';";
                s.execute(query);
                conn.close();
                JOptionPane.showMessageDialog(null, "Book is updated");

            } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                 JOptionPane.showMessageDialog(null, "Something is wrong "+e);
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
            ViewBookInfoText viewBookInfoText = new ViewBookInfoText();
            c.add(viewBookInfoText, BorderLayout.CENTER);
            pack();
        }
    }

    class ViewBookInfoLabel extends JPanel {

        public ViewBookInfoLabel() {
            JLabel message = new JLabel("View Book Information");
            add(message);

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

            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnLabel(i));
            }
            Object[] row = new Object[columnCount];

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);
            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Something is wrong "+e);
        }
    }

    class ViewBookInfoText extends JPanel {

        public ViewBookInfoText() {

            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
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

            SearchStudentTable searchStudentTable = new SearchStudentTable();
            c.add(searchStudentTable, BorderLayout.SOUTH);

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
            JLabel search = new JLabel("Enter student number: ");
            add(search);
        }
    }

    class SearchStudentText extends JPanel {

        public SearchStudentText() {
            searchTextStudent = new JTextField(20);
            add(searchTextStudent);
            JButton done = new JButton("Search Student");
            add(done);

            dbSearch dbSearch = new dbSearch();
            done.addActionListener(dbSearch);

        }
    }

    class SearchStudentTable extends JPanel {

        public SearchStudentTable() {
            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
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
            c.add(viewStudentLabel, BorderLayout.CENTER);

            pack();
        }
    }

    public void viewStudent() {
        String url = "jdbc:mysql://localhost:3306/student";
        String usrename = "root";
        String password = "root";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, usrename, password);
            Statement s = conn.createStatement();
            String query = "Select * FROM student";
            ResultSet rs = s.executeQuery(query);
            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnLabel(i));
            }
            Object[] row = new Object[columnCount];

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);

            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Something is wrong "+e);
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
            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
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

    class UpdateStudentInfoText extends JPanel {

        public UpdateStudentInfoText() {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(6);
            gridLayout.setColumns(2);
            this.setLayout(gridLayout);

            SudentNumTextUpdate = new JTextField(20);
            studentTitleTextUpdate = new JTextField(20);
            SudentNameTextUpdate = new JTextField(20);
            SudentSurnameTextUpdate = new JTextField(20);
            cellNumTextUpdate = new JTextField(20);
            addressTextUpdate = new JTextField(20);

            add(SudentNumTextUpdate);
            add(studentTitleTextUpdate);
            add(SudentNameTextUpdate);
            add(SudentSurnameTextUpdate);
            add(cellNumTextUpdate);
            add(addressTextUpdate);
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
                String query = "UPDATE student SET StudentName =  '" + SudentNameTextUpdate.getText()
                        + "',Title='" + studentTitleTextUpdate.getText()
                        + "',StudentSurname='" + SudentSurnameTextUpdate.getText()
                        + "',CellNumber='" + cellNumTextUpdate.getText()
                        + "',Address='" + addressTextUpdate.getText()
                        + "'Where StudentNumber =  '" + SudentNumTextUpdate.getText() + "';";
                s.execute(query);
                s.close();
                conn.close();
                JOptionPane.showMessageDialog(null, "Student is updated");
            } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                 JOptionPane.showMessageDialog(null, "Something is wrong "+e);
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
            JButton done = new JButton("Save Student");
            add(done);
            dbInsert dbInsert = new dbInsert();
            done.addActionListener(dbInsert);
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

            SearchBookingTable searchBookingTable = new SearchBookingTable();
            c.add(searchBookingTable, BorderLayout.SOUTH);

            pack();

        }
    }

    class SearchBookingIntro extends JPanel {

        public SearchBookingIntro() {
            JLabel intro = new JLabel("Search Booking ");
            add(intro);
        }
    }

    class SearchBookingLabel extends JPanel {

        public SearchBookingLabel() {
            JLabel message = new JLabel("Enter booking reference number: ");
            add(message);
            searchingBox = new JTextField(20);
            add(searchingBox);
            JButton search = new JButton("Search Booking");
            add(search);
            dbSearch dbSearch = new dbSearch();
            search.addActionListener(dbSearch);
        }
    }

    class SearchBookingTable extends JPanel {

        public SearchBookingTable() {
            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
        }
    }

    class ViewAllBookings extends JFrame {

        public ViewAllBookings() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setTitle("View Bookings - My Library");
            setVisible(true);
            Container c = this.getContentPane();
            ViewBookingsLabel viewBookings = new ViewBookingsLabel();
            c.add(viewBookings, BorderLayout.NORTH);
            ViewBookingTable viewBookingTable = new ViewBookingTable();
            c.add(viewBookingTable, BorderLayout.CENTER);
            pack();
        }
    }

    class ViewBookingsLabel extends JPanel {

        public ViewBookingsLabel() {

            JLabel message = new JLabel("View Booking:");
            add(message);

        }
    }

    class ViewBookingTable extends JPanel {

        public ViewBookingTable() {
            table = new JTable();
            scrollPane = new JScrollPane(table);
            add(scrollPane);
        }
    }

    public void viewAll() {
        String url = "jdbc:mysql://localhost:3306/student";
        String usrename = "root";
        String password = "root";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, usrename, password);
            Statement s = conn.createStatement();
            String query = "Select * FROM bookings";
            ResultSet rs = s.executeQuery(query);

            DefaultTableModel tableModel = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnLabel(i));
            }
            Object[] row = new Object[columnCount];

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            table.setModel(tableModel);
            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
             JOptionPane.showMessageDialog(null, "Something is wrong "+e);
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

        @Override
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
            PreparedStatement pst;
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
                JOptionPane.showMessageDialog(null, "Booking is saved");

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong" + e);
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

            deleteText = new JTextField(20);
            add(deleteText);
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

        @Override
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
                String query = "DELETE FROM student.bookings WHERE ReferenceNumber='" + deleteText.getText() + "';";
                s.execute(query);
                conn.close();
                JOptionPane.showMessageDialog(null, "Booking is deleted");

            } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                 JOptionPane.showMessageDialog(null, "Something is wrong "+e);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Search Book":
                new SearchBookFrame();
                break;
            case "Add New Book":
                new AddNewBookFrame();
                break;
            case "Update Book Information":
                new UpdateBookInformationFrame();
                break;
            case "View Book Information":
                new ViewBookInformationFrame();
                showMe();
                break;
            case "Search Student":
                new SearchStudentFrame();
                break;
            case "View Student Information":
                new ViewStudentInfoFrame();
                viewStudent();
                break;
            case "Update Student Information":
                new UpdateStudentInformationFrame();
                break;
            case "Add New Student":
                new AddStudentFrame();
                break;
            case "Search Booking":
                new SearchBookingFrame();
                break;
            case "View All Bookings":
                new ViewAllBookings();
                viewAll();
                break;
            case "New Booking":
                new NewBookingFrame();
                break;
            case "Delete Booking":
                new DeleteBookingFrame();
                break;
            default:
                break;
        }
    }
}
