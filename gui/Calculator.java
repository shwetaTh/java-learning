import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private static double operand1 = 0;
    private static String operation = "";
    private static JTextField display;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new GridLayout(2, 1));
        display = new JTextField();
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
                ((JButton) component).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String inp = ((JButton)e.getSource()).getText();
                        switch (inp) {
                            case "C":
                                clear();
                                break;
                            case "+":
                            case "-":
                            case "X":
                            case "/":
                                getOperation(inp);
                                addDis(inp);
                                break;
                            case "Sqrt":
                                calcSqrt();
                                break;
                            case "=":
                                result();
                                break;
                            default:
                                addDis(inp);
                                break;
                        }
                    }
                    private void clear(){
                        display.setText("");
                    }
                    private void getOperation(String oper){
                        operand1 = Double.parseDouble(display.getText());
                        operation = oper;
                        System.out.println("operation "+ oper);
                    }
                    private void calcSqrt(){
                        int num = Integer.parseInt(display.getText());
                        display.setText(String.valueOf(Math.sqrt(num)));
                    }
                    private void result(){
                        String text = display.getText();
                        int index = text.indexOf(operation);
                        String operand2Str = text.substring(index + 1);
                        double operand2 = Double.parseDouble(operand2Str);
                        double result = 0d;
                        switch (operation){
                            case "+":
                                result= operand1+operand2;
                                break;
                            case "-":
                                result=operand1-operand2;
                                break;
                            case "/":
                                result=operand1/operand2;
                                System.out.println(result);
                                break;
                            case "X":
                                result=operand1*operand2;
                        }
                        display.setText(String.valueOf(result));
                        operation="";
                    }
                    private void addDis(String num) {
                        if (display.getText()!=""){
                            display.setText(display.getText()+num);
                        }
                        else{
                            display.setText(num);
                        }
                    }
                });
            }
        }


        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
