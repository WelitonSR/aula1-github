package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		String departmentName;
		String workerName;
		String level;
		double baseSalary;
		int contractsQtd;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		departmentName = sc.nextLine();
		Department department = new Department(departmentName);

		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		workerName = sc.nextLine();
		System.out.print("Level: ");
		level = sc.nextLine();
		System.out.print("Base salary: ");
		baseSalary = sc.nextDouble();
		sc.nextLine();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, department);

		System.out.print("How many contracts to this worker? ");
		contractsQtd = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < contractsQtd; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data: ");
			System.out.println("Date: (DD/MM/YYYY: ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println(" ");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

}
