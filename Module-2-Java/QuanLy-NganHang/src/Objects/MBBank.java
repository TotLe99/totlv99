package Objects;

import Bill.ElectricityBill;

import java.util.ArrayList;
import java.util.List;

public class MBBank extends Bank {
    private String nameBank;
    private List<ElectricityBill> electricityBills = new ArrayList<>();

    public MBBank() {
        this.electricityBills = new ArrayList<>();

    }

    public MBBank(String accountBank, String passwordAccount, String name, int PIN, String nameBank) {
        super(accountBank, passwordAccount, name, PIN);
        this.nameBank = nameBank;
    }

    public MBBank(String accountBank, String passwordAccount, String nameAccount, int PIN, long money, String nameBank) {
        super(accountBank, passwordAccount, nameAccount, PIN, money);
        this.nameBank = nameBank;
        this.electricityBills = new ArrayList<>();
    }

    public MBBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public List<ElectricityBill> getElectricityBills() {
        return electricityBills;
    }

    public void setElectricityBills(List<ElectricityBill> electricityBills) {
        this.electricityBills = electricityBills;
    }

    public void addElectricityBill(ElectricityBill electricityBill) {
        electricityBills.add(electricityBill);
    }
    public void deleteElectricityBill(ElectricityBill electricityBill) {
        electricityBills.remove(electricityBill);
    }

    @Override
    public String toString() {
        return "\n{" +
                "nameBank='" + nameBank + '\'' +
                '}' + super.toString();
    }

    public String toStringPayElectricityBill() {
        return "\n{" +
                "nameBank='" + nameBank + '\'' +
                " , STK " + getAccountBank() +
                electricityBills;
    }
}
