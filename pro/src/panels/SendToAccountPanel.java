package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class SendToAccountPanel extends JPanel {
    public SendToAccountPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(144, 224, 239)); // Pastel blue background to match home

        // Back Button
        JButton backBtn = new JButton("\u2039");
        backBtn.setBounds(10, 10, 48, 48);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 26));
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> frame.showPanel("wallet"));
        add(backBtn);

        // Logo
        JLabel logo = new JLabel("E-PAY");
        logo.setFont(new Font("SansSerif", Font.PLAIN, 36));
        logo.setBounds(140, 25, 160, 50);
        add(logo);

        // Send to label
        JLabel sendToLabel = new JLabel("Send to");
        sendToLabel.setBounds(50, 90, 100, 20);
        add(sendToLabel);

        // Phone panel (country code + phone)
        JPanel phonePanel = new JPanel(null);
        phonePanel.setBackground(new Color(238,238,238));
        phonePanel.setBounds(20, 115, 340, 40);

        JTextField code = new JTextField("+63");
        code.setBounds(0, 0, 50, 40);
        code.setFont(new Font("SansSerif", Font.PLAIN, 16));
        code.setHorizontalAlignment(JTextField.CENTER);
        code.setBorder(BorderFactory.createEmptyBorder());
        code.setBackground(new Color(238,238,238));
        code.setEditable(false);

        JTextField phone = new JTextField("000 000 0000");
        phone.setBounds(54, 0, 200, 40);
        phone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        phone.setForeground(Color.GRAY);
        phone.setBorder(BorderFactory.createEmptyBorder());
        phone.setBackground(new Color(238,238,238));
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (phone.getText().equals("000 000 0000")) {
                    phone.setText("");
                    phone.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (phone.getText().isEmpty()) {
                    phone.setText("000 000 0000");
                    phone.setForeground(Color.GRAY);
                }
            }
        });

        phonePanel.add(code);
        phonePanel.add(phone);
        add(phonePanel);

        // Amount label
        JLabel amountLab = new JLabel("Amount");
        amountLab.setFont(new Font("SansSerif", Font.PLAIN, 14));
        amountLab.setBounds(24, 195, 100, 18);
        add(amountLab);

        // Amount field
        JTextField amount = new JTextField("₱ 0.0000");
        amount.setBounds(20, 215, 340, 40);
        amount.setFont(new Font("SansSerif", Font.PLAIN, 16));
        amount.setForeground(Color.GRAY);
        amount.setBackground(new Color(238,238,238));
        amount.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (amount.getText().equals("₱ 0.0000")) {
                    amount.setText("");
                    amount.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (amount.getText().isEmpty()) {
                    amount.setText("₱ 0.0000");
                    amount.setForeground(Color.GRAY);
                }
            }
        });
        add(amount);

        // Next button
        JButton nextBtn = new JButton("Send");
        nextBtn.setBounds(40, 290, 300, 40); // Same x and width as the input fields
        nextBtn.setBackground(new Color(220,220,220));
        nextBtn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        nextBtn.setFocusPainted(false);
        nextBtn.setBorder(BorderFactory.createLineBorder(new Color(160,160,160), 1, false)); // Thin border
        add(nextBtn);

        // Add a label for feedback
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(40, 340, 300, 30);
        statusLabel.setForeground(Color.RED);
        add(statusLabel);

        nextBtn.addActionListener(e -> {
            String amountText = amount.getText().replace("₱", "").replace(",", "").trim();
            double amt = 0;
            try {
                amt = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                statusLabel.setText("Enter a valid amount.");
                return;
            }
            if (amt <= 0) {
                statusLabel.setText("Amount must be greater than 0.");
                return;
            }
            // Deduct balance
            if (!frame.accountManager.sendMoney(amt)) {
                statusLabel.setText("Insufficient balance.");
                return;
            }
            statusLabel.setText("");
            String phoneNumber = phone.getText().trim();

            String ref = String.valueOf((int)(Math.random() * 900_000_000) + 100_000_000);
            String date = java.time.LocalDate.now().toString();

            // Update receipt panel with transaction details
            for (Component comp : frame.container.getComponents()) {
                if (comp instanceof ReceiptPanel) {
                    ((ReceiptPanel) comp).setReceiptData(amt, ref, date, phoneNumber);
                    break;
                }
            }

            // Clear fields after successful transfer
            phone.setText("000 000 0000");
            phone.setForeground(Color.GRAY);
            amount.setText("₱ 0.0000");
            amount.setForeground(Color.GRAY);

            // Update wallet panel balance
            for (Component comp : frame.container.getComponents()) {
                if (comp instanceof WalletPanel) {
                    ((WalletPanel) comp).updateBalance(frame);
                    break;
                }
            }
            // Show the receipt panel instead of wallet
            frame.showPanel("receipt");
        });
    }
}