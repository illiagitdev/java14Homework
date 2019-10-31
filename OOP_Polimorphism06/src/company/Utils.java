package company;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import company.employee.Employee;

import java.util.Scanner;

public class Utils {
    static Scanner in = new Scanner(System.in);

    static void print(String s) {
        System.out.println("Content: " + s);
    }

    public static String getStr() {
        return in.next();
    }

    public static int getInt() {
        return in.hasNextInt() ? in.nextInt() : getInt();
    }

    public static float addition(Employee[] employee) {
        float expenses = 0;
        try {
            for (Employee x : employee) {
                expenses += x.salaryCalc();
            }
            return expenses;
        } catch (NullPointerException e) {
            System.out.println(e.fillInStackTrace());
        }
        return 0;
    }

    public static String employeesInfo(Employee[] employee) {
        String str = "";
        try {
            for (Employee x : employee) {
                str += x.toString() + "\n";
            }
            return str;
        } catch (NullPointerException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public static float getFloat() {
        return in.hasNextFloat()?in.nextFloat():getFloat();
    }
}
