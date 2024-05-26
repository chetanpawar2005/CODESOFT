import java.util.Scanner;

class BankAccount{
    String name ;
    String username;
    String password;
    String accountNumber;
    float balance=5000001f;
    int transaction=0;
    String transactionHistory="";
    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Your Name: ");
        this.name=sc.nextLine();
        System.out.println("\nEnter Your Username: ");
        this.username=sc.nextLine();
        System.out.println("\nEnter Your password: ");
        this.password=sc.nextLine();
        System.out.println("\nEnter Your Account Number :");
        this.accountNumber=sc.nextLine();
        System.out.println("\nRegistration Successful. Please log in to your Bank Account");
    }
    public  boolean login (){
        boolean isLogin = false;
        Scanner sc =  new  Scanner(System.in);
        while(!isLogin){
            System.out.println("\n Enter your username");
             String username=sc.nextLine();
             if (username.equals(username)){
                 while(!isLogin){
                     System.out.println("\nEnter your password ");
                     String password = sc.nextLine();
                     if (password.equals(password)){
                         System.out.println("\nLogin successful");
                         isLogin=true;
                     }else {
                         System.out.println("\nIncorrect password ");
                     }
                     }
                 }else {
                 System.out.println("\nusername not found ");
             }
        }
 return isLogin;
    }
    public void withdraw(){
        System.out.println("\nEnter Amount to withdraw");
        Scanner sc= new Scanner(System.in);
        float amount=sc.nextFloat();
        try {
            if (balance >= amount) {
                transaction++;
                balance -= amount;
                System.out.println("\nwithdraw successful.");
                String str = amount + "Rs withdraw\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient balance");
            }
        }catch (Exception e){

        }
    }

    public void deposit(){
        System.out.println("\nEnter Amount to deposit");
        Scanner sc= new Scanner(System.in);
        float amount=sc.nextFloat();
        try {
            if (amount <= 10000f) {
                transaction++;
                balance += amount;
                System.out.println("\n deposit successful.");
                String str = amount + "Rs \ndeposited";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry. the limit is 1200.");
            }
        }catch (Exception e){

        }
    }
    public void transfer(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name:");
        String receipent=sc.nextLine();
        System.out.println("\nEnter  Amount to transfer ");

        float amount=sc.nextFloat();
        try {
            if(balance>=amount) {
                if (amount <= 50000f) {
                    transaction++;
                    balance += amount;
                    System.out.println("\nsuccessfully transfer to."+receipent);
                    String str = amount + "Rs \nTransfer to "+receipent+"\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry. the limit is 50000.");
                }
            }else{
                System.out.println("\nInsufficient Balance.");
            }}catch (Exception e){

        }
    }

    public void checkBalance(){
        System.out.println("\n"+balance+"Rs");
    }
    public void tansHistory(){
        if (transaction==0){
            System.out.println(" No transaction  happened");
        }else{
            System.out.println("\n"+transactionHistory);
        }
}
}

public class Atm_Interface {
    public static int takenIntegerInput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc= new Scanner(System.in);
                input = sc.nextInt();
                flag= true;
                if (flag && input > limit || input<1){
                    System.out.println("choose the number between 1 to"+limit);
                    flag=false;
                }
            }catch (Exception e){
                System.out.println("Enter only integer value.");
                flag=false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n ********WELCOME TO ATM INTERFACE******** ");
        System.out.println("\n1.Register \n 2.exit");
        System.out.println("Choose one option");
        int choose =takenIntegerInput(2);
        if (choose==1){
            BankAccount b=new BankAccount();
            b.register();
            while(true){
                System.out.println("\n ********WELCOME TO ATM INTERFACE******** ");
                System.out.println("\n1.login \n 2.exit");
                System.out.println("Enter your choice");
                int ch =takenIntegerInput(2);
                if (ch==1){
                    if (b.login()){
                        System.out.println("\n ********WELCOME BACK"+ b.name+"******** ");
                        boolean isFinished =false;
                        while(!isFinished){
                            System.out.println(" \n 1.withdraw \n2.deposit \n3.transfer \n4.check balance \n5. transaction History \n6.Exit ");
                            System.out.println("Enter your choice");
                            int c=takenIntegerInput(6);
                            switch(c){
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.tansHistory();
                                    break;
                                case 6:
                                    isFinished=true;
                                    break;

                            }
                        }
                    }
                }else {
                    System.exit(0);
                }
            }
        }else {
            System.exit(0);
        }

    }
}
