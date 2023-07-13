
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vaccine {
    private static int countVaccine = 1;
    private int id;
    private String name;
    private LocalDate dateVaccine;
    private double price;
    private LocalDate injectVaccine;

    public Vaccine() {
        this.id = countVaccine++;
    }

    public Vaccine(String name, LocalDate dateVaccine, double price, LocalDate injectVaccine) {
        this.id = countVaccine++;
        this.name = name;
        this.dateVaccine = dateVaccine;
        this.price = price;
        this.injectVaccine = injectVaccine;
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

    public LocalDate getDateVaccine() {
        return dateVaccine;
    }

    public void setDateVaccine(LocalDate dateVaccine) {
        this.dateVaccine = dateVaccine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getInjectVaccine() {
        return injectVaccine;
    }

    public void setInjectVaccine(LocalDate injectVaccine) {
        this.injectVaccine = injectVaccine;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n" +
                "Mã: " + id +
                ", Tên: '" + name + '\'' +
                ", ngày sx: " + dateVaccine.format(formatter) +
                ", giá = " + price +
                ", ngày tiêm: " + injectVaccine.format(formatter);
    }
}
