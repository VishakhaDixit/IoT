import java.io.File;
import java.util.Scanner;

public class FooCorporation {

    static double minWage = 8.00;
    static int maxHours = 60;

    public static void main(String[] args)
    {
        try 
        {
            File file = new File("EmployeeDetails.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
            {
                String data = sc.nextLine();
                String[] tokens = data.split(",");

                Double basePay = Double.parseDouble(tokens[0]);
                int hrs = Integer.parseInt(tokens[1]);

                getTotalPay(basePay, hrs);

            }
            sc.close();
        } 
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void getTotalPay(double basePay, int hoursWorked)
    {
        double total_salary = 0;

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
    }
}
