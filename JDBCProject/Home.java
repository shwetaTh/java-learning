import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.Element;
import javax.swing.text.TableView;
import java.sql.*;

public class Home {
    public Home (Connection connection) throws SQLException {
        JFrame frame = new JFrame("home");
        JMenuBar menu = new JMenuBar();
        JMenuItem item1 = new JMenuItem("Home");
        JMenuItem item2= new JMenuItem("Blog");
        JMenuItem item3= new JMenuItem("About us");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        frame.setJMenuBar(menu);

         JTable table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("id");
        tableModel.addColumn("name");
        tableModel.addColumn("rollNo");
            String query = "select * from student";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            /*String h1 = "id";
            String h2= "name";
            String h3= "roll";
            Object[] headers = {h1, h2, h3};
            tableModel.addRow(headers);*/
            while (rs.next()){
                int id = rs.getInt("std_id");
                String std_name = rs.getString("std_name");
                int roll = rs.getInt("rollNo");
                Object[] row = {id, std_name, roll};
                tableModel.addRow(row);
            }
            table.setModel(tableModel);
            //frame.add(table);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
        

        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "rootAdmin";
        Connection connection = DriverManager.getConnection(url, user, password);
        new Home(connection);
    }
}
