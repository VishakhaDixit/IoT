## Assignment 1

Foo Corporation needs a program to calculate how much to pay their hourly employees. The US Department of Labor requires that employees get paid time and a half for any hours over 40 that they work in a single week. For example, if an employee works 45 hours, they get 5 hours of overtime, at 1.5 times their base pay. The State of Massachusetts requires that hourly employees be paid at least $8.00 an hour. Foo Corp requires that an employee not work more than 60 hours in a week.
Summary of Rules:
-	An employee gets paid (hours worked) × (base pay), for each hour up to 40 hours. 
-	For every hour over 40, they get overtime = (base pay) × 1.5. 
-	The base pay must not be less than the minimum wage ($8.00 an hour). If it is, print an error. 
-	If the number of hours is greater than 60, print an error message. 

Create a new class called FooCorporation. Write a method that takes the base pay and hours worked as parameters (this data is to be read from a file), and prints the total pay or an error. Write a main method that calls this method for each of these employees. The main method should also print out a sorted linked list of the pays of all employees (excluding the error entries). For this Linked List, (a) use your own LL code, and (b) use the ArrayList/LinkedList class methods.