import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class DictionaryApplication extends JFrame implements ActionListener {
    JButton button;
    JButton quitButton;
    JButton addButton;
    JButton delButton;
    JButton lisButton;
    JButton fixButton;
    JButton apiButton;
    JButton backButton;
    JTextField textField;
    KeyListener keyListener;
    ListSelectionListener listSelectionListener;
    JTextArea jt1;
    JList<String> myList;
    DefaultListModel<String> model;
    JScrollPane jScrollPane;

    DictionaryApplication() {
        //frame
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Icon\\bgr1.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon image = new ImageIcon("Icon\\icon.png");
        this.setIconImage(image.getImage());
        this.pack();
        this.setTitle("Dictionary by Haiten Team");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 651);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        //button
        button = new JButton("Dịch");
        button.setFocusable(false);
        button.setBounds(300, 85, 60, 30);
        button.setLayout(new FlowLayout());
        button.setForeground(new Color(0, 132, 137));
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        button.setCursor(cur);
        this.add(button);
        button.addActionListener(this);
        this.setVisible(true);

        ImageIcon image1 = new ImageIcon("Icon\\add.png");
        addButton = new JButton();
        addButton.setBounds(350, 152, 85, 60);
        addButton.addActionListener(this);
        addButton.setIcon(image1);
        addButton.setText("Thêm từ");
        addButton.setFocusable(false);
        addButton.setCursor(cur);
        addButton.setHorizontalTextPosition(JButton.CENTER);
        addButton.setVerticalTextPosition(JButton.BOTTOM);
        addButton.setBackground(new Color(201, 228, 214));
        addButton.setToolTipText("Nháy chuột để thêm từ mới");
        this.add(addButton);

        ImageIcon image2 = new ImageIcon("Icon\\delete.png");
        delButton = new JButton();
        delButton.setBounds(350, 240, 85, 60);
        delButton.addActionListener(this);
        delButton.setIcon(image2);
        delButton.setText("Xóa từ");
        delButton.setCursor(cur);
        delButton.setFocusable(false);
        delButton.setHorizontalTextPosition(JButton.CENTER);
        delButton.setVerticalTextPosition(JButton.BOTTOM);
        delButton.setBackground(new Color(201, 228, 214));
        delButton.setToolTipText("Nháy chuột để xóa một từ");
        this.add(delButton);

        ImageIcon image3 = new ImageIcon("Icon\\quit.png");
        quitButton = new JButton();
        quitButton.setBounds(350, 510, 85, 60);
        quitButton.addActionListener(this);
        quitButton.setIcon(image3);
        quitButton.setText("Thoát");
        quitButton.setCursor(cur);
        quitButton.setFocusable(false);
        quitButton.setHorizontalTextPosition(JButton.CENTER);
        quitButton.setVerticalTextPosition(JButton.BOTTOM);
        quitButton.setBackground(new Color(201, 228, 214));
        quitButton.setToolTipText("Thoát chương trình");
        this.add(quitButton);

        ImageIcon image4 = new ImageIcon("Icon\\listen.png");
        lisButton = new JButton();
        lisButton.setBounds(350, 330, 85, 60);
        lisButton.addActionListener(this);
        lisButton.setIcon(image4);
        lisButton.setText("Phát âm");
        lisButton.setCursor(cur);
        lisButton.setFocusable(false);
        lisButton.setHorizontalTextPosition(JButton.CENTER);
        lisButton.setVerticalTextPosition(JButton.BOTTOM);
        lisButton.setBackground(new Color(201, 228, 214));
        lisButton.setToolTipText("Nháy chuột để nghe phát âm");
        this.add(lisButton);

        ImageIcon image5 = new ImageIcon("Icon\\fix.png");
        fixButton = new JButton();
        fixButton.setBounds(350, 420, 85, 60);
        fixButton.addActionListener(this);
        fixButton.setIcon(image5);
        fixButton.setText("Sửa từ");
        fixButton.setCursor(cur);
        fixButton.setFocusable(false);
        fixButton.setHorizontalTextPosition(JButton.CENTER);
        fixButton.setVerticalTextPosition(JButton.BOTTOM);
        fixButton.setBackground(new Color(201, 228, 214));
        fixButton.setToolTipText("Nháy chuột để sửa một từ");
        this.add(fixButton);

        ImageIcon image6 = new ImageIcon("Icon\\api1.png");
        apiButton = new JButton();
        apiButton.setBounds(570, 40, 120, 50);
        apiButton.setIcon(image6);
        apiButton.setBackground(new Color(201, 228, 214));
        apiButton.setHorizontalTextPosition(JLabel.CENTER);
        apiButton.setVerticalTextPosition(JLabel.BOTTOM);
        apiButton.addActionListener(this);
        apiButton.setText("Dịch đoạn văn");
        apiButton.setCursor(cur);
        apiButton.setFocusable(false);
        apiButton.setToolTipText("English to Vietnamese");
        this.add(apiButton);

        ImageIcon icon7 = new ImageIcon("Icon\\back.png");
        backButton = new JButton();
        backButton.setBounds(920, 40, 50, 30);
        backButton.addActionListener(this);
        backButton.setBackground(new Color(223, 53, 57));
        backButton.setFocusable(false);
        backButton.setCursor(cur);
        backButton.setIcon(icon7);
        backButton.setToolTipText("Quay lại trang trước");
        backButton.setHorizontalTextPosition(JButton.CENTER);
        backButton.setVerticalTextPosition(JButton.BOTTOM);
        this.add(backButton);

        //text
        textField = new JTextField();
        textField.setBounds(30, 85, 220, 30);
        textField.setFont(new Font("Consolas", Font.BOLD, 18));
        textField.addActionListener(this);
        this.add(textField);

        jt1 = new JTextArea("Nghĩa của từ: ");
        jt1.setForeground(new Color(255, 255, 255));
        jt1.setBounds(530, 150, 420, 450);
        Font font3 = new Font("Times New Roman", Font.BOLD, 18);
        jt1.setFont(font3);
        jt1.setEditable(false);
        jt1.setRows(10);
        jt1.setWrapStyleWord(true);
        jt1.setLineWrap(true);
        this.add(jt1);

        //label
        Font font1 = new Font("Bold", Font.BOLD, 28);
        Label label1;
        label1 = new Label("DICTIONARY BY HAITEN TEAM");
        label1.setBounds(20, 10, 420, 35);
        label1.setFont(font1);
        label1.setBackground(new Color(237, 164, 233));
        this.add(label1);

        Label label2;
        label2 = new Label("Nhập từ cần dịch: ");
        label2.setBounds(20, 45, 150, 40);
        label2.setBackground(new Color(237, 164, 233));
        Font font2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 18);
        label2.setFont(font2);
        this.add(label2);

        //list
        model = new DefaultListModel<>();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            model.addElement(Dictionary.words.get(i).getWord_target());
        }

        myList = new JList<String>(model);
        jScrollPane = new JScrollPane(myList);
        jScrollPane.setBounds(25, 151, 300, 450);
        this.add(jScrollPane);
        this.pack();

//        keyListener
        keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent m) {
                //super.keyTyped(m);
                String s = new String();
                char key = m.getKeyChar();
                int k = key;
                if (k != KeyEvent.VK_BACK_SPACE) {
                    s = textField.getText() + m.getKeyChar();
                } else {
                    s = textField.getText();
                }

                model.removeAllElements();
                model.clear();

                if (s.compareTo("") != 0) {
                    for (int i = 0; i < Dictionary.words.size(); i++) {
                        if (Dictionary.words.get(i).getWord_target().startsWith(s)) {
                            model.addElement(Dictionary.words.get(i).getWord_target());
                        }
                    }
                } else {
                    for (int i = 0; i < Dictionary.words.size(); i++) {
                        model.addElement(Dictionary.words.get(i).getWord_target());
                    }
                }
            }
        };
        textField.addKeyListener(keyListener);

        // listSelection listener
        listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int wordNumber = myList.getSelectedIndex();
                if (wordNumber >= 0) {
                    textField.setText(model.getElementAt(wordNumber));
                }
            }
        };

        myList.addListSelectionListener(listSelectionListener);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int k = 0;
        String string = "\\";
        if (e.getSource().equals(button) || e.getSource().equals(textField)) {
            for (int i = 0; i < Dictionary.words.size(); i++) {
                if (Dictionary.words.get(i).getWord_target().equalsIgnoreCase(textField.getText())) {
                    jt1.setText("Nghĩa của từ: \n" + "          " + Dictionary.words.get(i).getWord_explain()
                            + "\n\n" + "Cách đọc: \n" + "           "
                            + string + Dictionary.words.get(i).getPronounce() + string);
                    jt1.setForeground(Color.BLACK);
                    this.add(jt1);
                } else {
                    k++;
                }
            }
            if (k == Dictionary.words.size()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy từ cần tra!");
            }
        }

        if (e.getSource() == quitButton) {
            int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (kq == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }
        if (e.getSource() == addButton) {
            new addWindow();
        }

        if (e.getSource() == delButton) {
            new deleteWindow();
        }

        if (e.getSource() == lisButton) {
            for (int i = 0; i < Dictionary.words.size(); i++) {
                if (Dictionary.words.get(i).getWord_target().equalsIgnoreCase(textField.getText())) {
                    DictionaryManagement.speakWord_target(i);
                }
            }
        }

        if (e.getSource() == fixButton) {
            new fixWindow();
        }

        if (e.getSource() == apiButton) {
            new AnhViet();
        }

        if (e.getSource() == backButton) {
            this.dispose();
            Dictionary.words.clear();
            new MenuWindow();
        }
    }
}