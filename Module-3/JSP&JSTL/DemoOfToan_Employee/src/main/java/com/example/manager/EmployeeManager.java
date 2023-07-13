package com.example.manager;

import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "John Nan", "https://img.lovepik.com/free-png/20210919/lovepik-office-staff-png-image_400345905_wh1200.png"));
        employees.add(new Employee(2, "Tina Lee", "https://png.pngtree.com/png-vector/20230111/ourmid/pngtree-employe-woman-beautiful-female-employees-png-image_6559551.png"));
    }
}
