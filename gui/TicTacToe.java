import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe {
    private static char currentPlayer = 'X';
    private static char[] board = new char[9];
    private static JPanel[] panels = new JPanel[9];
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            panels[i] = new JPanel();
            panels[i].setBackground(Color.WHITE);
            panels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            final int index = i;
            panels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handlePanelClick(index);
                }
            });
            frame.add(panels[i]);
        }
        JButton reset = new JButton("Reset");
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static void handlePanelClick(int index) {
        if (board[index] == '\0') {
            board[index] = currentPlayer;
            if (currentPlayer == 'X') {
                panels[index].setBackground(Color.RED);
            } else {
                panels[index].setBackground(Color.BLUE);
            }
            if (isBoardFull()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static boolean isBoardFull() {
        for (char c : board) {
            if (c == '\0') {
                return false;
            }
        }
        return true;
    }

    private static void resetGame() {
        currentPlayer = 'X';
        board = new char[9];
        for (JPanel panel : panels) {
            panel.setBackground(Color.WHITE);
            panel.revalidate();
            panel.repaint();
        }
    }
}
