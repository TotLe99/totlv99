package Object;


public class SalesEmployee extends Employee  {
    private double sales;
    private double calculateMonthlySalary;

    public SalesEmployee() {
    }

    public SalesEmployee(double sales, double calculateMonthlySalary) {
        this.sales = sales;
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    public SalesEmployee(String id, String name, int age, double salary, int workday, double sales, double calculateMonthlySalary) {
        super(id, name, age, salary, workday);
        this.sales = sales;
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getCalculateMonthlySalary() {
        return calculateMonthlySalary;
    }

    public void setCalculateMonthlySalary(double calculateMonthlySalary) {
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + " | " +
                "Sô bán = '" + sales +
                "' | Tổng lương = " + calculateMonthlySalary;
    }
}
