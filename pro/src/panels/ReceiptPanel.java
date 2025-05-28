package src.panels;
import javax.swing.*;
import java.awt.*;
import pro.MainFrame;

public class ReceiptPanel extends JPanel {
    private JLabel amountVal;
    private JLabel totalVal;
    private JLabel refLab;
    private JLabel dateLab;
    private JLabel phoneLab;

    public ReceiptPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(255, 241, 208)); // Match WelcomePanel pastel peach

        JButton backBtn = new JButton("\u2039");
        backBtn.setBounds(10, 10, 48, 48);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 26));
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> frame.showPanel("wallet"));

        JPanel box = new JPanel(null);
        box.setBounds(11, 60, 360, 340);
        box.setBackground(Color.WHITE); // Keep box white for contrast
        box.setBorder(BorderFactory.createLineBorder(new Color(0,120,255), 2, true));

        JLabel nameLab = new JLabel("HE.F AF....F R.", SwingConstants.CENTER);
        nameLab.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLab.setBounds(20, 20, 320, 24);
        box.add(nameLab);

        phoneLab = new JLabel("+00 000 000 0000", SwingConstants.CENTER);
        phoneLab.setFont(new Font("SansSerif", Font.BOLD, 16));
        phoneLab.setBounds(20, 44, 320, 20);
        box.add(phoneLab);

        // Line 1
        JSeparator sep1 = new JSeparator();
        sep1.setBounds(20, 74, 320, 2);
        box.add(sep1);

        // Amount row
        JLabel amountText = new JLabel("Amount");
        amountText.setFont(new Font("SansSerif", Font.PLAIN, 15));
        amountText.setBounds(30, 80, 100, 24);
        box.add(amountText);

        amountVal = new JLabel("0.00", SwingConstants.RIGHT);
        amountVal.setFont(new Font("SansSerif", Font.PLAIN, 15));
        amountVal.setBounds(220, 80, 110, 24);
        box.add(amountVal);

        // Line 2
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(20, 110, 320, 2);
        box.add(sep2);

        // Total row
        JLabel totalText = new JLabel("Total Amount Sent");
        totalText.setFont(new Font("SansSerif", Font.PLAIN, 15));
        totalText.setBounds(30, 120, 200, 24);
        box.add(totalText);

        totalVal = new JLabel("\u20B1 0.00", SwingConstants.RIGHT);
        totalVal.setFont(new Font("SansSerif", Font.PLAIN, 15));
        totalVal.setBounds(220, 120, 110, 24);
        box.add(totalVal);

        // Reference and date
        refLab = new JLabel("Ref. No. 000 000 000");
        refLab.setFont(new Font("SansSerif", Font.PLAIN, 13));
        refLab.setBounds(30, 180, 200, 20);
        box.add(refLab);

        dateLab = new JLabel("December 50, 3020");
        dateLab.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLab.setBounds(30, 200, 200, 20);
        box.add(dateLab);

        add(backBtn);
        add(box);
    }

    // Call this method before showing the receipt
    public void setReceiptData(double amount, String ref, String date, String phone) {
        amountVal.setText(String.format("\u20B1 %,.2f", amount));
        totalVal.setText(String.format("\u20B1 %,.2f", amount));
        refLab.setText("Ref. No. " + ref);
        dateLab.setText(date);
        phoneLab.setText(phone); // This sets the phone number label
    }
}