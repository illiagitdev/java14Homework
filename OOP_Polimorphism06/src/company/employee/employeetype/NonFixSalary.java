package company.employee.employeetype;

import company.employee.Employee;

public class NonFixSalary extends Employee {
    private float workHours;
    private float workDays;
    private float hourlyPay;

    public float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(float workHours) {
        if (workHours >= 0) {
            this.workHours = workHours;
        } else this.workHours = 0;
    }

    public float getWorkDays() {
        return workDays;
    }

    public void setWorkDays(float workDays) {
        if (workDays >= 0) {
            this.workDays = workDays;
        } else this.workDays = 0;
    }

    public float getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(float hourlyPay) {
        if (hourlyPay >= 0) {
            this.hourlyPay = hourlyPay;
        } else this.hourlyPay = 0;
    }

    public NonFixSalary(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public float salaryCalc() {
        return workDays * workHours * hourlyPay;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary = " + salaryCalc() + " $";
    }
}
