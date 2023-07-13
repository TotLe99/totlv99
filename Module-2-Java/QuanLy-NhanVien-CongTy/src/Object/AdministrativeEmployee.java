package Object;

import java.io.Serializable;

public class AdministrativeEmployee extends Employee {
    private int daysOff;
    private double calculateMonthlySalary;

    public AdministrativeEmployee() {
    }

//    public AdministrativeEmployee(int daysOff, double calculateMonthlySalary) {
//        this.daysOff = daysOff;
//        this.calculateMonthlySalary = calculateMonthlySalary;
//    }

    public AdministrativeEmployee(String id, String name, int age) {
        super(id, name, age);
    }

    public AdministrativeEmployee(String id, String name, int age, double salary, int workday, int daysOff, double calculateMonthlySalary) {
        super(id, name, age, salary, workday);
        this.daysOff = daysOff;
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public double getCalculateMonthlySalary() {
        return calculateMonthlySalary;
    }

    public void setCalculateMonthlySalary(double calculateMonthlySalary) {
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Số ngày nghỉ '" + daysOff +
                "' | Tổng lương = '" + calculateMonthlySalary;
    }
}
