package Manager;

import java.io.*;
import java.util.*;

import Object.*;

public class SalesManager implements Serializable {
    Scanner sc = new Scanner(System.in);
    int roll = 0;
    List<SalesEmployee> salesEmployees = new ArrayList<>();

    {
        loadData();
    }

    public SalesManager() {

    }

    public void displaySales() {
        for (SalesEmployee salesEmployee : salesEmployees) {
            System.out.println(salesEmployee);
        }
    }

    public void addSales() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (SalesEmployee salesEmployee : salesEmployees) {
            if (id.equals(salesEmployee.getId())) {
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

            SalesEmployee salesEmployee = new SalesEmployee();
            salesEmployee.setId(id);
            salesEmployee.setName(name);
            salesEmployee.setAge(age);
            salesEmployees.add(salesEmployee);
            System.out.println("Thêm thành công!");
        }
        saveData();
    }

    public void calculateMonthlySalaryOfSales() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (SalesEmployee salesEmployee : salesEmployees) {
            if (id.equals(salesEmployee.getId())) {
                System.out.print("Số bán: ");
                double sales = Double.parseDouble(sc.nextLine());

                if (salesEmployee.getWorkday() <= 0) {
                    salesEmployee.setCalculateMonthlySalary(0);
                } else {
                    salesEmployee.setSales(sales);
                    salesEmployee.setCalculateMonthlySalary(300 * salesEmployee.getWorkday() + 50 * salesEmployee.getSales());
                    System.out.println("Nhân Viên '" + salesEmployee.getName() + "' lương = " + salesEmployee.getCalculateMonthlySalary());
                    System.out.println("Tính lương Nhân Viên '" + salesEmployee.getName() + "' thành công!");
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println("Ko có Nhân Viên này!");
        }
        saveData();
    }

    public void rollUp() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (SalesEmployee salesEmployee : salesEmployees) {
            if (id.equals(salesEmployee.getId())) {
                salesEmployee.setWorkday(++roll);
                System.out.println("Nhân viên '" + salesEmployee.getName() + "' điểm danh ngày thứ '" + salesEmployee.getWorkday() + "'");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Ko có Nhân Viên này.");
        }
        saveData();
    }

    public void saveData() {
        File file = new File("src/data/inforSales.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(salesEmployees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        File file = new File("src/data/inforSales.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            salesEmployees = (List<SalesEmployee>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

