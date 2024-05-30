import javax.swing.*;

public class Home {
    public static void main(String[] args) {
        JFrame frame = new JFrame("home");
        JMenuBar menu = new JMenuBar();
        JMenuItem item1 = new JMenuItem("Home");
        JMenuItem item2= new JMenuItem("Blog");
        JMenuItem item3= new JMenuItem("About us");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        frame.setJMenuBar(menu);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
