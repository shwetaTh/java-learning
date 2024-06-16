import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MSPaintDupe {
    public static String mainColor ="#000000";
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag to paint");
        frame.setLayout(new BorderLayout());
        Graphics g= frame.getGraphics();
        JPanel colors = new JPanel();
        colors.setPreferredSize(new Dimension(100, 50));
        JButton red = new JButton();
        red.setBackground(Color.red);
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainColor= "#Ff0000";
            }
        });
        colors.add(red);

        JButton blue = new JButton();
        blue.setBackground(Color.blue);
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainColor= "#0000FF";
            }
        });
        colors.add(blue);

        JButton green = new JButton();
        green.setBackground(Color.green);
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainColor= "#00FF00";
            }
        });
        colors.add(green);

        JButton pink = new JButton();
        pink.setBackground(Color.pink);
        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainColor= "#FFC0CB";
            }
        });
        colors.add(pink);

        frame.add(colors,BorderLayout.NORTH);

        JPanel screen = new JPanel();
        frame.add(screen, BorderLayout.CENTER);
        screen.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics gScreen = screen.getGraphics();
                gScreen.setColor(Color.decode(mainColor));
                gScreen.fillOval(e.getX(), e.getY(), 10,10);
            }
        });
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
