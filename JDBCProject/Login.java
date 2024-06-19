import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "rootAdmin";
        Connection connection = DriverManager.getConnection(url, user, password);

        JFrame frame = new JFrame("Login");

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Log In");
        JButton signupBtn = new JButton("Sign Up");

        frame.setLayout(null);

        usernameLabel.setBounds(50, 100, 100, 30);
        usernameField.setBounds(150, 100, 200, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        passwordField.setBounds(150, 150, 200, 30);
        loginBtn.setBounds(150, 200, 90, 30);
        signupBtn.setBounds(260, 200, 90, 30);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInp = usernameField.getText();
                String passwordInp = new String(passwordField.getPassword());
                String query = "select * from student where username='" + usernameInp + "'";

                try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(query);

                    if (rs.next()) {
                        String passwordDb = rs.getString("password");
                        if (passwordDb.equals(passwordInp)) {
                            JOptionPane.showMessageDialog(null, "login success");
                        } else {
                            JOptionPane.showMessageDialog(null, "invalid");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "invalid");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginBtn);
        frame.add(signupBtn);

        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
