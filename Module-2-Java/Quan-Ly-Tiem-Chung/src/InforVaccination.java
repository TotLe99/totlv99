import java.time.LocalDate;
import java.util.*;

public class InforVaccination {
    Scanner sc = new Scanner(System.in);
    ArrayList<Customer> customers;
    ArrayList<Vaccine> vaccines;

    public InforVaccination() {
        customers = new ArrayList<Customer>();
        vaccines = new ArrayList<Vaccine>();
    }

    public Customer create() {
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("SĐT: ");
        String phone = sc.nextLine();

        return new Customer(name, phone);
    }

    public void displayNameOfCustomer() {
        System.out.println("---- Danh sách Khách Hàng ----");
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public void addCustomer() {
        Customer customer = create();
        customers.add(customer);
    }

    public void injectVaccineForCustomer() {

        vaccines.add(new Vaccine("Pfizer", LocalDate.of(2021, 12, 5), 300000, null));
        vaccines.add(new Vaccine("Moderna", LocalDate.of(2021, 6, 1), 350000, null));
        vaccines.add(new Vaccine("AstraZeneca", LocalDate.of(2021, 4, 20), 250000, null));
        vaccines.add(new Vaccine("Johnson & Johnson", LocalDate.of(2021, 5, 30), 400000, null));

        Customer selectedCustomer = null;
        Vaccine selectedVaccine = null;

        System.out.print("Mã Khách Hàng: ");
        int idCustomer = Integer.parseInt(sc.nextLine());
        System.out.print("Mã Vaccine: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Customer customer : customers) {
            if (idCustomer == customer.getId()) {
                selectedCustomer = customer;
                break;
            }
        }
        if (selectedCustomer == null) {
            System.out.println("Ko có KH này!");
        }
        for (Vaccine vaccine : vaccines) {
            if (id == vaccine.getId()) {
                selectedVaccine = vaccine;
                break;
            }
        }
        if (selectedVaccine == null) {
            System.out.println("Ko có Vaccine này!");
        }

        //Tiêm
        selectedCustomer.addVaccine(selectedVaccine);
        selectedVaccine.setInjectVaccine(LocalDate.now());
        System.out.println("Đã tiêm vaccine " + selectedVaccine.getName() + " cho KH " + selectedCustomer.getName());
    }

    public void displayInjectVaccineForCustomer() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        boolean check = false;
        for (Customer customer : customers) {
            if (name.equals(customer.getName())) {
                System.out.println("\n" + customer);
            }
            check = true;
        }
        if (!check) {
            System.out.println("Không có KH này!");
        }
    }
}
