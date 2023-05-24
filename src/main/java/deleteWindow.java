import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteWindow implements ActionListener {
    JFrame frame;
    JButton newButton;
    JTextField text1;
    JTextField text2;

    deleteWindow() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Add New Word");

        JLabel jLabel = new JLabel("Từ cần xóa: ");
        jLabel.setBounds(20, 20, 120, 25);
        jLabel.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
        frame.add(jLabel);

        text1 = new JTextField();
        text1.setBounds(30, 50, 220, 30);
        frame.add(text1);

        newButton = new JButton("Xóa");
        newButton.setFocusable(false);
        newButton.setBounds(30, 100, 80, 30);
        newButton.setLayout(new FlowLayout());
        newButton.addActionListener(this);
        frame.add(newButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean test = false;
        int k = 0;
        if (e.getSource() == newButton) {
            String a = text1.getText();
            if (!a.equals("")) {
                Word w = new Word();
                w.setWord_target(a);
                for (int i = 0; i < Dictionary.words.size(); i++) {
                    k++;
                    if (Dictionary.words.get(i).getWord_target().equalsIgnoreCase(a)) {
                        test = true;
                        break;
                    }
                }
                if (test && Dictionary.check) {
                    Dictionary.words.remove(k - 1);
                    DictionaryManagement.dictionaryExportToDatabase("av");
                    JOptionPane.showMessageDialog(null, "Đã xóa từ!");
                } else if (Dictionary.check) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy từ cần xóa!");
                }

                if (test && !Dictionary.check) {
                    Dictionary.words.remove(k - 1);
                    DictionaryManagement.dictionaryExportToDatabase("va");
                    JOptionPane.showMessageDialog(null, "Đã xóa từ!");
                } else if (!Dictionary.check){
                    JOptionPane.showMessageDialog(null, "Không tìm thấy từ cần xóa!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mời bạn nhập đầy đủ từ!");
            }
        }
    }
}
