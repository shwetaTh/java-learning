import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password="rootAdmin";
        String query = "create database my_db";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.close();
        JOptionPane.showMessageDialog(null,"Database created");
    }
}
