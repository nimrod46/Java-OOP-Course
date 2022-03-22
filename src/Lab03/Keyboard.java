package Lab03;

import java.util.Scanner;

public class Keyboard {
    private final Scanner reader;

    public Keyboard() {
        reader = new Scanner(System.in);
    }

    public int readAccName() {
        return reader.nextInt();
    }

    public String readPw() {
        return reader.next();
    }

    public int readMenuChoice() {
        return reader.nextInt();
    }

    public int readWithdrawalChoice() {
        return reader.nextInt();
    }

    public double readDepositAmount() {
        return reader.nextInt();
    }
}
