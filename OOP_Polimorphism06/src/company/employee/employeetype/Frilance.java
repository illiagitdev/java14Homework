package company.employee.employeetype;

import company.employee.Employee;

public class Frilance extends Employee {
    private float workHours;
    private float hourPrice;

    @Override
    public float salaryCalc() {
        return hourPrice*workHours;
    }
}
