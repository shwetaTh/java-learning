import javax.swing.*;
import java.awt.*;

public class ImageGrid {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Grid Assignment");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        String[] images = {
                "Y:\\Downloads\\IMG_3097.jpg",
                "Y:\\Downloads\\IMG_3333.JPG",
                "Y:\\Downloads\\IMG_3108.JPG",
                "Y:\\Downloads\\IMG_3103.jpg",
                "Y:\\Downloads\\IMG_3153.jpg",
                "Y:\\Downloads\\IMG_3237.JPG",
                "Y:\\Downloads\\IMG_3252.JPG",
                "Y:\\Downloads\\IMG_3254.JPG",
                "Y:\\Downloads\\IMG_3289.JPG"
        };
        for (int i = 0; i < images.length; i++) {
            ImageIcon img = new ImageIcon(images[i]);
            Image img1 = img.getImage();
            Image resize= img1.getScaledInstance(600,600, Image.SCALE_SMOOTH);
            ImageIcon resizedImg = new ImageIcon(resize);
            JLabel label = new JLabel(resizedImg);
            panel.add(label);
        }
        frame. add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
