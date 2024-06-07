import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumCalculate {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sum");
        JLabel numLabel1 = new JLabel("Number 1: ");
        numLabel1.setBounds(50, 100, 100, 30);
        JLabel numLabel2 = new JLabel("Number 2: ");
        numLabel2.setBounds(50, 150, 100, 30);
        JTextField num1 = new JTextField();
        num1.setBounds(150, 100, 200, 30);
        JTextField num2 = new JTextField();
        num2.setBounds(150, 150, 200, 30);
        JButton sum = new JButton("Sum");
        sum.setBounds(150, 200, 90, 30);

        sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstnum = Integer.parseInt(num1.getText());
                int secondnum = Integer.parseInt(num2.getText());
                int sum = firstnum+secondnum;
                JOptionPane.showMessageDialog(frame, "sum: " + sum);
            }
        });

        frame.add(numLabel1);
        frame.add(num1);
        frame.add(numLabel2);
        frame.add(num2);
        frame.add(sum);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

