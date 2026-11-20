import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int correctPassword = 1234;
        int attempts = 3;
        int transactions = 0;

        Scanner scan = new Scanner(System.in);

        while (attempts > 0) {
            System.out.print("Enter your 4-digit PIN: ");
            int yourPassword = scan.nextInt();

            if (yourPassword == correctPassword) {
                System.out.println("Your account has been unlocked");
                double balance = 2500.75;
                int choice;

                do {
                    System.out.println("Enter num from 1 to 5 \n " +
                            "1-Check Balance \n" +
                            "2-Deposit \n" +
                            "3-Withdraw \n" +
                            "4-Show Account Status\n" +
                            "5- Exit ");
                    choice = scan.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("your current balance is :" + balance);
                            break;

                        case 2:
                            System.out.println("Please enter the amount you would like to deposit:");
                            double amount = scan.nextDouble();
                            if (amount > 0) {
                                balance += amount;
                                transactions++;
                                System.out.println("The current balance now is : " + balance);
                            } else {
                                System.out.println("please enter num more than zero , try again");
                            }
                            break;

                        case 3:
                            System.out.println("Enter your amount you would like to Withdraw it :");
                            double withdraw = scan.nextDouble();
                            if (withdraw > 0 && withdraw <= balance) {
                                balance -= withdraw;
                                transactions++;
                                if (balance == 0) {
                                    System.out.println("Warning!!!! , Your account is empty now");
                                }
                                System.out.println("Your balance after withdraw: " + balance);
                            } else {
                                System.out.println("Insufficient balance");
                            }
                            break;

                        case 4:
                            if (balance >= 5000) {
                                System.out.println("your account state is VIP");
                            } else if (balance >= 1000) {
                                System.out.println(" You are Regular Customer");
                            } else {
                                System.out.println("low balance");
                            }
                            break;

                        case 5:
                            System.out.println("Total successful transactions: " + transactions);
                            System.out.println("Your balance now is :" + balance);
                            System.out.println("Thank you for using our ATM.");
                            break;

                        default:
                            System.out.println("Your balance now is :" + balance);
                            System.out.println("Invalid option.");
                            break;
                    }
                } while (choice != 5);
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN, Try again");
                if (attempts == 0) {
                    System.out.println("Your account has been locked.");
                }
            }
        }
        scan.close();
    }
}
