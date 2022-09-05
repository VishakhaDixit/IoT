import java.io.File;
import java.util.Scanner;

public class fooCorporation {

    static double minWage = 8.00;
    static int maxHours = 60;

    public static void main(String[] args)
    {
        try 
        {
            File file = new File("EmployeeDetails.txt");
            Scanner sc = new Scanner(file);
            int i = 1;
            empLinkedList empList = new empLinkedList();

            while (sc.hasNextLine())
            {
                Double empSalary;
                String data = sc.nextLine();
                String[] tokens = data.split(",");

                Double basePay = Double.parseDouble(tokens[0]);
                Double hrs = Double.parseDouble(tokens[1]);

                System.out.println("Employee"+ i + ":");
                empSalary = getTotalPay(basePay, hrs);

                if(empSalary != 0)
                {
                    empList.insert(empSalary);
                }

                i++;
            }
            System.out.println("ORDERED EMPLOYEE SALARY LIST:");
            empList.viewList();
            sc.close();
        } 
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static double getTotalPay(double basePay, Double hoursWorked)
    {
        Double total_salary = 0.00;

        if((basePay < minWage) || (hoursWorked > maxHours))
        {
            System.out.println("ERROR: Invalid Base Pay or Hours Worked!!");
        }
        else
        {
            if(hoursWorked > 40)
            {
                total_salary = (basePay * 40) + (1.5 * basePay * (hoursWorked - 40));
            }
            else
            {
                total_salary = basePay * hoursWorked;
            }
            System.out.println("Total salary is" + " " + total_salary);
        }
        return total_salary;
    }
}
