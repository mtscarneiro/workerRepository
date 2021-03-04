package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entities.hourContract;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args)  throws ParseException {
				Locale.setDefault(Locale.US);
				Scanner sc = new Scanner(System.in);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				System.out.println("Enter department name: ");
				String departmentName = sc.nextLine();
				System.out.println("Enter worker data: ");
				System.out.println("Name: ");
				String workerName = sc.nextLine();
				System.out.println("Level: ");
				String worker_Level = sc.nextLine();
				System.out.println("Base salary: ");
				Double base_Salary = sc.nextDouble();
				
				Worker w = new Worker(workerName, WorkerLevel.valueOf(worker_Level), base_Salary, new Department(departmentName));
				
				System.out.println("How many contracts to this worker? ");
				int n = sc.nextInt();
				
				for (int i = 1; i <= n; i++) {
					System.out.println("Enter contract #" + i + " data:");
					System.out.print("Date (dd/MM/yyyy): ");
					Date contractDate = sdf.parse(sc.next());
					System.out.println("Value per hour: ");
					Double valuePerHour = sc.nextDouble();
					System.out.println("Duration (hour): ");
					int hours = sc.nextInt();
					hourContract contract = new hourContract(contractDate, valuePerHour, hours);
					w.addContract(contract);
				}
				
				System.out.println();
				System.out.println("Enter month and year to calculate income (mm/YYYY)");
				String monthAndYear = sc.next();
				int month = Integer.parseInt(monthAndYear.substring(0, 2));
			    int year =  Integer.parseInt(monthAndYear.substring(3));
			    System.out.println("Name: " + w.getName());
			    System.out.println("Department: " + w.getDepartment().getName());
			    System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", w.income(year, month)));
							
			    sc.close();
			    
	}

}
