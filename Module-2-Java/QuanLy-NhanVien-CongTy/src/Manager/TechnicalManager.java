package Manager;

import java.io.*;
import java.util.*;

import Object.*;

public class TechnicalManager implements Serializable{
    Scanner sc = new Scanner(System.in);
    int roll = 0;
    List<TechnicalEmployee> technicalEmployees = new ArrayList<>();

    {
        loadData();
    }
    public TechnicalManager() {

    }

    public void displayTechnical() {
        for (TechnicalEmployee technicalEmployee : technicalEmployees) {
            System.out.println(technicalEmployee);
        }
    }

    public void addTechnical() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (TechnicalEmployee technicalEmployee : technicalEmployees) {
            if (id.equals(technicalEmployee.getId())) {
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

            TechnicalEmployee technicalEmployee = new TechnicalEmployee();
            technicalEmployee.setId(id);
            technicalEmployee.setName(name);
            technicalEmployee.setAge(age);
            technicalEmployees.add(technicalEmployee);
            System.out.println("Thêm thành công!");
        }
        saveData();
    }

    public void calculateMonthlySalaryOfTechnical() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (TechnicalEmployee technicalEmployee : technicalEmployees) {
            if (id.equals(technicalEmployee.getId())) {
                System.out.print("Số dự án: ");
                int projects = Integer.parseInt(sc.nextLine());

                if (technicalEmployee.getWorkday() <= 0) {
                    technicalEmployee.setCalculateMonthlySalary(0);
                } else {
                    technicalEmployee.setProjects(projects);
                    technicalEmployee.setCalculateMonthlySalary(500 * technicalEmployee.getWorkday() + 200 * technicalEmployee.getProjects());
                }
                System.out.println("Nhân Viên '" + technicalEmployee.getName() + "' lương = " + technicalEmployee.getCalculateMonthlySalary());
                System.out.println("Tính lương Nhân Viên '" + technicalEmployee.getName() + "' thành công!");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Ko có Nhân Viên này.");
        }
        saveData();
    }

    public void rollUp() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        boolean check = false;

        for (TechnicalEmployee technicalEmployee : technicalEmployees) {
            if (id.equals(technicalEmployee.getId())) {
                technicalEmployee.setWorkday(++roll);
                System.out.println("Nhân viên '" + technicalEmployee.getName() + "' điểm danh ngày thứ '" + technicalEmployee.getWorkday() + "'");
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
        File file = new File("src/data/inforTechnical.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(technicalEmployees);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadData() {
        File file = new File("src/data/inforTechnical.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            technicalEmployees = (List<TechnicalEmployee>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
