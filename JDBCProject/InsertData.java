import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData{
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password="rootAdmin";
        //String query = "create database school";
        //String query = "insert into student (std_id, std_name, rollNo, username, password) VALUES (1, 'Shweta', 16, 'ShwetaTh', 'admin')";
        String query = "insert into student (std_id, std_name, rollNo, username, password) VALUES (2, 'Praashna', 13, 'PraashnaA', 'praashna')";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
        JOptionPane.showMessageDialog(null,"data Created");
    }
}

