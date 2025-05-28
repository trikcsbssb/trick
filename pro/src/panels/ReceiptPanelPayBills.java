package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class ReceiptPanelPayBills extends JPanel {
    private JLabel billerLab;
    private JLabel amountVal;
    private JLabel refLab;
    private JLabel dateLab;

    public ReceiptPanelPayBills(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(255, 241, 208)); // Match WelcomePanel pastel peach

        JButton backBtn = new JButton("\u2039");
        backBtn.setBounds(10, 10, 48, 48);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 26));
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> frame.showPanel("wallet"));
        add(backBtn);

        JLabel title = new JLabel("Payment Receipt", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setBounds(60, 30, 280, 40);
        add(title);

        JPanel box = new JPanel(null);
        box.setBounds(20, 90, 340, 220);
        box.setBackground(Color.WHITE); // Keep box white for contrast
        box.setBorder(BorderFactory.createLineBorder(new Color(0,120,255), 2, true));
        add(box);

        billerLab = new JLabel("Biller: ", SwingConstants.LEFT);
        billerLab.setFont(new Font("SansSerif", Font.BOLD, 16));
        billerLab.setBounds(20, 20, 300, 24);
        box.add(billerLab);

        JLabel amountText = new JLabel("Amount Paid:");
        amountText.setFont(new Font("SansSerif", Font.PLAIN, 15));
        amountText.setBounds(20, 60, 120, 24);
        box.add(amountText);

        amountVal = new JLabel("\u20B1 0.00", SwingConstants.RIGHT);
        amountVal.setFont(new Font("SansSerif", Font.PLAIN, 15));
        amountVal.setBounds(180, 60, 120, 24);
        box.add(amountVal);

        refLab = new JLabel("Ref. No. 000000000", SwingConstants.LEFT);
        refLab.setFont(new Font("SansSerif", Font.PLAIN, 13));
        refLab.setBounds(20, 110, 300, 20);
        box.add(refLab);

        dateLab = new JLabel("Date: YYYY-MM-DD", SwingConstants.LEFT);
        dateLab.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLab.setBounds(20, 140, 300, 20);
        box.add(dateLab);
    }

    // Call this before showing the receipt
    public void setReceiptData(double amount, String ref, String date, String biller) {
        billerLab.setText("Biller: " + biller);
        amountVal.setText(String.format("\u20B1 %,.2f", amount));
        refLab.setText("Ref. No. " + ref);
        dateLab.setText("Date: " + date);
    }
}