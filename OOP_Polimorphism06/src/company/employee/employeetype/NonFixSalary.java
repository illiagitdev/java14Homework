package company.employee.employeetype;

import company.employee.Employee;

public class NonFixSalary extends Employee {
    private float workHours;
    private float workDays;
    private float hourlyPay;

    public NonFixSalary(float workHours, float workDays) {
        this.workHours = workHours;
        this.workDays = workDays;
    }

    @Override
    public double salaryCalc() {
        return workDays*workHours*hourlyPay;
    }
}
