import java.awt.*;

import javax.swing.*;

public class Home extends JFrame {
    JPanel p1 = new JPanel();
    ImageIcon icon1 = new ImageIcon("Img/Home.png");
    JPanel j = new JPanel();
    JLabel j1 = new JLabel();
    JPanel p2 = new JPanel();

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
        p2.setBackground(Color.blue);
    }

    public static void main(String[] args) {
        Home h = new Home();
    }
}
