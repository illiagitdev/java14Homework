package company.employee.employeetype;

import company.employee.Employee;

public class FixedSalary extends Employee {
    private float salary;

    public FixedSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public double salaryCalc() {
        return salary;
    }
}
