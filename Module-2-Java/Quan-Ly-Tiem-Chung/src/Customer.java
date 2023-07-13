import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private static int countCustomer = 1;
    private int id;
    private String name;
    private String phone;
    private ArrayList<Vaccine> vaccines;

    public Customer() {
        this.id = countCustomer++;
    }

    public Customer(String name, Vaccine...vaccines) {
        this.name = name;
        List<Vaccine> vac = new ArrayList<>(Arrays.asList(vaccines));
    }

    public Customer(String name, String phone) {
        this.id = countCustomer++;
        this.name = name;
        this.phone = phone;
        this.vaccines = new ArrayList<Vaccine>();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(ArrayList<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public void addVaccine(Vaccine vaccine) {
        vaccines.add(vaccine);
    }

    @Override
    public String toString() {
        return "Khách Hàng: " +
                "Mã KH '" + id +
                "' , Tên '" + name + '\'' +
                " , SĐT '" + phone + '\'' + " "
                + vaccines;
    }
}
