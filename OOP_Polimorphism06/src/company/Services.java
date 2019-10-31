package company;

import company.employee.Employee;
import company.employee.employeetype.FixedSalary;
import company.employee.employeetype.Frilance;
import company.employee.employeetype.NonFixSalary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Services {
    private Company company;

    public void run() {
        boolean leaveCompany = false;

        company = new Company();
        System.out.println("Loading employees...");
        loadCompany();


        while (!leaveCompany) {
            whatToDo();
//            toDo();

            leaveCompany = stayOrLeave(leaveCompany);
        }
    }

    private void whatToDo() {
        System.out.println("Виберіть доступну функцію:\n");
        System.out.println("\t 1 - Показати витрати на зарплати.");
        System.out.println("\t 2 - Вивести інформацію про всіх робітників.");
        System.out.println("\t 3 - Додати нового працівника.");
        System.out.println("\t 4 - ");
        System.out.println("\t 5 - \n\n");

        System.out.print("\t Ваш вибір: ");
        switch (Utils.getInt()) {
            case 1: {
                System.out.println(expenses());
                break;
            }
            case 2: {
                System.out.println(showInfoAll());
                break;
            }
            case 3: {
                addEmployee();
                break;
            }
            case 4: {
            }
            case 5: {
            }
            default: {
                System.out.println("Невірний ввід!");
                break;
            }
        }
    }

    private void addEmployee() {
        System.out.println("\n\t 1 - Працівник з фіксованою оплатою.");
        System.out.println("\t 2 - Працівник з погодинною оплатою.");
        System.out.println("\t 3 - Фрілансер.");

        System.out.print("\t Ваш вибір: ");
        switch (Utils.getInt()) {
            case 1: {
                addFixed();
                break;
            }
            case 2: {
//                addHourly();
                break;
            }
            case 3: {
//                addFrilance();
                break;
            }
            default: {
                System.out.println("Невірний ввід!");
                break;
            }
        }
    }

    private void addFixed() {
        Employee[] tmp = Arrays.copyOf(company.getFixedRateEmployee(),company.getFixedRateEmployee().length+1);
        tmp[tmp.length-1]=new FixedSalary(enterName(), enterLastName(), enterSalary());
        company.setFixedRateEmployee((FixedSalary[]) tmp);
    }

    private float enterSalary() {
        System.out.print("Введіть зарплату: ");
        return Utils.getFloat();
    }

    private String enterLastName() {
        System.out.print("Введіть прізвище: ");
        return Utils.getStr();
    }

    private String enterName() {
        System.out.print("Введіть ім'я: ");
        return Utils.getStr();
    }

    private String showInfoAll() {
        String text;
        Employee[] w = company.getFixedRateEmployee();
        text=Utils.employeesInfo(w);
        w = company.getNonFixRateEmployee();
        text += Utils.employeesInfo(w);
        w = company.getFrilanceEmployee();
        text += Utils.employeesInfo(w);
        return text;
    }

    private String expenses() {
        Employee[] w = company.getFixedRateEmployee();
        float expenses = Utils.addition(w);
        w = company.getNonFixRateEmployee();
        expenses += Utils.addition(w);
        w = company.getFrilanceEmployee();
        expenses += Utils.addition(w);
        return "Загальні витрати " + expenses + " $";
    }

    private void loadCompany() {
        company.setFixedRateEmployee(readFixed(new File(Files.FIXED_SALARY_EMPLOEE)));
        company.setNonFixRateEmployee(readNonFixed(new File(Files.NON_FIXED_SALARY_EMPLOEE)));
        company.setFrilanceEmployee(readFrilance(new File(Files.FRILANCE_SALARY_EMPLOEE)));
    }

    private Frilance[] readFrilance(File path) {//todo:
        return new Frilance[0];
    }

    private NonFixSalary[] readNonFixed(File path) {//todo:
        return new NonFixSalary[0];
    }

    private FixedSalary[] readFixed(File path) {
        FixedSalary[] fromFile = null;
        try {
            Scanner scan = new Scanner(path);
            int length = scan.hasNextInt() ? scan.nextInt() : 0;
            String[] employee;
            if (length != 0) {
                fromFile = new FixedSalary[length];
                for (int i = 0; i < length; i++) {
                    employee = scan.next().split(",");

                    fromFile[i] = new FixedSalary(employee[0], employee[1], Float.valueOf(employee[2]));
                    Utils.print(fromFile[i].toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found. " + e.fillInStackTrace());
            return new FixedSalary[0];
        }
        return fromFile;
    }

    private boolean stayOrLeave(boolean leaveStore) {
        System.out.println("Вийти з компанії: y/n");
        String str = Utils.getStr().toLowerCase();
        switch (str) {
            case "y": {
                System.out.println("Вихід і збереження данних...");
                saveCompany();
                leaveStore = true;
                break;
            }
            case "n": {
                System.out.println("Продовжити роботу.");
                break;
            }
            default: {
                System.out.println();
                stayOrLeave(leaveStore);
            }
        }
        return leaveStore;
    }

    private void saveCompany() {//todo:
        saveFixed(company.getFixedRateEmployee(),new File(Files.FIXED_SALARY_EMPLOEE));
//        company.getNonFixRateEmployee(saveNonFixed(new File(Files.NON_FIXED_SALARY_EMPLOEE)));
//        company.getFrilanceEmployee(saveFrilance(new File(Files.FRILANCE_SALARY_EMPLOEE)));
    }

    private void saveFixed(FixedSalary[] fixedRateEmployee, File path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(fixedRateEmployee.length + "\n");
            for (FixedSalary w: fixedRateEmployee) {
                writer.write(w.getFirstName()+","+w.getLastName()+","+w.getSalary() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }
}
