package database;

import java.sql.*;

public class DataBase {

    public static void main(String[] args) {

        try{
            String filename="jdbc:ucanaccess://C://Users//andre//Desktop//Level 2//Semester 1//ITJA211//EasyDb.accdb";
            Connection conn= DriverManager.getConnection(filename);
            Statement s= conn.createStatement();
            String query= "SELECT*FROM Student";
            ResultSet rs=s.executeQuery(query);
            
            while(rs.next()){
                System.out.println(rs.getString("firstName"));
            }
        }catch(SQLException exp){
            System.out.println("OOPS");
            exp.printStackTrace();
        }
        
    }
}
