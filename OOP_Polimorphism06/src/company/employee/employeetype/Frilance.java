package company.employee.employeetype;

import company.employee.Employee;

public class Frilance extends Employee {
    private float workHours;
    private float hourPrice;

    public float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(float workHours) {
        if (workHours >= 0) {
            this.workHours = workHours;
        } else this.workHours = 0;
    }

    public float getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(float hourPrice) {
        if (hourPrice >= 0) {
            this.hourPrice = hourPrice;
        } else this.hourPrice = 0;
    }

    public Frilance(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public float salaryCalc() {
        return hourPrice * workHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary = " + salaryCalc() + " $";
    }
}
