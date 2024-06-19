import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {
    public SignUp (Connection connection){
        JFrame frame = new JFrame("Sign Up");
        JPanel signup = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        JLabel rollNoLabel = new JLabel("Roll No: ");
        JTextField nameField = new JTextField();
        JTextField rollNoField = new JTextField();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Log In");
        JButton signupBtn = new JButton("Sign Up");


        nameLabel.setBounds(50, 50, 100, 30);
        nameField.setBounds(150, 50, 200, 30);
        rollNoLabel.setBounds(50, 100, 100, 30);
        rollNoField.setBounds(150, 100, 200, 30);

        usernameLabel.setBounds(50, 150, 100, 30);
        usernameField.setBounds(150, 150, 200, 30);
        passwordLabel.setBounds(50, 200, 100, 30);
        passwordField.setBounds(150, 200, 200, 30);
        loginBtn.setBounds(150, 250, 90, 30);
        signupBtn.setBounds(260, 250, 90, 30);


        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameInp = nameField.getText();
                int rollInp = Integer.parseInt(rollNoField.getText());
                String userInp = usernameField.getText();
                String passInp = String.valueOf(passwordField.getPassword());
                String query = "insert into student (std_name, rollNo, username, password) VALUES ('" + nameInp + "', " + rollInp + ", '" + userInp + "', '" + passInp + "')";;
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Successful Signup");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        signup.setLayout(null);

        signup.add(nameLabel);
        signup.add(nameField);
        signup.add(rollNoField);
        signup.add(rollNoLabel);
        signup.add(usernameLabel);
        signup.add(usernameField);
        signup.add(passwordLabel);
        signup.add(passwordField);
        signup.add(loginBtn);
        signup.add(signupBtn);

        frame.add(signup);

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "rootAdmin";
        Connection connection = DriverManager.getConnection(url, user, password);

    }*/
}
