package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class WelcomePanel extends JPanel {
    public WelcomePanel(MainFrame frame) {
        setLayout(null);

        // Soft purple background
        setBackground(new Color(120, 115, 245)); // Soft purple

        // Logo
        JLabel logo = new JLabel("E-PAY MO", SwingConstants.CENTER);
        logo.setFont(new Font("SansSerif", Font.BOLD, 40));
        logo.setBounds(50, 140, 300, 60);
        logo.setForeground(Color.WHITE); // White logo
        add(logo);

        // Divider line (white)
        JSeparator divider = new JSeparator();
        divider.setBounds(80, 220, 240, 2);
        divider.setForeground(Color.WHITE);
        add(divider);

        // White rounded card for buttons
        JPanel card = new JPanel(null);
        card.setBounds(25, 300, 340, 320);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(120, 115, 245), 1, true));
        add(card);

        JButton startBtn = new JButton("Start an account");
        startBtn.setBounds(20, 40, 300, 48);
        startBtn.setBackground(new Color(144, 224, 239)); // Pastel blue
        startBtn.setForeground(new Color(60, 60, 60));
        startBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        startBtn.setFocusPainted(false);
        startBtn.setBorder(BorderFactory.createLineBorder(new Color(144, 224, 239), 1, true));
        startBtn.addActionListener(e -> frame.showPanel("register"));
        card.add(startBtn);

        JButton loginBtn = new JButton("Log in");
        loginBtn.setBounds(20, 110, 300, 48);
        loginBtn.setBackground(new Color(255, 241, 208)); // Pastel yellow
        loginBtn.setForeground(new Color(60, 60, 60));
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(BorderFactory.createLineBorder(new Color(255, 241, 208), 1, true));
        loginBtn.addActionListener(e -> frame.showPanel("login"));
        card.add(loginBtn);
    }
}