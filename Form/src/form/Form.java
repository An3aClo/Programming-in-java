package form;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MakhuraneT
 */
public class Form {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class MyFrame extends JFrame {

    private JLabel firstNameLbl;
    private JLabel lastNameLbl;
    private JLabel genderLbl;
    private JLabel dobLbl;

    private JTextField firstName;
    private JTextField lastName;
    private JTextField gender;
    private JTextField dob;

    private JButton save;
    private JButton display;

    private JTable table;
    private JScrollPane scrollPane;

    public MyFrame() {//conductor
        setTitle("Student Form");
        Container contentPane = this.getContentPane();

        DataPanel dataPanel = new DataPanel();
        contentPane.add(dataPanel, BorderLayout.CENTER);

        ButtonPanel buttonPanel = new ButtonPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        DisplayPanel displayPanel = new DisplayPanel();
        contentPane.add(displayPanel, BorderLayout.EAST);
        this.pack();
    }

    // this is an inner class
    class DataPanel extends JPanel {

        public DataPanel() {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(4);
            gridLayout.setColumns(2);
            this.setLayout(gridLayout);

            firstNameLbl = new JLabel("first name");
            lastNameLbl = new JLabel("last name");
            genderLbl = new JLabel("gender");
            dobLbl = new JLabel("dob");

            firstName = new JTextField(20);
            lastName = new JTextField(20);
            gender = new JTextField(20);
            dob = new JTextField(20);

            add(firstNameLbl);
            add(firstName);
            add(lastNameLbl);
            add(lastName);
            add(genderLbl);
            add(gender);
            add(dobLbl);
            add(dob);
        }
    }

    // another inner class
    class ButtonPanel extends JPanel {

        public ButtonPanel() {
            save = new JButton("Save");
            display = new JButton("Display");
            add(save);
            add(display);
            ButtonListener buttonListener = new ButtonListener();
            save.addActionListener(buttonListener);
            display.addActionListener(buttonListener);
        }
    }

    class DisplayPanel extends JPanel {

        public DisplayPanel() {

            table = new JTable();
            scrollPane = new JScrollPane();
            add(scrollPane);
        }
    }

    // a third inner class
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Save")) {
                saveAction();
            } else if (evt.getActionCommand().equals("Display")) {
                displayAction();
            }
        }

        public void displayAction() {
            try {
                String filename = "jdbc:ucanaccess://C://Users//andre//Desktop//Level 2//Semester 1//ITJA211//EasyDb.accdb";
                Connection conn = DriverManager.getConnection(filename);
                Statement s = conn.createStatement();
                String query = "SELECT * FROM Student";
                ResultSet rs = s.executeQuery(query);
                // while (rs.next()) {
                //System.out.println(rs.getString("firstname")
                //      + " " + rs.getString("lastname")
                //    + " " + rs.getString("gender")
                //  + " " + rs.getString("dob"));
                //}
                DefaultTableModel tableModel = new DefaultTableModel();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                for (int i = 1; i < columnCount; i++) {

                    tableModel.addColumn(metaData.getColumnLabel(i));
                }

                Object[] row = new Object[columnCount];

                while (rs.next()) {
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(row);
                }

                rs.close();
                s.close();
                conn.close();
            } catch (SQLException exp) {
                System.out.println("Something's wrong!");
                exp.printStackTrace();
            }
        }

        public void saveAction() {
            try {
                String filename = "jdbc:ucanaccess://C://Users//andre//Desktop//Level 2//Semester 1//ITJA211//EasyDb.accdb";
                Connection conn = DriverManager.getConnection(filename);
                Statement s = conn.createStatement();
                String insertQuery = "INSERT INTO Student (firstname, lastname, gender, dob) "
                        + "VALUES ('" + firstName.getText() + "', '"
                        + lastName.getText() + "', '"
                        + gender.getText() + "', '"
                        + dob.getText() + "')";

                boolean result = s.execute(insertQuery);

                s.close();
                conn.close();
                displayAction();
            } catch (SQLException exp) {
                System.out.println("Something's wrong!");
                exp.printStackTrace();
            }

        }
    }

}
