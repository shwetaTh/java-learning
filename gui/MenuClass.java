import javax.swing.*;
import java.awt.event.*;

public class MenuClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("home");
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");
        JMenuItem file1 = new JMenuItem("New");
        JMenuItem file2= new JMenuItem("Open");
        JMenuItem file3= new JMenuItem("Save");
        JMenuItem file4= new JMenuItem("Exit");
        menu.add(file);
        menu.add(edit);
        menu.add(help);
        file.add(file1);
        file.add(file2);
        file.add(file3);
        file4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(file4);
        frame.setJMenuBar(menu);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
