import javax.swing.*;
//import java.awt.*;
import java.awt.event.*; 

public class ATM {
    private static double balance = 15000.00;
    private static JTextArea transactionHistoryArea = new JTextArea();

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel balanceLabel = new JLabel("Balance: ₹" + balance);
        mainPanel.add(balanceLabel);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter amount to withdrawl:");
                double amount = Double.parseDouble(input);
                if (balance >= amount) {
                    balance -= amount;
                    balanceLabel.setText("Balance: ₹" + balance);
                    transactionHistoryArea.append("- ₹" + amount + " (Withdraw)\n");
                } else {
                    JOptionPane.showMessageDialog(null, " SORRY TRY AGAIN,YOU DON'T HVAE ENOGE MONEY .");
                }
            }
        });
        mainPanel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter amount to deposit:");
                double amount = Double.parseDouble(input);
                balance += amount;
                balanceLabel.setText("Balance: ₹" + balance);
                transactionHistoryArea.append("+ ₹" + amount + " (Deposit)\n");
            }
        });
        mainPanel.add(depositButton);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter amount to transfer:");
                double amount = Double.parseDouble(input);
                if (balance >= amount) {
                    String targetAccount = JOptionPane.showInputDialog("Enter target account number:");
                    balance -= amount;
                    balanceLabel.setText("Balance: ₹" + balance);
                    transactionHistoryArea.append("- ₹" + amount + " (Transfer to account " + targetAccount + ")\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
            }
        });
        mainPanel.add(transferButton);

        JButton historyButton = new JButton("Transaction History");
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, new JScrollPane(transactionHistoryArea), "Transaction History", JOptionPane.PLAIN_MESSAGE);
            }
        });
        mainPanel.add(historyButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(quitButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}