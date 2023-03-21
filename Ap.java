import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ap extends JFrame {

    JPanel p1 = new JPanel();
    JLabel l1 = new JLabel();
    JPanel p2 = new JPanel();

    Ap() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        Ap n = new Ap();
    }
}
