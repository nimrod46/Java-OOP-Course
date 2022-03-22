package Lab03;

public class Screen {

    public void displayGreeting() {
        System.out.println("Welcome!");
    }

    public void displayAcctPrompt() {
        System.out.println("Please enter your account number:");
    }

    public void displayPwPrompt() {
        System.out.println("Enter your PIN:");
    }

    public void displayMainMenu() {
        System.out.println("Main menu");
        System.out.println("\t1 - View my balance");
        System.out.println("\t2 - Withdraw cash");
        System.out.println("\t3 - Deposit funds");
        System.out.println("\t4 - Exit");
        System.out.println("Enter a choice:");
    }

    public void displayBalance(double balance) {
        System.out.printf("Your balance is: %.1f\n", balance);
    }

    public void displayWithdrawalAction(double withdrawalAmount) {
        System.out.printf("Withdrew %.1f\n", withdrawalAmount);
    }

    public void displayDepositPrompt() {
        System.out.println("How much would you like to deposit?");
    }

    public void displayDepositAction(double depositAmount) {
        System.out.printf("Deposit %.1f\n", depositAmount);
    }

    public void displayWithdrawalMenu() {
        System.out.println("Withdrawl menu\n" +
                "\t1 - $20\t\t4 - $100\n" +
                "\t2 - $40\t\t5 - $200\n" +
                "\t3 - $60\t\t6 - Cancel transaction");
        System.out.println("Choose a withdrawl amount:");
    }

    public void displayGoodbye() {
        System.out.println("Good bye!");
    }
}
