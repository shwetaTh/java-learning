import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new GridLayout(2, 1));
        JTextField display = new JTextField();
        JPanel nums= new JPanel();
        nums.setLayout(new GridLayout(4, 4));
        nums.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(display);
        frame.add(nums);
        JButton cAdd = new JButton("+");
        nums.add(cAdd);
        JButton cSub = new JButton("-");
        nums.add(cSub);
        JButton cX = new JButton("X");
        nums.add(cX);
        JButton cClear = new JButton("C");
        nums.add(cClear);

        JButton c1 = new JButton("1");
        nums.add(c1);
        JButton c2 = new JButton("2");
        nums.add(c2);
        JButton c3 = new JButton("3");
        nums.add(c3);
        JButton cSqr = new JButton("Sqrt");
        nums.add(cSqr);

        JButton c4 = new JButton("4");
        nums.add(c4);
        JButton c5 = new JButton("5");
        nums.add(c5);
        JButton c6 = new JButton("6");
        nums.add(c6);
        JButton cDiv = new JButton("/");
        nums.add(cDiv);

        JButton c7 = new JButton("7");
        nums.add(c7);
        JButton c8 = new JButton("8");
        nums.add(c8);
        JButton c9 = new JButton("9");
        nums.add(c9);
        JButton cEqls = new JButton("=");
        nums.add(cEqls);

        Component[] components = nums.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(new BtnClick());
            }
        }
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static class BtnClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "C":
                    clear();
                    break;
                case "+":
                case "-":
                case "X":
                case "/":
                    operation(command);
                    break;
                case "Sqrt":
                    calcSqrt();
                    break;
                case "=":
                    result();
                    break;
                default:
                    addDis(command);
                    break;
            }
        }
        private void clear(){

        }
        private void operation(String oper){

        }
        private void calcSqrt(){

        }
        private void result(){

        }
        private void addDis(String num){
            
        }
    }
}
