import java.util.Scanner;

class BankAccount{
    String name;
    String username;
    String password;
    String accountNumber;
    float balance = 5000001f;
    int transaction = 0;
    String transactionHistory = "";

    public void register(Scanner sc) {
        System.out.println("\nEnter Your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter Your Username: ");
        this.username = sc.nextLine();
        System.out.println("\nEnter Your Password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter Your Account Number: ");
        this.accountNumber = sc.nextLine();
        System.out.println("\nRegistration Successful. Please log in to your Bank Account");
    }
    public boolean login(Scanner sc) {
        boolean isLogin = false;
        while (!isLogin) {
            System.out.println("\nEnter your username:");
            String inputUsername = sc.nextLine();
            if (inputUsername.equals(this.username)) {
                while (!isLogin) {
                    System.out.println("\nEnter your password:");
                    String inputPassword = sc.nextLine();
                    if (inputPassword.equals(this.password)) {
                        System.out.println("\nLogin successful");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }
    public void withdraw(Scanner sc) {
        System.out.println("\nEnter Amount to withdraw:");
        float amount = sc.nextFloat();
        sc.nextLine(); // Consume newline left-over
        if (balance >= amount) {
            transaction++;
            balance -= amount;
            System.out.println("\nWithdraw successful.");
            String str = amount + " Rs withdrawn\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nInsufficient balance");
        }
    }


    public void deposit(Scanner sc) {
        System.out.println("\nEnter Amount to deposit:");
        float amount = sc.nextFloat();
        sc.nextLine(); // Consume newline left-over
        if (amount <= 10000f) {
            transaction++;
            balance += amount;
            System.out.println("\nDeposit successful.");
            String str = amount + " Rs deposited\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nSorry, the deposit limit is 10000 Rs.");
        }
    }

    public void transfer(Scanner sc) {
        System.out.println("\nEnter Recipient's Name:");
        String recipient = sc.nextLine();
        System.out.println("\nEnter Amount to transfer:");
        float amount = sc.nextFloat();
        sc.nextLine(); // Consume newline left-over
        if (balance >= amount) {
            if (amount <= 50000f) {
                transaction++;
                balance -= amount;
                System.out.println("\nSuccessfully transferred to " + recipient);
                String str = amount + " Rs transferred to " + recipient + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry, the transfer limit is 50000 Rs.");
            }
        } else {
            System.out.println("\nInsufficient Balance.");
        }
    }


    public void checkBalance() {
        System.out.println("\nBalance: " + balance + " Rs");
    }

    public void transHistory() {
        if (transaction == 0) {
            System.out.println("No transactions happened");
        } else {
            System.out.println("\nTransaction History:\n" + transactionHistory);
        }
    }
}
public class Atm_Interface {
    public static int takeIntegerInput(int limit, Scanner sc) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                input = sc.nextInt();
                flag = true;
                if (input > limit || input < 1) {
                    System.out.println("Choose a number between 1 and " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value.");
                sc.nextLine(); // Clear the buffer
                flag = false;
            }
        }
        sc.nextLine(); // Consume newline left-over
        return input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n******** WELCOME TO ATM INTERFACE ********");
        System.out.println("\n1. Register\n2. Exit");
        System.out.println("Choose one option:");
        int choice = takeIntegerInput(2, sc);
        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register(sc);
            while (true) {
                System.out.println("\n******** WELCOME TO ATM INTERFACE ********");
                System.out.println("\n1. Login\n2. Exit");
                System.out.println("Enter your choice:");
                int ch = takeIntegerInput(2, sc);
                if (ch == 1) {
                    if (b.login(sc)) {
                        System.out.println("\n******** WELCOME BACK " + b.name + " ********");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw\n2. Deposit\n3. Transfer\n4. Check Balance\n5. Transaction History\n6. Exit");
                            System.out.println("Enter your choice:");
                            int c = takeIntegerInput(6, sc);
                            switch (c) {
                                case 1:
                                    b.withdraw(sc);
                                    break;
                                case 2:
                                    b.deposit(sc);
                                    break;
                                case 3:
                                    b.transfer(sc);
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    sc.close();
                    System.exit(0);
                }
            }
        } else {
            sc.close();
            System.exit(0);
        }
    }
}
