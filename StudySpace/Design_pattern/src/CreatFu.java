import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatFu {
    public static void main(String[] args) {
        demo2();
    }

    static public void demo2() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();
        jLabel.setFont(new Font("黑体", Font.BOLD, 120));
        jLabel.setText("福");
        JPanel jPanel2 = new JPanel();
        JButton jButton = new JButton("字体");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("字体");
                Font font = jLabel.getFont();
                font.deriveFont(Font.BOLD, font.getSize() + 10);
                jLabel.setFont(font);
                jLabel.updateUI();
            }
        });
        JButton jButton2 = new JButton("字号");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("字号");
            }
        });
        jPanel2.add(jButton);
        jPanel2.add(jButton2);
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        jFrame.add(jPanel2, BorderLayout.NORTH);
        jPanel.add(jLabel, BorderLayout.CENTER);
        jPanel.setSize(300, 200);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setSize(300, 400);
        jFrame.setLocation(100, 100);
    }
}
