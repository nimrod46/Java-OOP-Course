package Lab03;

public class Db {

    private final String dbName;
    private double balance;

    public Db(final String dbName) {
        this.dbName = dbName;
        balance = 0;
    }

    public boolean verify(int acct, String pw) {
        return true;
    }

    public double getAccountBalance() {
        return balance;
    }

    public void depositFunds(double amount) {
        if (amount < 0) {
            return;
        }
        balance += amount;
    }

    public void withdrawFunds(double amount) {
        if (amount < 0) {
            return;
        }
        balance -= amount;
    }

    public String getDbName() {
        return dbName;
    }
}
