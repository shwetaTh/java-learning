import javax.swing.*;

public class Login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");

        JLabel emailLabel = new JLabel("Email: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton submitButton = new JButton("Submit");
        JButton signupButton = new JButton("Sign Up");

        frame.setLayout(null);

        emailLabel.setBounds(50, 100, 100, 30);
        emailField.setBounds(150, 100, 200, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        passwordField.setBounds(150, 150, 200, 30);
        submitButton.setBounds(150, 200, 90, 30);
        signupButton.setBounds(260, 200, 90, 30);

        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(submitButton);
        frame.add(signupButton);

        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
