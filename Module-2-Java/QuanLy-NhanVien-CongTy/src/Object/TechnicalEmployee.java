package Object;

public class TechnicalEmployee extends Employee {
    private int projects;
    private double calculateMonthlySalary;

    public TechnicalEmployee() {
    }

    public TechnicalEmployee(int projects, double calculateMonthlySalary) {
        this.projects = projects;
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    public TechnicalEmployee(String id, String name, int age, double salary, int workday, int projects, double calculateMonthlySalary) {
        super(id, name, age, salary, workday);
        this.projects = projects;
        this.calculateMonthlySalary = calculateMonthlySalary;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
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
                "Số dự án = '" + projects +
                "' | Tổng lương = " + calculateMonthlySalary;
    }
}
