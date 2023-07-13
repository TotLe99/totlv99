package Objects;

import java.io.Serializable;

public class Bank implements Serializable {
    private String accountBank;
    private String passwordAccount;
    private String nameAccount;
    private int PIN;
    private long money = 0;

    public Bank() {
    }

    public Bank(String accountBank, String passwordAccount, String name, int PIN) {
        this.accountBank = accountBank;
        this.passwordAccount = passwordAccount;
        this.nameAccount = name;
        this.PIN = PIN;
    }

    public Bank(String accountBank, String passwordAccount, String nameAccount, int PIN, long money) {
        this.accountBank = accountBank;
        this.passwordAccount = passwordAccount;
        this.nameAccount = nameAccount;
        this.PIN = PIN;
        this.money = money;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money += money;
    }

    @Override
    public String toString() {
        return "{" +
                "accountBank='" + accountBank + '\'' +
                ", passwordAccount='" + passwordAccount + '\'' +
                ", nameAccount='" + nameAccount + '\'' +
                ", PIN=" + PIN +
                ", money=" + money +
                '}';
    }
}
