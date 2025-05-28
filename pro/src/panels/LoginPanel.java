package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(144, 224, 239)); // Pastel blue

        // Title
        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setBounds(50, 60, 300, 44);
        title.setForeground(new Color(60, 60, 60));
        add(title);

        // Subtitle
        JLabel subtitle = new JLabel("Hello, welcome back", SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setBounds(50, 100, 300, 30);
        subtitle.setForeground(new Color(60, 60, 60));
        add(subtitle);

        // Phone Number Field
        JTextField phone = new JTextField("Phone Number");
        phone.setBounds(40, 150, 300, 44);
        phone.setForeground(Color.GRAY);
        phone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        phone.setBackground(Color.WHITE);
        phone.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1, true));
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (phone.getText().equals("Phone Number")) {
                    phone.setText("");
                    phone.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (phone.getText().isEmpty()) {
                    phone.setText("Phone Number");
                    phone.setForeground(Color.GRAY);
                }
            }
        });
        add(phone);

        // Password placeholder field
        JTextField pwPlaceholder = new JTextField("Password");
        pwPlaceholder.setBounds(40, 210, 300, 44);
        pwPlaceholder.setForeground(Color.GRAY);
        pwPlaceholder.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pwPlaceholder.setBackground(Color.WHITE);
        pwPlaceholder.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1, true));
        add(pwPlaceholder);

        // Real password field (hidden by default)
        JPasswordField pwField = new JPasswordField();
        pwField.setBounds(40, 210, 300, 44);
        pwField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pwField.setBackground(Color.WHITE);
        pwField.setForeground(Color.GRAY);
        pwField.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1, true));
        pwField.setVisible(false);
        add(pwField);

        // Swap to password field on focus
        pwPlaceholder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                pwPlaceholder.setVisible(false);
                pwField.setVisible(true);
                pwField.requestFocus();
            }
        });

        // If password field is empty and loses focus, show placeholder again
        pwField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent e) {
                if (new String(pwField.getPassword()).isEmpty()) {
                    pwField.setVisible(false);
                    pwPlaceholder.setVisible(true);
                }
            }
        });

        // Log in Button
        JButton loginBtn = new JButton("Log in");
        loginBtn.setBounds(40, 270, 300, 48);
        loginBtn.setBackground(new Color(120, 115, 245)); // Purple
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(BorderFactory.createEmptyBorder());
        add(loginBtn);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(40, 330, 300, 30);
        statusLabel.setForeground(Color.RED);
        add(statusLabel);

        // Sign up link
        JLabel signupLabel = new JLabel("Don't have an account? ");
        signupLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        signupLabel.setBounds(70, 370, 180, 30);
        signupLabel.setForeground(new Color(60, 60, 60));
        add(signupLabel);

        JLabel signupLink = new JLabel("Sign Up");
        signupLink.setFont(new Font("SansSerif", Font.BOLD, 14));
        signupLink.setBounds(230, 370, 80, 30);
        signupLink.setForeground(new Color(120, 115, 245)); // Purple
        signupLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signupLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                frame.showPanel("register");
            }
        });
        add(signupLink);

        loginBtn.addActionListener(e -> {
            String phoneVal = phone.getText().trim();
            String pwVal = new String(pwField.getPassword()).trim();
            if (frame.accountManager.login(phoneVal, pwVal)) {
                statusLabel.setText("");
                frame.showPanel("wallet"); // Go to home panel
            } else {
                statusLabel.setText("Invalid phone or password.");
            }
        });
    }
}