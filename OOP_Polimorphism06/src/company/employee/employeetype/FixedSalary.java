package company.employee.employeetype;

import company.employee.Employee;

public class FixedSalary extends Employee {
    private float salary;

    public float getSalary() {
        return salary;
    }

    public FixedSalary(String firstName, String lastName, float salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public float salaryCalc() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salary = " + salary + " $";
    }
}
