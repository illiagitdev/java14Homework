package company;

import company.employee.employeetype.FixedSalary;
import company.employee.employeetype.Frilance;
import company.employee.employeetype.NonFixSalary;

public class Company {
    private FixedSalary[] fixedRateEmployee;
    private NonFixSalary[] nonFixRateEmployee;
    private Frilance[] frilanceEmployee;

    public FixedSalary[] getFixedRateEmployee() {
        return fixedRateEmployee;
    }

    public NonFixSalary[] getNonFixRateEmployee() {
        return nonFixRateEmployee;
    }

    public Frilance[] getFrilanceEmployee() {
        return frilanceEmployee;
    }

    public void setFixedRateEmployee(FixedSalary[] fixedRateEmployee) {
        if (fixedRateEmployee!=null) {
            this.fixedRateEmployee = fixedRateEmployee;
        }else {
            this.fixedRateEmployee=new FixedSalary[0];
        }
    }

    public void setNonFixRateEmployee(NonFixSalary[] nonFixRateEmployee) {
        if (nonFixRateEmployee!=null) {
        this.nonFixRateEmployee = nonFixRateEmployee;
        }else {
            this.nonFixRateEmployee=new NonFixSalary[0];
        }
    }

    public void setFrilanceEmployee(Frilance[] frilanceEmployee) {
        if (frilanceEmployee!=null) {
        this.frilanceEmployee = frilanceEmployee;
        }else {
            this.frilanceEmployee=new Frilance[0];
        }
    }
}
