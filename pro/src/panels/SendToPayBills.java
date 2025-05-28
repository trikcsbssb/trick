package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class SendToPayBills extends JPanel {
    public SendToPayBills(MainFrame frame) {
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

        // Biller name field (move below phone panel)
        JTextField biller = new JTextField("Enter biller name");
        biller.setBounds(20, 165, 340, 40); // <-- changed Y position to 165
        biller.setForeground(Color.GRAY);
        biller.setFont(new Font("SansSerif", Font.PLAIN, 16));
        biller.setBackground(new Color(238,238,238));
        biller.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        biller.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (biller.getText().equals("Enter biller name")) {
                    biller.setText("");
                    biller.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (biller.getText().isEmpty()) {
                    biller.setText("Enter biller name");
                    biller.setForeground(Color.GRAY);
                }
            }
        });
        add(biller);

        // Amount field (move below biller)
        JTextField amount = new JTextField("₱ 0.0000");
        amount.setBounds(20, 215, 340, 40); // <-- changed Y position to 215
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
        JButton nextBtn = new JButton("Pay Bills");
        nextBtn.setBounds(40, 270, 300, 40);
        nextBtn.setBackground(new Color(220,220,220));
        nextBtn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        nextBtn.setFocusPainted(false);
        nextBtn.setBorder(BorderFactory.createLineBorder(new Color(160,160,160), 1, false));
        nextBtn.addActionListener(e -> frame.showPanel("ReceiptPanelPayBills")); // Placeholder action
        add(nextBtn);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(40, 320, 300, 30);
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
            if (!frame.accountManager.sendMoney(amt)) {
                statusLabel.setText("Insufficient balance.");
                return;
            }
            statusLabel.setText("");
            String billerName = biller.getText().trim();

            String ref = String.valueOf((int)(Math.random()*900_000_000) + 100_000_000);
            String date = java.time.LocalDate.now().toString();

            // Update receipt panel with transaction details
            for (Component comp : frame.container.getComponents()) {
                if (comp instanceof ReceiptPanel) {
                    ((ReceiptPanel) comp).setReceiptData(amt, ref, date, billerName);
                    break;
                }
            }

            // Clear fields after successful payment
            phone.setText("000 000 0000");
            phone.setForeground(Color.GRAY);
            biller.setText("Enter biller name");
            biller.setForeground(Color.GRAY);
            amount.setText("₱ 0.0000");
            amount.setForeground(Color.GRAY);

            // Update wallet panel balance
            for (Component comp : frame.container.getComponents()) {
                if (comp instanceof WalletPanel) {
                    ((WalletPanel) comp).updateBalance(frame);
                    break;
                }
            }

            // Show the receipt panel
            frame.showPanel("receipt");
        });
    }
}