package Bill;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ElectricityBill implements Serializable {
    private static int countID = 1;
    private int id;
    private String name;
    private LocalDate dateNotification;
    private long money;
    private String status;
    private LocalDate datePaid;

    public ElectricityBill() {
        this.id = countID++;
    }

    public ElectricityBill(String name, LocalDate dateNotification, long money, String status, LocalDate datePaid) {
        this.id = countID++;
        this.name = name;
        this.dateNotification = dateNotification;
        this.money = money;
        this.status = status;
        this.datePaid = datePaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(LocalDate dateNotification) {
        this.dateNotification = dateNotification;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (datePaid == null) {
            return "\nElectricityBill.txt{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", dateNotification=" + dateNotification.format(formatter) +
                    ", money=" + money +
                    ", status='" + status + '\'' + "-" +
                    '}';
        }
        return "\nElectricityBill.txt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateNotification=" + dateNotification.format(formatter) +
                ", money=" + money +
                ", status='" + status + '\'' +
                ", datePaid=" + datePaid.format(formatter) +
                '}';
    }
}
