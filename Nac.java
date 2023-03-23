import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Nac extends JFrame {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l1 = new JLabel("Welcome");
    JLabel l2 = new JLabel("Account Number");
    JLabel l3 = new JLabel("Password");
    JLabel l4 = new JLabel("Confirm Password");
    JLabel l5 = new JLabel("Intial Balance");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JButton btn = new JButton("Register");
    JButton btnx = new JButton("Home");

    Nac() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        this.add(p1);
        p1.setBounds(0, 0, 850, 800);
        p1.setBackground(Color.pink);
        this.add(p2);
        p2.setBounds(850, 0, 450, 800);
        p2.setBackground(new Color(102, 102, 255));
        p2.add(l1);
        p2.setLayout(null);
        l1.setBounds(155, 135, 150, 30);
        l1.setFont(new Font("Courier", Font.PLAIN, 30));
        l1.setForeground(Color.white);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);
        p2.add(t4);
        l2.setBounds(120, 240, 200, 30);
        l2.setFont(new Font("Courier", Font.PLAIN, 22));
        l2.setForeground(Color.white);
        t1.setBounds(120, 280, 200, 30);
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t1.setBackground(new Color(102, 102, 255));
        t1.setForeground(Color.white);
        l3.setBounds(120, 320, 200, 30);
        l3.setFont(new Font("Courier", Font.PLAIN, 22));
        l3.setForeground(Color.white);
        t2.setBounds(120, 360, 200, 30);
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t2.setBackground(new Color(102, 102, 255));
        t2.setForeground(Color.white);
        l4.setBounds(120, 400, 250, 30);
        l4.setFont(new Font("Courier", Font.PLAIN, 22));
        l4.setForeground(Color.white);
        t3.setBounds(120, 440, 200, 30);
        t3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t3.setBackground(new Color(102, 102, 255));
        t3.setForeground(Color.white);
        l5.setBounds(120, 480, 200, 30);
        l5.setFont(new Font("Courier", Font.PLAIN, 22));
        l5.setForeground(Color.white);
        t4.setBounds(120, 520, 200, 30);
        t4.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t4.setBackground(new Color(102, 102, 255));
        t4.setForeground(Color.white);
        p2.add(btn);
        btn.setBounds(120, 560, 200, 30);
        btn.setFocusable(false);
        p2.add(btnx);
        btnx.setBounds(165, 620, 120, 30);
        btnx.setFocusable(false);
        btnx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Home().setVisible(true);
                dispose();
            }
        });

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String acc_no = t1.getText();
                String pass = t2.getText();
                String cpass = t3.getText();
                String bal = t4.getText();
                if (acc_no.length() == 0 || pass.length() == 0 || cpass.length() == 0 || bal.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Nothing Found in Textfield");
                } else {
                    if (pass.equals(cpass)) {
                        String url = "jdbc:mysql://localhost:3306/test";
                        String username = "root";
                        String password = "Iwin$100";
                        try (Connection con = DriverManager.getConnection(url, username, password);
                                Statement stmt = con.createStatement()) {

                            String query = "CREATE TABLE IF NOT EXISTS customers ("
                                    + "id INT NOT NULL AUTO_INCREMENT,"
                                    + "account_number VARCHAR(20) NOT NULL,"
                                    + "password VARCHAR(20) NOT NULL,"
                                    + "balance INT NOT NULL,"
                                    + "PRIMARY KEY (id))";

                            stmt.executeUpdate(query);
                            String query4 = "SELECT COUNT(*) AS count FROM accounts WHERE account_number='" + acc_no
                                    + "' AND password='" + pass + "'";
                            ResultSet rs = stmt.executeQuery(query4);

                            rs.next();
                            int count = rs.getInt("count");

                            if (count == 1) {
                                JOptionPane.showMessageDialog(null, "Account Exists Already");
                            } else {
                                String query5 = "INSERT INTO customers (account_number, password, balance) VALUES (?, ?, ?)";
                                PreparedStatement pstmt = con.prepareStatement(query5);
                                pstmt.setString(1, acc_no);
                                pstmt.setString(2, pass);
                                pstmt.setString(3, bal);

                                pstmt.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Register Successfully");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords Dismatch");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Nac n = new Nac();
    }
}
