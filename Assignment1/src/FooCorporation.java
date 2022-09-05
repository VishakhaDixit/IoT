public class FooCorporation {

    double minWage = 8.00;
    int maxHours = 60;

    public void getTotalPay(double basePay, int hoursWorked)
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
            System.out.println("Total salary is" + total_salary);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
