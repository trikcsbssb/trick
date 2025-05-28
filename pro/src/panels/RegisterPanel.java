package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class RegisterPanel extends JPanel {
    // Declare as instance variables so all methods can access them
    private JTextField first, mid, last, email, phone, pwText;
    private JCheckBox noMid;
    private JLabel statusLabel;

    public RegisterPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(255, 241, 208)); // Peach background

        JButton backBtn = new JButton("\u2039");
        backBtn.setBounds(10, 10, 48, 48);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 26));
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setForeground(new Color(60, 60, 60));
        backBtn.addActionListener(e -> frame.showPanel("welcome"));

        JLabel title = new JLabel("Start an Account", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.PLAIN, 28));
        title.setBounds(50, 60, 300, 44);
        title.setForeground(new Color(60, 60, 60));

        // White card for fields
        JPanel card = new JPanel(null);
        card.setBounds(16, 120, 350, 430);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 241, 208), 1, true));

        // Now assign to the instance variables
        first = new JTextField("Enter first name");
        first.setBounds(25, 10, 300, 40);
        first.setForeground(Color.GRAY);
        first.setFont(new Font("SansSerif", Font.PLAIN, 16));
        first.setBackground(new Color(245,245,245));
        first.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        first.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (first.getText().equals("Enter first name")) {
                    first.setText("");
                    first.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (first.getText().isEmpty()) {
                    first.setText("Enter first name");
                    first.setForeground(Color.GRAY);
                }
            }
        });

        mid = new JTextField("Enter middle name");
        mid.setBounds(25, 60, 300, 40);
        mid.setForeground(Color.GRAY);
        mid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        mid.setBackground(new Color(245,245,245));
        mid.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        mid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (mid.getText().equals("Enter middle name")) {
                    mid.setText("");
                    mid.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (mid.getText().isEmpty()) {
                    mid.setText("Enter middle name");
                    mid.setForeground(Color.GRAY);
                }
            }
        });

        noMid = new JCheckBox("I have no legal middle name");
        noMid.setBounds(25, 105, 300, 20);
        noMid.setBackground(Color.WHITE);
        noMid.setFont(new Font("SansSerif", Font.PLAIN, 13));

        last = new JTextField("Enter last name");
        last.setBounds(25, 130, 300, 40);
        last.setForeground(Color.GRAY);
        last.setFont(new Font("SansSerif", Font.PLAIN, 16));
        last.setBackground(new Color(245,245,245));
        last.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        last.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (last.getText().equals("Enter last name")) {
                    last.setText("");
                    last.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (last.getText().isEmpty()) {
                    last.setText("Enter last name");
                    last.setForeground(Color.GRAY);
                }
            }
        });

        email = new JTextField("Enter email address");
        email.setBounds(25, 180, 300, 40);
        email.setForeground(Color.GRAY);
        email.setFont(new Font("SansSerif", Font.PLAIN, 16));
        email.setBackground(new Color(245,245,245));
        email.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (email.getText().equals("Enter email address")) {
                    email.setText("");
                    email.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (email.getText().isEmpty()) {
                    email.setText("Enter email address");
                    email.setForeground(Color.GRAY);
                }
            }
        });

        phone = new JTextField("Enter phone number");
        phone.setBounds(25, 230, 300, 40);
        phone.setForeground(Color.GRAY);
        phone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        phone.setBackground(new Color(245,245,245));
        phone.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (phone.getText().equals("Enter phone number")) {
                    phone.setText("");
                    phone.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (phone.getText().isEmpty()) {
                    phone.setText("Enter phone number");
                    phone.setForeground(Color.GRAY);
                }
            }
        });

        pwText = new JTextField("Enter password");
        pwText.setBounds(25, 280, 300, 40);
        pwText.setForeground(Color.GRAY);
        pwText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        pwText.setBackground(new Color(245,245,245));
        pwText.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        pwText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (pwText.getText().equals("Enter password")) {
                    pwText.setText("");
                    pwText.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (pwText.getText().isEmpty()) {
                    pwText.setText("Enter password");
                    pwText.setForeground(Color.GRAY);
                }
            }
        });

        JButton contBtn = new JButton("Continue");
        contBtn.setBounds(25, 340, 300, 48);
        contBtn.setBackground(new Color(144, 224, 239)); // Pastel blue
        contBtn.setForeground(new Color(60, 60, 60));
        contBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        contBtn.setFocusPainted(false);
        contBtn.setBorder(BorderFactory.createEmptyBorder());

        statusLabel = new JLabel("");
        statusLabel.setBounds(25, 400, 300, 30);
        statusLabel.setForeground(Color.RED);

        contBtn.addActionListener(e -> {
            String firstName = first.getText().trim();
            String middleName = mid.getText().trim();
            String lastName = last.getText().trim();
            String emailVal = email.getText().trim();
            String phoneVal = phone.getText().trim();
            String pwVal = pwText.getText().trim();

            String fullName = firstName +
                (noMid.isSelected() ? "" : (" " + middleName)) +
                " " + lastName;

            if (firstName.isEmpty() || firstName.equals("Enter first name") ||
                (!noMid.isSelected() && (middleName.isEmpty() || middleName.equals("Enter middle name"))) ||
                lastName.isEmpty() || lastName.equals("Enter last name") ||
                emailVal.isEmpty() || emailVal.equals("Enter email address") ||
                phoneVal.isEmpty() || phoneVal.equals("Enter phone number") ||
                pwVal.isEmpty() || pwVal.equals("Enter password")) {
                statusLabel.setText("Please fill in all required fields.");
            } else {
                boolean success = frame.accountManager.register(phoneVal, pwVal);
                if (success) {
                    statusLabel.setText("");
                    frame.accountManager.setCurrentUser(fullName, phoneVal, emailVal);
                    resetFields(); // <-- clear all fields after successful registration
                    frame.showPanel("login");
                } else {
                    statusLabel.setText("Already registered.");
                }
            }
        });

        card.add(first); card.add(mid); card.add(noMid); card.add(last); card.add(email);
        card.add(phone); card.add(pwText); card.add(contBtn); card.add(statusLabel);

        add(backBtn); add(title); add(card);
    }

    public void resetFields() {
        first.setText("Enter first name");
        first.setForeground(Color.GRAY);

        mid.setText("Enter middle name");
        mid.setForeground(Color.GRAY);

        last.setText("Enter last name");
        last.setForeground(Color.GRAY);

        email.setText("Enter email address");
        email.setForeground(Color.GRAY);

        phone.setText("Enter phone number");
        phone.setForeground(Color.GRAY);

        pwText.setText("Enter password");
        pwText.setForeground(Color.GRAY);

        noMid.setSelected(false);
        statusLabel.setText("");
    }

      // Example for MainFrame.java
    // Make sure to pass CardLayout and container as parameters
    public void resetRegisterPanel(Container container, CardLayout cardLayout) {
        RegisterPanel registerPanel = (RegisterPanel) container.getComponent(2);
        registerPanel.resetFields();
        cardLayout.show(container, "register");
    }

}