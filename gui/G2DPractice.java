import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class G2DPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Practice 2D shapes and colors");
        JPanel panel = new JPanel(){
            public  void paint (Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLUE);
                g2d.fillOval(50, 100, 100, 200);
                g2d.setColor(Color.green);
                g2d.fillRect(300, 200, 100, 100);
                g2d.setColor(Color.yellow);
                g2d.setStroke(new BasicStroke(20));
                g2d.drawLine(100, 10, 200, 200);
            }
        };
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
