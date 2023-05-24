import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addWindow implements ActionListener {
    JFrame frame;
    JButton newButton;
    JTextField text1;
    JTextField text2;

    addWindow() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Add New Word");

        JLabel jLabel = new JLabel("Từ cần thêm: ");
        jLabel.setBounds(20, 20, 120, 25);
        jLabel.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
        frame.add(jLabel);

        text1 = new JTextField();
        text1.setBounds(50, 50, 250, 30);
        frame.add(text1);

        JLabel jLabel2 = new JLabel("Nghĩa của từ: ");
        jLabel2.setBounds(20, 90, 120, 25);
        jLabel2.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
        frame.add(jLabel2);

        text2 = new JTextField();
        text2.setBounds(50, 120, 250, 30);
        frame.add(text2);

        newButton = new JButton("Thêm");
        newButton.setFocusable(false);
        newButton.setBounds(140, 170, 80, 30);
        newButton.setLayout(new FlowLayout());
        newButton.addActionListener(this);
        frame.add(newButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean test = false;
        if (e.getSource() == newButton) {
            String a = text1.getText();
            String b = text2.getText();
            if (!a.equals("") && !b.equals("")) {
                Word w = new Word(a, b);
                for (int i = 0; i < Dictionary.words.size(); i++) {
                    if (Dictionary.words.get(i).getWord_target().equalsIgnoreCase(a)) {
                        test = true;
                        break;
                    }
                }
                if (test && Dictionary.check) {
                    JOptionPane.showMessageDialog(null, "Từ đã tồn tại!");
                } else if (Dictionary.check){
                    Dictionary.words.add(w);
                    DictionaryManagement.dictionaryExportToDatabase("av");
                    JOptionPane.showMessageDialog(null, "Đã thêm từ!");
                }

                if (test && !Dictionary.check) {
                    JOptionPane.showMessageDialog(null, "Từ đã tồn tại!");
                } else if (!Dictionary.check){
                    Dictionary.words.add(w);
                    DictionaryManagement.dictionaryExportToDatabase("va");
                    JOptionPane.showMessageDialog(null, "Đã thêm từ!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mời bạn nhập đầy đủ từ và nghĩa!");
            }
        }
    }
}
