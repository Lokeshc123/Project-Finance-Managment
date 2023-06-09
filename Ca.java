import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Ca extends JFrame {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    ImageIcon icon1 = new ImageIcon("Img/Ca.jpeg");
    JLabel j1 = new JLabel();
    JLabel j2 = new JLabel("Closing Account");
    JLabel j3 = new JLabel("Account Number");
    JLabel j4 = new JLabel("Password");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton btn = new JButton("Delete");
    JButton btnx = new JButton("Home");

    Ca() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        this.add(p1);
        this.add(p2);
        p1.setBounds(0, 0, 850, 800);
        p2.setBounds(850, 0, 450, 800);
        p1.setBackground(Color.pink);
        p2.setBackground(new Color(102, 102, 255));
        p1.setLayout(null);

        j1.setIcon(icon1);
        j1.setBounds(175, 150, 500, 500);
        p1.add(j1);
        p2.add(j2);
        p2.add(j3);
        p2.add(j4);
        p2.add(t1);
        p2.add(t2);
        p2.setLayout(null);
        j2.setBounds(85, 100, 350, 35);
        j2.setFont(new Font("Courier", Font.PLAIN, 30));
        j2.setForeground(Color.white);
        j3.setBounds(100, 300, 350, 35);
        j3.setFont(new Font("Courier", Font.PLAIN, 27));
        j3.setForeground(Color.white);
        t1.setBounds(100, 350, 200, 30);
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t1.setBackground(new Color(102, 102, 255));
        t1.setForeground(Color.white);
        j4.setBounds(100, 420, 350, 35);
        j4.setFont(new Font("Courier", Font.PLAIN, 27));
        j4.setForeground(Color.white);
        t2.setBounds(100, 470, 200, 30);
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t2.setBackground(new Color(102, 102, 255));
        t2.setForeground(Color.white);
        p2.add(btn);
        btn.setBounds(120, 540, 170, 30);
        p2.add(btnx);
        btnx.setBounds(150, 620, 120, 30);
        btnx.setFocusable(false);
        btnx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Home().setVisible(true);
                dispose();
            }
        });


        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String str1 = t1.getText();
                String str2 = t2.getText();
                if (str1.length() == 0 || str2.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Nothing Found in Textfield");
                } else {
                    String url = "jdbc:mysql://localhost:3306/test";
                    String user = "root";
                    String password = "Iwin$100";
                    try (Connection conn = DriverManager.getConnection(url, user, password);
                            Statement stmt = conn.createStatement()) {
                        String sql = "SELECT * FROM customers WHERE account_number ='" + str1 + "' AND password='"
                                + str2
                                + "'";
                        ResultSet rs = stmt.executeQuery(sql);
                        if (rs.next()) {
                            int id = rs.getInt("id");
                            sql = "DELETE FROM customers WHERE id=" + id;
                            stmt.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Deleted Successfully");
                        }
                        // If the user doesn't exist, display a message
                        else {
                            JOptionPane.showMessageDialog(null, "User Not Found");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        Ca n = new Ca();
    }
}
