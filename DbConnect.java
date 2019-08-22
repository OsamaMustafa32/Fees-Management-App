package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {

    public static Connection C;
    public static Statement st;
    public static PreparedStatement addaccountant, getaccountant, updateaccountant, addstudent, getstudent,updatestudent,getstudentdue,updatestudent2;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "fee", "fee");
            st = c.createStatement();
            addaccountant = c.prepareStatement("insert into accountant_info (username,pass,email,contact) values(?,?,?,?)");
            getaccountant = c.prepareStatement("Select * from accountant_info");
            updateaccountant = c.prepareStatement("update accountant_info set username=?,pass=?,email=?,contact=? where username=? ");
            addstudent = c.prepareStatement("insert into student_info (roll,name,email,contact,course,branch,year,fees,paid,due) values(?,?,?,?,?,?,?,?,?,?)");
            getstudent = c.prepareStatement("Select * from student_info where roll like ?");
            getstudentdue=c.prepareStatement("select * from student_info ");
            updatestudent=c.prepareStatement("update student_info set name=?,email=?,contact=?,course=?,branch=?,year=?,fees=?,paid=?,due=? where roll=?");
            updatestudent2=c.prepareStatement("update student_info set latefine=? where roll=?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
