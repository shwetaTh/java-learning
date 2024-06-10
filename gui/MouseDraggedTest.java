import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDraggedTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag to paint");
        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics g = frame.getGraphics();
                g.setColor(Color.blue);
                g.fillOval(e.getX(), e.getY(), 10,10);
            }
        });
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
