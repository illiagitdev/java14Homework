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

        company = Company.getInstance();
        System.out.println("Loading employees...");
        loadCompany();


        while (!leaveCompany) {
            whatToDo();
            leaveCompany = stayOrLeave(leaveCompany);
        }
    }

    private void whatToDo() {
        System.out.println("Виберіть доступну функцію:\n");
        System.out.println("\t 1 - Показати витрати на зарплати.");
        System.out.println("\t 2 - Вивести інформацію про всіх робітників.");
        System.out.println("\t 3 - Додати нового працівника.");
        System.out.println("\t 4 - Відсортувати і вивести по зростанні зарплатні.");
        System.out.println("\t 5 - Відсортувати і вивести по зменшенні зарплатні.\n\n");

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
                sort(true);
                break;
            }
            case 5: {
                sort(false);
                break;
            }
            default: {
                System.out.println("Невірний ввід!");
                break;
            }
        }
    }

    private void sort(boolean b) {
        if (b){//up

        }else {

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
                addHourly();
                break;
            }
            case 3: {
                addFrilance();
                break;
            }
            default: {
                System.out.println("Невірний ввід!");
                break;
            }
        }
    }

    private void addFrilance() {
        Frilance[] tmp = Arrays.copyOf(company.getFrilanceEmployee(), company.getFrilanceEmployee().length + 1);
        tmp[tmp.length - 1] = new Frilance(enterName(), enterLastName());
        System.out.print("Введіть кількість робочих годин за місяць: ");
        tmp[tmp.length - 1].setWorkHours(Utils.getFloat());
        System.out.print("Введіть погодинну оплату праці: ");
        tmp[tmp.length - 1].setHourPrice(Utils.getFloat());
        company.setFrilanceEmployee(tmp);
    }

    private void addHourly() {
        NonFixSalary[] tmp = Arrays.copyOf(company.getNonFixRateEmployee(), company.getNonFixRateEmployee().length + 1);
        tmp[tmp.length - 1] = new NonFixSalary(enterName(), enterLastName());
        System.out.print("Введіть кількість робочих годин на добу: ");
        tmp[tmp.length - 1].setWorkHours(Utils.getFloat());
        System.out.print("Введіть кількість робочих днів на місяць: ");
        tmp[tmp.length - 1].setWorkDays(Utils.getFloat());
        System.out.print("Введіть погодинну оплату праці: ");
        tmp[tmp.length - 1].setHourlyPay(Utils.getFloat());
        company.setNonFixRateEmployee(tmp);
    }

    private void addFixed() {
        Employee[] tmp = Arrays.copyOf(company.getFixedRateEmployee(), company.getFixedRateEmployee().length + 1);
        tmp[tmp.length - 1] = new FixedSalary(enterName(), enterLastName(), enterSalary());
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
        text = Utils.employeesInfo(w);
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

    private Frilance[] readFrilance(File path) {
        Frilance[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                int length = scan.hasNextInt() ? scan.nextInt() : 0;
                String[] employee;
                if (length != 0) {
                    fromFile = new Frilance[length];
                    for (int i = 0; i < length; i++) {
                        employee = scan.next().split(",");
                        fromFile[i] = new Frilance(employee[0], employee[1]);
                        fromFile[i].setWorkHours(Float.valueOf(employee[2]));
                        fromFile[i].setHourPrice(Float.valueOf(employee[3]));
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("File not found. " + e.fillInStackTrace());
                return new Frilance[0];
            }
        }
        return fromFile;
    }

    private NonFixSalary[] readNonFixed(File path) {
        NonFixSalary[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                int length = scan.hasNextInt() ? scan.nextInt() : 0;
                String[] employee;
                if (length != 0) {
                    fromFile = new NonFixSalary[length];
                    for (int i = 0; i < length; i++) {
                        employee = scan.next().split(",");
                        fromFile[i] = new NonFixSalary(employee[0], employee[1]);
                        fromFile[i].setWorkHours(Float.valueOf(employee[2]));
                        fromFile[i].setWorkDays(Float.valueOf(employee[3]));
                        fromFile[i].setHourlyPay(Float.valueOf(employee[4]));
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("File not found. " + e.fillInStackTrace());
                return new NonFixSalary[0];
            }
        }
        return fromFile;
    }

    private FixedSalary[] readFixed(File path) {
        FixedSalary[] fromFile = null;
        if (path.exists()) {
            try {
                Scanner scan = new Scanner(path);
                int length = scan.hasNextInt() ? scan.nextInt() : 0;
                String[] employee;
                if (length != 0) {
                    fromFile = new FixedSalary[length];
                    for (int i = 0; i < length; i++) {
                        employee = scan.next().split(",");

                        fromFile[i] = new FixedSalary(employee[0], employee[1], Float.valueOf(employee[2]));
                    }
                }
            } catch (FileNotFoundException | NumberFormatException e) {
                System.out.println("File not found. " + e.fillInStackTrace());
                return new FixedSalary[0];
            }
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

    private void saveCompany() {
        saveFixed(company.getFixedRateEmployee(), new File(Files.FIXED_SALARY_EMPLOEE));
        saveNonFixed(company.getNonFixRateEmployee(), new File(Files.NON_FIXED_SALARY_EMPLOEE));
        saveFrilance(company.getFrilanceEmployee(), new File(Files.FRILANCE_SALARY_EMPLOEE));
    }

    private void saveFrilance(Frilance[] frilanceEmployee, File path) {
        exists(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(frilanceEmployee.length + "\n");
            for (Frilance w : frilanceEmployee) {
                writer.write(w.getFirstName() + "," + w.getLastName() + "," + w.getWorkHours() + ","
                        + w.getHourPrice() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }

    private void saveNonFixed(NonFixSalary[] nonFixRateEmployee, File path) {
        exists(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(nonFixRateEmployee.length + "\n");
            for (NonFixSalary w : nonFixRateEmployee) {
                writer.write(w.getFirstName() + "," + w.getLastName() + "," + w.getWorkHours() + ","
                        + w.getWorkDays() + "," + w.getHourlyPay() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }

    private void exists(File path) {
        try {
            path.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFixed(FixedSalary[] fixedRateEmployee, File path) {
        exists(path);
        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(fixedRateEmployee.length + "\n");
            for (FixedSalary w : fixedRateEmployee) {
                writer.write(w.getFirstName() + "," + w.getLastName() + "," + w.getSalary() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: file hasn't been written!" + e.toString());
        }
    }
}
