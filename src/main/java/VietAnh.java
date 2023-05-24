import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VietAnh implements ActionListener {
    JFrame frame;
    JButton newButton;
    JTextArea text1;
    JTextArea text2;

    VietAnh() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("VtoE");

        JLabel jLabel = new JLabel("Nhập đoạn văn: ");
        jLabel.setBounds(20, 20, 120, 25);
        jLabel.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
        frame.add(jLabel);

        JLabel jLabel2 = new JLabel("Kết quả ");
        jLabel2.setBounds(380, 20, 120, 25);
        jLabel2.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 14));
        frame.add(jLabel2);

        text1 = new JTextArea();
        text1.setBounds(10, 60, 200, 200);
        text1.setWrapStyleWord(true);
        text1.setFont(new Font("Bold", Font.BOLD, 15));
        text1.setLineWrap(true);
        frame.add(text1);

        text2 = new JTextArea();
        text2.setBounds(370, 60, 205, 200);
        text2.setWrapStyleWord(true);
        text2.setFont(new Font("Bold", Font.BOLD, 15));
        text2.setLineWrap(true);
        text2.setEditable(false);
        frame.add(text2);


        newButton = new JButton("Dịch");
        newButton.setFocusable(false);
        newButton.setBounds(250, 120, 80, 30);
        newButton.setLayout(new FlowLayout());
        newButton.addActionListener(this);
        frame.add(newButton);
    }

    public void dictionarytest(String a) throws IOException {
        GoogleAPI googleAPI = new GoogleAPI();
        text2.setText(googleAPI.VtoE(a));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean test = false;
        if (e.getSource() == newButton) {
            try {
                dictionarytest(text1.getText());
            }
            catch (Exception k) {
                k.printStackTrace();
            }
        }
    }
}
