/**************************
 *
 * @file    FooCorporation.java
 *
 * @brief   This program reads the employee details from a file, calculates total wage of each employee & maintains an ordered linked list.
 *
 * @date    Sep 10, 2022
 *
 * @author  Vishakha Dixit
 *
 **************************/

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
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
            empLinkedList empList1 = new empLinkedList();               // (a) 
            LinkedList<Double> empList2 = new LinkedList<Double>();     // (b)

            while (sc.hasNextLine())
            {
                Double empSalary;
                String data = sc.nextLine();
                String[] tokens = data.split(",");

                Double basePay = Double.parseDouble(tokens[0]);
                Double hrs = Double.parseDouble(tokens[1]);

                System.out.println("\nEmployee"+ i + ": " + "BasePay = " + basePay + ", " + "HoursWorked = " + hrs);
                empSalary = getTotalPay(basePay, hrs);

                if(empSalary != 0)
                {
                    empList1.insert(empSalary);                         // (a)
                    empList2.add(empSalary);                            // (b)
                }

                i++;
            }
            System.out.println("\n" + "(a) Sorted List using empLinkedList class:");        // (a)
            empList1.viewList();                                     

            Collections.sort(empList2);
            System.out.println("\n" + "(b) Sorted List using in built LinkedList<Double>:"); // (b)
            for(Double num : empList2){
                System.out.println(num);
            }


            sc.close();
        } 
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**************************
     * @brief       This function calculates total pay of an employee.
     *
     * @param [in]  double basePay
     *              Double hoursWorked
     *
     * @return      double: Total salary
     **************************/
    public static double getTotalPay(double basePay, Double hoursWorked)
    {
        Double total_salary = 0.00;

        if(basePay < minWage)
        {
            System.out.println("ERROR: Invalid Base Pay!!");
        }
        else if(hoursWorked > maxHours)
        {
            System.out.println("ERROR: Invalid Hours Worked!!");
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
