import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ap extends JFrame {

    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel("Transfer Money");
    JPanel p2 = new JPanel();
    JLabel l2 = new JLabel("Transfer To");
    JLabel l3 = new JLabel("Amount");
    JLabel l4 = new JLabel("Transfer From");
    JLabel l5 = new JLabel("Password");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JButton btn1 = new JButton("Transfer");
    JButton btnx = new JButton("Home");

    Ap() {
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
        p2.add(l1);
        p2.setLayout(null);
        l1.setBounds(100, 100, 350, 35);
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
        l2.setBounds(100, 200, 350, 35);
        l2.setFont(new Font("Courier", Font.PLAIN, 27));
        l2.setForeground(Color.white);
        t1.setBounds(100, 250, 200, 30);
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t1.setBackground(new Color(102, 102, 255));
        t1.setForeground(Color.white);
        l3.setBounds(100, 290, 350, 35);
        l3.setFont(new Font("Courier", Font.PLAIN, 27));
        l3.setForeground(Color.white);
        t2.setBounds(100, 340, 200, 30);
        t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t2.setBackground(new Color(102, 102, 255));
        t2.setForeground(Color.white);
        l4.setBounds(100, 380, 350, 35);
        l4.setFont(new Font("Courier", Font.PLAIN, 27));
        l4.setForeground(Color.white);
        t3.setBounds(100, 430, 200, 30);
        t3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t3.setBackground(new Color(102, 102, 255));
        t3.setForeground(Color.white);
        l5.setBounds(100, 480, 350, 35);
        l5.setFont(new Font("Courier", Font.PLAIN, 27));
        l5.setForeground(Color.white);
        t4.setBounds(100, 530, 200, 30);
        t4.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        t4.setBackground(new Color(102, 102, 255));
        t4.setForeground(Color.white);
        p2.add(btn1);
        p2.add(btnx);
        btn1.setBounds(120, 580, 150, 30);
        btn1.setFocusable(false);
        btnx.setBounds(120, 630, 150, 30);
        btnx.setFocusable(false);
        btnx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Home().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Ap n = new Ap();
    }
}
