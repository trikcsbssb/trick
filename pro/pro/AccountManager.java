package pro;

public class AccountManager {
    private String phone;
    private String password;
    private boolean registered = false;
    private double balance = 100_000.00; // Default balance

    private String currentUserName;
    private String currentUserNumber;
    private String currentUserGmail;

    public boolean isRegistered() {
        return registered;
    }

    public boolean register(String phone, String password) {
        if (!registered) {
            this.phone = phone;
            this.password = password;
            registered = true;
            balance = 100_000.00; // Reset balance on new registration
            return true;
        }
        return false;
    }

    public boolean login(String phone, String password) {
        return registered && this.phone.equals(phone) && this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public boolean sendMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Call this after registration or login
    public void setCurrentUser(String name, String number, String gmail) {
        this.currentUserName = name;
        this.currentUserNumber = number;
        this.currentUserGmail = gmail;
    }

    public String getCurrentUserName() {
        return currentUserName != null ? currentUserName : "";
    }

    public String getCurrentUserNumber() {
        return currentUserNumber != null ? currentUserNumber : "";
    }

    public String getCurrentUserGmail() {
        return currentUserGmail != null ? currentUserGmail : "";
    }
}
