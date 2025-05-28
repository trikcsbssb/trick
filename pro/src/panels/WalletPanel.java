package src.panels;
import javax.swing.*;
import pro.MainFrame;
import java.awt.*;

public class WalletPanel extends JPanel {
    private JLabel balanceLabel;

    public WalletPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(144, 224, 239)); // Pastel blue background

        JLabel logo = new JLabel("E-PAY");
        logo.setFont(new Font("SansSerif", Font.PLAIN, 22));
        logo.setBounds(50, 30, 100, 30);
        logo.setForeground(new Color(60, 60, 60));

        JLabel walletLab = new JLabel("Wallet");
        walletLab.setFont(new Font("SansSerif", Font.PLAIN, 14));
        walletLab.setBounds(50, 55, 100, 16);
        walletLab.setForeground(new Color(60, 60, 60));

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("SansSerif", Font.PLAIN, 26));
        balanceLabel.setBounds(50, 90, 300, 44);
        balanceLabel.setForeground(new Color(60, 60, 60));
        updateBalance(frame);

        JButton sendBtn = new JButton("Send to other ITFinance account");
        sendBtn.setBounds(42, 200, 300, 44);
        sendBtn.setBackground(new Color(255, 241, 208)); // Match WelcomePanel pastel peach
        sendBtn.setForeground(new Color(60, 60, 60));
        sendBtn.setFocusPainted(false);
        sendBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        sendBtn.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1, true));
        sendBtn.addActionListener(e -> frame.showPanel("sendToAccount"));

        JButton transferBtn = new JButton("Pay-Bills");
        transferBtn.setBounds(42, 250, 300, 44);
        transferBtn.setBackground(new Color(255, 241, 208)); // Match WelcomePanel pastel peach
        transferBtn.setForeground(new Color(60, 60, 60));
        transferBtn.setFocusPainted(false);
        transferBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        transferBtn.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1, true));
        transferBtn.addActionListener(e -> frame.showPanel("sendToPayBills"));

        // Profile menu button (top right)
        JButton profileBtn = new JButton("\u2630"); // ☰ menu icon
        profileBtn.setBounds(320, 30, 40, 40);
        profileBtn.setFont(new Font("SansSerif", Font.BOLD, 22));
        profileBtn.setFocusPainted(false);
        profileBtn.setBorderPainted(false);
        profileBtn.setContentAreaFilled(false);
        profileBtn.setForeground(new Color(60, 60, 60));
        add(profileBtn);

        profileBtn.addActionListener(e -> {
            // Get user info from AccountManager
            String name = frame.accountManager.getCurrentUserName();
            String number = frame.accountManager.getCurrentUserNumber();
            String gmail = frame.accountManager.getCurrentUserGmail();

            // Create and style the profile dialog
            JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), "Profile", Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setUndecorated(true); // Remove window borders for floating effect
            dialog.setSize(340, 260);
            dialog.setLocationRelativeTo(this);

            // Create a rounded panel with drop shadow
            JPanel content = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    // Drop shadow
                    g2.setColor(new Color(0, 0, 0, 40));
                    g2.fillRoundRect(8, 8, getWidth() - 16, getHeight() - 16, 32, 32);
                    // Main panel
                    g2.setColor(new Color(255, 241, 208));
                    g2.fillRoundRect(0, 0, getWidth() - 8, getHeight() - 8, 28, 28);
                    g2.dispose();
                }
            };
            content.setLayout(null);
            content.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
            dialog.setContentPane(content);

            JLabel title = new JLabel("Profile", SwingConstants.CENTER);
            title.setFont(new Font("SansSerif", Font.BOLD, 22));
            title.setBounds(0, 18, 340, 32);
            title.setForeground(new Color(60, 60, 60));
            content.add(title);

            JLabel nameLabel = new JLabel("Name: " + name, SwingConstants.CENTER);
            nameLabel.setBounds(0, 60, 340, 28);
            nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            nameLabel.setForeground(new Color(60, 60, 60));
            content.add(nameLabel);

            JLabel numberLabel = new JLabel("Number: " + number, SwingConstants.CENTER);
            numberLabel.setBounds(0, 95, 340, 28);
            numberLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            numberLabel.setForeground(new Color(60, 60, 60));
            content.add(numberLabel);

            JLabel gmailLabel = new JLabel("Gmail: " + gmail, SwingConstants.CENTER);
            gmailLabel.setBounds(0, 130, 340, 28);
            gmailLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            gmailLabel.setForeground(new Color(60, 60, 60));
            content.add(gmailLabel);

            JButton closeBtn = new JButton("Close");
            closeBtn.setBounds(120, 180, 100, 36);
            closeBtn.setBackground(new Color(144, 224, 239));
            closeBtn.setForeground(new Color(60, 60, 60));
            closeBtn.setFocusPainted(false);
            closeBtn.setFont(new Font("SansSerif", Font.BOLD, 15));
            closeBtn.setBorder(BorderFactory.createEmptyBorder());
            closeBtn.addActionListener(ev -> dialog.dispose());
            content.add(closeBtn);

            dialog.setVisible(true);
        });

        add(logo);
        add(walletLab);
        add(balanceLabel);
        add(sendBtn);
        add(transferBtn);
    }

    // Call this method whenever you want to refresh the balance display
    public void updateBalance(MainFrame frame) {
        balanceLabel.setText("₱ " + String.format("%,.2f", frame.accountManager.getBalance()));
    }
}