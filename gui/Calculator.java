import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new GridLayout(2, 1));
        JPanel input = new JPanel();
        JPanel nums= new JPanel();
        nums.setLayout(new GridLayout(4, 4));
        nums.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(input);
        frame.add(nums);
        JButton[] buttons = new JButton[16];
        for (int i = 0; i<16; i++){
            buttons[i]= new JButton("X");
            nums.add(buttons[i]);
        }
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
