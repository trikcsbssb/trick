package src.panels;
import javax.swing.*;

import pro.MainFrame;

public class ConfirmSendPanel extends JPanel {
    public ConfirmSendPanel(MainFrame frame) {
        setLayout(null);
        setBackground(java.awt.Color.WHITE);

        JButton backBtn = new JButton("\u2039");
        backBtn.setBounds(10, 10, 48, 48);
        backBtn.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 26));
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> frame.showPanel("sendToAccount"));

        JLabel confAcc = new JLabel("HE.F.AF...F.R.\n+00 000 000 0000", SwingConstants.CENTER);
        confAcc.setBounds(50, 60, 300, 30);

        JLabel cashLabel = new JLabel("Cash: 0.00");
        cashLabel.setBounds(50, 110, 140, 20);

        JLabel sendLabel = new JLabel("Amount: 0.00");
        sendLabel.setBounds(50, 140, 140, 20);

        // JLabel totalLabel = new JLabel("Total Amount: ₱ 0.00");
        // totalLabel.setBounds(50, 170, 240, 20);

        JButton sendBtn = new JButton("Send");
        sendBtn.setBounds(50, 210, 300, 44);
        sendBtn.setBackground(new java.awt.Color(220,220,220));
        sendBtn.addActionListener(e -> frame.showPanel("receipt"));

        add(backBtn); add(confAcc); add(cashLabel); add(sendLabel);add(sendBtn);
    }
}