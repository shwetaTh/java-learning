import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncDecView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Increment and decrement counter");
        IncDecModel model= new IncDecModel();
        IncDecController controller = new IncDecController(model);
        JLabel incDecnum = new JLabel();
        incDecnum.setText("0");
        incDecnum.setBounds(150, 10, 100, 100);
        frame.add(incDecnum);

        JButton inc = new JButton("Inc");
        inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = controller.increment();
                incDecnum.setText(String.valueOf(num));
            }
        });
        inc.setBounds(100, 100, 100, 30);
        frame.add(inc);

        JButton dec = new JButton("Dec");
        dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = controller.decrement();
                incDecnum.setText(String.valueOf(num));
            }
        });
       dec.setBounds(200, 100, 100, 30);
        frame.add(dec);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
