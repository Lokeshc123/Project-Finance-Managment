import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Home extends JFrame {
    JPanel p1 = new JPanel();
    ImageIcon icon1 = new ImageIcon("Img/Home.png");
    JPanel j = new JPanel();
    JLabel j1 = new JLabel();
    JPanel p2 = new JPanel();
    JButton btn1 = new JButton("New Account");
    JButton btn2 = new JButton("Close Account");
    JButton btn3 = new JButton("Balance");
    JButton btn4 = new JButton("Withdrawal");
    JButton btn5 = new JButton("Deposit");
    JButton btn6 = new JButton("Transfer");
    JButton btn7 = new JButton("Log Out");

    Home() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);
        p1.setBounds(0, 0, 540, 800);
        this.add(p1);
        p1.setBackground(Color.pink);
        p1.setLayout(null);
        j1.setIcon(icon1);
        p1.add(j1);
        j1.setBounds(0, 0, 600, 800);
        p2.setBounds(540, 0, 760, 800);
        this.add(p2);
        p2.setLayout(null);
        p2.setBackground(new Color(102, 102, 255));
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        p2.add(btn5);
        p2.add(btn7);
        p2.add(btn6);
        btn1.setBounds(100, 200, 120, 30);
        btn2.setBounds(300, 200, 120, 30);
        btn3.setBounds(500, 200, 120, 30);
        btn4.setBounds(100, 400, 120, 30);
        btn5.setBounds(300, 400, 120, 30);
        btn6.setBounds(500, 400, 120, 30);
        btn7.setBounds(300, 600, 120, 30);
        btn1.setFocusable(false);
        btn2.setFocusable(false);
        btn3.setFocusable(false);
        btn4.setFocusable(false);
        btn5.setFocusable(false);
        btn6.setFocusable(false);
        btn7.setFocusable(false);
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Login().setVisible(true);
                dispose();
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Nac().setVisible(true);
                dispose();
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Ca().setVisible(true);
                dispose();
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Bal().setVisible(true);
                dispose();
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new With().setVisible(true);
                dispose();
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Dp().setVisible(true);
                dispose();
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Ap().setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        Home h = new Home();
    }
}
