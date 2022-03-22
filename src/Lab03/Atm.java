package Lab03;

public class Atm {

    private final Screen scr;
    private final Keyboard kbd;
    private final Db db;

    public Atm(String dbName) {
        scr = new Screen();
        kbd = new Keyboard();
        db = new Db(dbName);
    }

    public void go() {
        scr.displayGreeting();

        if (!accountLogin()) {
            return;
        }

        int choice = 0;
        while (choice != 4) {
            scr.displayMainMenu();
            choice = kbd.readMenuChoice();
            switch (choice) {
                case 1:
                    balanceDisplay();
                    break;
                case 2:
                    withdrawalMenu();
                    break;
                case 3:
                    depositMenu();
                    break;
                case 4:
                    accountExit();
                    break;
                default:
                    break;
            }
        }
    }

    private boolean accountLogin() {
        scr.displayAcctPrompt();
        int acc = kbd.readAccName();

        scr.displayPwPrompt();
        String pw = kbd.readPw();

        return db.verify(acc, pw);
    }

    private void balanceDisplay() {
        scr.displayBalance(db.getAccountBalance());
    }

    private void withdrawalMenu() {
        scr.displayWithdrawalMenu();
        int withdrawal = kbd.readWithdrawalChoice();
        double withdrawalAmount;
        switch (withdrawal) {
            case 1:
                withdrawalAmount = 20;
                break;
            case 2:
                withdrawalAmount = 40;
                break;
            case 3:
                withdrawalAmount = 60;
                break;
            case 4:
                withdrawalAmount = 100;
                break;
            case 5:
                withdrawalAmount = 200;
                break;
            case 6:
            default:
                withdrawalAmount = -1;
                break;
        }
        if (withdrawalAmount == -1) {
            return;
        }
        scr.displayWithdrawalAction(withdrawalAmount);
        db.withdrawFunds(withdrawalAmount);
    }

    private void depositMenu() {
        scr.displayDepositPrompt();
        double depositAmount = kbd.readDepositAmount();
        scr.displayDepositAction(depositAmount);
        db.depositFunds(depositAmount);
    }

    private void accountExit() {
        scr.displayGoodbye();
    }
}
