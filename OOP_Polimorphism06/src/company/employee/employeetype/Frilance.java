package company.employee.employeetype;

import company.employee.Employee;

public class Frilance extends Employee {
    private float workHours;
    private float hourPrice;

    public Frilance(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public float salaryCalc() {
        return hourPrice*workHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary" + salaryCalc() + '$';
    }
}
