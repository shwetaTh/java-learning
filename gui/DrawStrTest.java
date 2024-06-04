import javax.swing.*;
import java.awt.*;

public class DrawStrTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NIST College");
        JPanel panel = new JPanel(){
            public  void paint (Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLUE);
                g2d.setFont(new Font("Times new roman", Font.ITALIC, 50));
                g2d.drawString("We are learning advance java", 100, 100);
            }
        };
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
