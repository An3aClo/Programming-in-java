package studentdetail;

import javax.swing.*;

public class StudentDetail {

    public StudentDetail() {
        

        JLabel lName = new JLabel("Name");
        JTextField tName = new JTextField(15);

        JLabel lSurname = new JLabel("Surname");
        JTextField tSurname = new JTextField(15);

        JLabel lNumber = new JLabel("Cell Number");
        JTextField tNumber = new JTextField(10);

        JLabel lEmail = new JLabel("Email");
        JTextField tEmail = new JTextField();
    }

    public static void main(String[] args) {

    }

}
