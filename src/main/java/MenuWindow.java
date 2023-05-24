import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;

public class MenuWindow implements ActionListener {
    JFrame jFrame;
    JLabel jLabel;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JButton jButton;
    JButton jButton2;

    MenuWindow() {
        //jlabel
        ImageIcon icon = new ImageIcon("Icon\\label.png");
        jLabel = new JLabel();
        jLabel.setIcon(icon);
        jLabel.setBounds(380, 20, 100, 100);

        ImageIcon icon2 = new ImageIcon("Icon\\label2.png");
        jLabel2 = new JLabel();
        jLabel2.setIcon(icon2);
        jLabel2.setBounds(30, 10, 256, 256);

        jLabel3 = new JLabel("TỪ ĐIỂN");
        jLabel3.setBounds(250, 120, 300, 60);
        jLabel3.setFont(new Font("T", Font.BOLD, 50));
        jLabel3.setBackground(new Color(153, 209, 211));

        ImageIcon icon3 = new ImageIcon("Icon\\translator.png");
        jLabel4 = new JLabel();
        jLabel4.setIcon(icon3);
        jLabel4.setBounds(50, 150, 256, 256);

        ImageIcon icon4 = new ImageIcon("Icon\\search.png");
        jLabel5 = new JLabel();
        jLabel5.setIcon(icon4);
        jLabel5.setBounds(300, 50, 32, 32);

        //button
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        jButton = new JButton();
        jButton.setBounds(200, 230, 90, 50);
        jButton.addActionListener(this);
        jButton.setText("Anh - Việt");
        jButton.setCursor(cur);
        jButton.setFocusable(false);
        jButton.setBackground(new Color(201, 228, 214));
        jButton.setToolTipText("Từ điển Anh - Việt");

        jButton2 = new JButton();
        jButton2.setBounds(400, 230, 90, 50);
        jButton2.addActionListener(this);
        jButton2.setText("Việt - Anh");
        jButton2.setCursor(cur);
        jButton2.setFocusable(false);
        jButton2.setBackground(new Color(201, 228, 214));
        jButton2.setToolTipText("Từ điển Việt - Anh");

        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(550, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.getContentPane().setBackground(new Color(153, 209, 211));
        jFrame.add(jLabel);
        jFrame.add(jLabel2);
        jFrame.add(jLabel3);
        jFrame.add(jLabel4);
        jFrame.add(jLabel5);
        jFrame.setResizable(false);
        jFrame.add(jButton);
        jFrame.add(jButton2);
        ImageIcon image = new ImageIcon("Icon\\icon.png");
        jFrame.setIconImage(image.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            jFrame.dispose();
            DictionaryManagement.insertFromDatabase("av");
            Dictionary.check = true;
            new DictionaryApplication();
        }


        if (e.getSource() == jButton2) {
            jFrame.dispose();
            DictionaryManagement.insertFromDatabase("va");
            Dictionary.check = false;
            new DictionaryApplication2();
        }
    }
}
