# OOP Concepts Used in This Program

This program demonstrates several core Object-Oriented Programming (OOP) concepts in Java:

---

## 1. **Encapsulation**

**Example: AccountManager.java**
```java
public class AccountManager {
    private String phone;
    private String password;
    private double balance = 100_000.00;

    public boolean register(String phone, String password) { ... }
    public boolean sendMoney(double amount) { ... }
    public double getBalance() { return balance; }
}
```
- Fields are private and accessed/modified via public methods.

---

## 2. **Abstraction**

**Example: RegisterPanel.java**
```java
public class RegisterPanel extends JPanel {
    // UI setup and logic hidden from the user
    public RegisterPanel(MainFrame frame) { ... }
}
```
- The user interacts with a simple interface, while the implementation details are abstracted away.

---

## 3. **Inheritance**

**Example: All panels**
```java
public class WalletPanel extends JPanel { ... }
public class SendToAccountPanel extends JPanel { ... }
public class ReceiptPanel extends JPanel { ... }
```
- All panels inherit from `JPanel`, gaining its properties and methods.

---

## 4. **Polymorphism**

**Example: Switching panels and updating components**
```java
for (Component comp : frame.container.getComponents()) {
    if (comp instanceof WalletPanel) {
        ((WalletPanel) comp).updateBalance(frame);
    }
}
```
- The program treats all components as `Component` but uses their specific type when needed.

---

## 5. **Modularity**

**Example: MainFrame.java**
```java
container.add(new RegisterPanel(this), "register");
container.add(new WalletPanel(this), "wallet");
container.add(new SendToAccountPanel(this), "sendToAccount");
container.add(new ReceiptPanel(this), "receipt");
```
- Each feature is separated into its own class/file for clarity and maintainability.

---

**Summary:**  
This program uses encapsulation, abstraction, inheritance, and polymorphism—core OOP concepts—to create a modular, maintainable, and user-friendly Java Swing application.