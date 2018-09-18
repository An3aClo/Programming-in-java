package buttondb;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonDB {

    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

class MyFrame extends JFrame {

    private JButton displayAllBooks;
    private JButton disBut;
    private JTextField f1;
    private JTable table;
    private JScrollPane scrollPane;

    public MyFrame() {
        setTitle("Buttons!!!!!!");
        Container c = this.getContentPane();
        MainIntro mainIntro = new MainIntro();
        c.add(mainIntro, BorderLayout.NORTH);
        MainIntroMessage mainIntroMessage = new MainIntroMessage();
        c.add(mainIntroMessage, BorderLayout.LINE_START);
        ButtonPanel ButtonPanel = new ButtonPanel();
        c.add(ButtonPanel, BorderLayout.EAST);
        pack();
    }

    class MainIntro extends JPanel {

        public MainIntro() {
            JLabel mainIntro = new JLabel("WELCOME!");
            add(mainIntro);
        }
    }

    class MainIntroMessage extends JPanel {

        public MainIntroMessage() {
            JLabel mainIntroMessage = new JLabel("Select Action");
            add(mainIntroMessage);
        }
    }

    class ButtonPanel extends JPanel {

        public ButtonPanel() {

            displayAllBooks = new JButton("View All Books");
            add(displayAllBooks);
            ButtonListener Button = new ButtonListener();
            displayAllBooks.addActionListener(Button);
        }
    }

    class showMeFrame extends JFrame {

        public showMeFrame() {
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            setTitle("Search Book - My Library");
            Container contentPane = this.getContentPane();
            but1 bbut1 = new but1();
            contentPane.add(bbut1, BorderLayout.SOUTH);
            FrameLabel frameLabel = new FrameLabel();
            contentPane.add(frameLabel, BorderLayout.WEST);
            FrameText frameText = new FrameText();
            contentPane.add(frameText, BorderLayout.EAST);
            pack();
        }
    }

    class FrameLabel extends JPanel {

        public FrameLabel() {
            JLabel l = new JLabel("Enter ISBN Number: ");
            add(l);
        }
    }

    class FrameText extends JPanel {

        public FrameText() {
            f1 = new JTextField(20);
            add(f1);
        }
    }

    class but1 extends JPanel {

        public but1() {
            disBut = new JButton("Show mew Now");
            add(disBut);
            but1Listener bbut1Listener = new but1Listener();
            disBut.addActionListener(bbut1Listener);
        }
    }

    class but1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Show mew Now")) {
                showMe();
            }
        }

        public void showMe() {
            String url = "jdbc:mysql://localhost:3306/student";
            String usrename = "root";
            String password = "root";
            String driver = "com.mysql.jdbc.Driver";

            PreparedStatement pst = null;

            try {
                String sql = "Insert into books(ISBNNumber) values (?)";
                Connection conn = DriverManager.getConnection(url, usrename, password);
                pst = conn.prepareStatement(sql);
                pst.setString(1, f1.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Saved");

            } catch (Exception e) {
                e.printStackTrace();
            }
            /*   try {
               Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, usrename, password);
                Statement s = conn.createStatement();
                String query = "Select * FROM books";
                ResultSet rs = s.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("ISBNNumber") + " "
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
            }*/
        }
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("View All Books")) {
                new showMeFrame();
            }
        }
    }
}
