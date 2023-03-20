import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Register extends JFrame {

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JLabel j1 = new JLabel();
    ImageIcon icon1 = new ImageIcon("Img/Reg 2.png");
    JLabel j2 = new JLabel("Sign Up");
    JLabel j3 = new JLabel("Username");
    JLabel j4 = new JLabel("Passowrd");
    JLabel j5 = new JLabel("Confirm Password");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JButton btn = new JButton("Sign up");

    Register() {
        this.setVisible(true);
        p1.setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        this.add(p1);
        p1.add(p3);
        p3.setLayout(null);
        p3.add(j2);
        j2.setBounds(145, 30, 120, 40);
        j2.setFont(new Font("Courier", Font.BOLD, 30));
        p1.setLayout(null);
        p3.setBounds(225, 200, 400, 400);
        p3.setBackground(Color.white);
        p1.setBounds(0, 0, 850, 800);
        j1.setBounds(100, 100, 150, 150);
        p1.add(j1);
        p2.setBounds(850, 0, 450, 800);
        this.add(p2);
        j1.setIcon(icon1);
        p2.add(j1);
        j1.setBounds(0, 0, 500, 500);
        p3.add(j3);
        p3.add(j4);
        p3.add(j5);
        j3.setBounds(135, 100, 120, 40);
        j3.setFont(new Font("Courier", Font.PLAIN, 20));
        p3.add(t1);
        t1.setBounds(135, 140, 150, 25);
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        j4.setBounds(135, 180, 120, 40);
        j4.setFont(new Font("Courier", Font.PLAIN, 20));
        p3.add(t2);
        t2.setBounds(135, 220, 150, 25);
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        j5.setBounds(135, 260, 180, 40);
        j5.setFont(new Font("Courier", Font.PLAIN, 20));
        p3.add(t3);
        t3.setBounds(135, 300, 150, 25);
        t3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        p3.add(btn);
        btn.setBounds(135, 340, 150, 30);
        btn.setFocusable(false);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                check();
            }
        });
    }

    void check() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "Iwin$100");

            String sql = "SELECT * FROM user_credentials WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            String username = t1.getText();
            String password = t2.getText();

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User Exist Already");
            } else {
                store();
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("SQL exception: " + ex.getMessage());
        }
    }

    void store() {
        String str1 = t1.getText();
        String str2 = t2.getText();
        String str3 = t3.getText();
        if (str2.equals(str3)) {

            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "Iwin$100");

                // Create SQL statement
                String sql = "INSERT INTO user_credentials (username, password) VALUES (?, ?)";

                // Create prepared statement
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, str1);
                stmt.setString(2, str2);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully Register");

            } catch (SQLException se) {
                // Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                // Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                    // Do nothing
                }
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }

        } else

        {
            JOptionPane.showMessageDialog(null, "PassWord Dont Match");
        }
    }

    public static void main(String[] args) {
        Register r = new Register();
    }
}
