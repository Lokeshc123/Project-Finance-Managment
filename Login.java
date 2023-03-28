import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {
    JPanel p1 = new JPanel();
    ImageIcon icon1 = new ImageIcon("Img/bck.png");
    ImageIcon icon2 = new ImageIcon("Img/User.png");
    ImageIcon icon3 = new ImageIcon("Img/Pass.png");

    JLabel l1 = new JLabel();
    JPanel p2 = new JPanel();
    JLabel l2 = new JLabel("Welcome  !");
    JLabel l3 = new JLabel("Login To Your Account");
    JLabel l4 = new JLabel("Username :");
    JLabel l5 = new JLabel("Password :");
    JLabel l6 = new JLabel(icon2);
    JLabel l7 = new JLabel(icon3);
    Font font = new Font("Courier", Font.PLAIN, 40);
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton btn1 = new JButton("Sign In");
    JButton btn2 = new JButton("Sign Up");

    Login() {

        l1.setIcon(icon1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        l1.setFocusable(false);

        p1.setBounds(0, 0, 850, 800);
        p1.setBackground(Color.pink);
        p1.add(l1);
        l1.setBounds(100, 100, 150, 150);
        p2.setBounds(850, 0, 450, 800);
        p2.setBackground(new Color(102, 102, 255));
        p2.setLayout(null);
        this.add(p1);
        this.add(p2);

        l2.setBounds(120, 100, 250, 30);
        l3.setBounds(135, 180, 300, 30);
        l3.setFont(new Font("Courier", Font.PLAIN, 16));
        l3.setForeground(Color.white);
        l4.setBounds(155, 280, 300, 30);
        l4.setFont(new Font("Courier", Font.PLAIN, 16));
        l4.setForeground(Color.white);
        l5.setBounds(155, 350, 300, 30);
        l5.setFont(new Font("Courier", Font.PLAIN, 16));
        l5.setForeground(Color.white);
        t1.setBounds(155, 320, 150, 20);
        t1.setBackground(new Color(102, 102, 255));
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t2.setBounds(155, 390, 150, 20);
        t2.setBackground(new Color(102, 102, 255));
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        l6.setBounds(100, 300, 35, 49);
        l7.setBounds(100, 370, 45, 49);
        btn1.setBackground(Color.red);
        btn1.setForeground(Color.white);
        btn1.setBounds(150, 440, 120, 30);
        btn1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn1.setFocusable(false);
        btn2.setBackground(Color.blue);
        btn2.setForeground(Color.white);
        btn2.setBounds(150, 490, 120, 30);
        btn2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btn2.setFocusable(false);
        p2.add(l6);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(l7);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(t1);
        p2.add(t2);
        l2.setFont(font);
        l2.setForeground(Color.white);
        t1.setForeground(Color.white);
        t2.setForeground(Color.white);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                check();
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Register().setVisible(true);
                dispose();
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
                new Home().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {

        }
    }

    public static void main(String[] args) {
        Login l = new Login();

    }

}
