package company.employee.employeetype;

import company.employee.Employee;

public class NonFixSalary extends Employee {
    private float workHours;
    private float workDays;
    private float hourlyPay;

    public NonFixSalary(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public float salaryCalc() {
        return workDays * workHours * hourlyPay;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary" + salaryCalc() + '$';
    }
}
