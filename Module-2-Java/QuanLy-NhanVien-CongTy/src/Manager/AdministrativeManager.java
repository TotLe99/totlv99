package Manager;

import Object.*;

import java.io.*;
import java.util.*;

public class AdministrativeManager implements Serializable {
    Scanner sc = new Scanner(System.in);

    public List<AdministrativeEmployee> administrativeEmployees = new ArrayList<>();
    int roll = 0;

    {
        loadData();
    }

    public AdministrativeManager() {
    }

    public void displayAdministrative() {
        for (AdministrativeEmployee administrativeEmployee : administrativeEmployees) {
            System.out.println(administrativeEmployee);
        }
    }

    //test
    public void addAdministrative() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (AdministrativeEmployee administrativeEmployee : administrativeEmployees) {
            if (id.equals(administrativeEmployee.getId())) {
                System.out.println("Hệ thống đã có ID này!");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee();
            administrativeEmployee.setId(id);
            administrativeEmployee.setName(name);
            administrativeEmployee.setAge(age);
            administrativeEmployees.add(administrativeEmployee);

            System.out.println("Thêm thành công!");
        }
        saveData();
    }

    public void calculateMonthlySalaryOfAdministrative() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (AdministrativeEmployee administrativeEmployee : administrativeEmployees) {
            if (id.equals(administrativeEmployee.getId())) {
                System.out.print("Số ngày nghỉ: ");
                int daysOff = Integer.parseInt(sc.nextLine());
                administrativeEmployee.setDaysOff(daysOff);

                if (administrativeEmployee.getDaysOff() > administrativeEmployee.getWorkday()) {
                    administrativeEmployee.setCalculateMonthlySalary(0);
                } else {
                    administrativeEmployee.setCalculateMonthlySalary(500 * (administrativeEmployee.getWorkday() - administrativeEmployee.getDaysOff()));
                }
                check = true;
                System.out.println("Nhân Viên '" + administrativeEmployee.getName() + "' lương = " + administrativeEmployee.getCalculateMonthlySalary());
                System.out.println("Tính lương Nhân Viên '" + administrativeEmployee.getName() + "' thành công!");
                break;
            }
        }
        if (!check) {
            System.out.println("Không có Nhân Viên này.");
        }
        saveData();
    }

    public void rollUp() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (AdministrativeEmployee administrativeEmployee : administrativeEmployees) {
            if (id.equals(administrativeEmployee.getId())) {
                administrativeEmployee.setWorkday(++roll);
                System.out.println("Nhân viên '" + administrativeEmployee.getName() + "' điểm danh ngày thứ '" + administrativeEmployee.getWorkday() + "'");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Không có Nhân Viên này.");
        }
        saveData();
    }

    public void saveData() {
        File file = new File("src/data/inforAdministrative.txt");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(administrativeEmployees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    AdministrativeEmployee e = new AdministrativeEmployee("12", "1212", 12);


    public void loadData() {
        File file = new File("src/data/inforAdministrative.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            administrativeEmployees = (List<AdministrativeEmployee>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
