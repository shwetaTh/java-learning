import javax.swing.*;
import java.sql.*;

public class SelectData{
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password="rootAdmin";
        //String query = "create database school";
        String query = "select * from student";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("std_id");
            String std_name = rs.getString("std_name");
            int roll = rs.getInt("rollNo");
            System.out.println("Id: "+ id + " || Name: "+ std_name+ " || Roll no: "+ roll);
        }
        statement.close();
        connection.close();
        JOptionPane.showMessageDialog(null,"selected data");
    }
}


