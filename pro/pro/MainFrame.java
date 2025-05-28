package pro;

import javax.swing.*;
import java.awt.*;
import src.panels.*;

public class MainFrame extends JFrame {
    public CardLayout cardLayout = new CardLayout();
    public JPanel container = new JPanel(cardLayout);
    public AccountManager accountManager = new AccountManager();

    //main frame class for the mobile app UI
    public MainFrame() {
        setTitle("Pay-App");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Pass MainFrame to panels so they can call showPanel and access accountManager
        container.add(new WelcomePanel(this), "welcome");
        container.add(new LoginPanel(this), "login");
        container.add(new RegisterPanel(this), "register");
        container.add(new WalletPanel(this), "wallet");
        container.add(new SendToAccountPanel(this), "sendToAccount");
        container.add(new ConfirmSendPanel(this), "confirmSend");
        container.add(new ReceiptPanel(this), "receipt");
        container.add(new SendToPayBills(this), "sendToPayBills");
        container.add(new ReceiptPanelPayBills(this), "payBills");
        // Branches/loops
        // container.add(new StartYourLoginDetailsPanel(this), "startYourLoginDetails");
        //container.add(new CompanyBankSendPanel(this), "companyBankSend");

        setContentPane(container);
        setLocationRelativeTo(null);
        setVisible(true);

        showPanel("welcome");
    }

    //display the panel based on the name
    public void showPanel(String name) {
        cardLayout.show(container, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
    
    
  
}