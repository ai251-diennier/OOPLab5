package ua.opnu;

public class Lecturer extends Person {
    private String department;
    private double salary;

    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        setSalary(salary);
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (!Double.isFinite(salary) || salary < 0) throw new IllegalArgumentException("Invalid salary");
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Викладач кафедри " + department + ", " + getLastName() + " " + getFirstName()
                + ", вік: " + getAge() + ". Зарплата: " + salary;
    }
}
