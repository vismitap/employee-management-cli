package com.employee.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.employee.model.Employee;

public class EmployeeManager {

	static List<Employee> empList = new ArrayList<>();
	static int empId = 0;
	static Scanner sc = new Scanner(System.in);
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE   = "\u001B[34m";
	public static final String CYAN   = "\u001B[36m";
	public static final String PURPLE = "\u001B[35m";

	
	public static void showLoading() {
		char[] spinner = {'|', '/', '-', '\\'};
        System.out.print("Loading ");
        for (int i = 0; i < 4; i++) {
            System.out.print("\rLoading " + spinner[i % spinner.length]);
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println("\rDone!     ");
	}

	public static void showOfficeAnimation() {
	    String[] floors = {
	        "       |   " + YELLOW + "[]   []   []   []" + BLUE + "   |",
	        "       |   " + YELLOW + "[]   []   []   []" + BLUE + "   |",
	        "       |   " + YELLOW + "[]   []   []   []" + BLUE + "   |",
	        "       |   " + YELLOW + "[]   []   []   []" + BLUE + "   |"
	    };

	    System.out.println(BLUE + "        _______________________");
	    System.out.println("       |                       |");
	    System.out.println("       |  " + GREEN + "EMPLOYEE SYSTEM HQ" + BLUE + "   |");
	    System.out.println("       |_______________________|");

	    for (String floor : floors) {
	        System.out.println(floor);
	    }

	    System.out.println("       |_______________________|" + ANSI_RESET);
	}
	
	public static int showMenuAndAcceptUserInput() {
		System.out.println("\n\n*********************************");
		String message = "Welcome to the Employee CLI Application!";
        for (char c : message.toCharArray()) {
            System.out.print(RED+ c +ANSI_RESET);
            try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
		System.out.println("\n--------------------------------------");
		System.out.println("Enter 0 for EXIT");
		System.out.println("Enter 1 for "+GREEN+"ADDING"+ANSI_RESET+" employee details");
		System.out.println("Enter 2 for "+YELLOW+"LISTING "+ANSI_RESET+"all employee details");
		System.out.println("Enter 3 for "+CYAN+"SEARCHING "+ANSI_RESET+" employee details");
		System.out.println("Enter 4 for "+RED+"REMOVING "+ANSI_RESET+"employee details");
		System.out.println("--------------------------------------");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		sc.nextLine();
		

		return choice;
	}

	public static int showSearchParamAcceptUserInput() {

		System.out.println("\n\n****SEARCH****");
		System.out.println("Enter your search Parameter");
		System.out.println("-----------------------------------");
		System.out.println("Enter 1 for search according to NAME");
		System.out.println("Enter 2 for search according to ID");
		System.out.println("Enter 3 for search according to DEPT");
		System.out.println("Enter 4 for search according to SALARY");
		System.out.println("Enter 5 for search according to JOINING_DATE");
		System.out.println("-----------------------------------");
		System.out.println("Enter your choice: ");
		int searchchoice = sc.nextInt();
		sc.nextLine();

		return searchchoice;
	}

	public static String showOperatorMenuAndAcceptUserInput() {

		System.out.println("\n\n***********OPERATOR****************");
		System.out.println("Enter your operator");
		System.out.println("------------------------------------------");
		System.out.println("Enter for Equals");
		System.out.println("Enter > for GreaterThan");
		System.out.println("Enter < for Lesser Than");
		System.out.println("Enter > for Greater ThanAndEqualTo");
		System.out.println("Enter <= for Lesser ThanAndEqualTo");
		System.out.println("Enter ! for NotEqualTo");
		System.out.println("----------------------------------------");
		System.out.println("Enter your choice: ");
		String choice = sc.nextLine();

		return choice;

	}

	public static void acceptEmpDetails() {
		System.out.println("Enter the name of Employee: ");
		String name = sc.nextLine();

		System.out.println("Enter the dept of Employee: ");
		String dept = sc.nextLine();

		System.out.println("Enter the salary of Employee: ");
		int salary = sc.nextInt();

		System.out.println("Enter the joiningDate of Employee: ");
		LocalDate joiningDate = LocalDate.now();

		empId = empList.isEmpty() ? 1 : empList.size() + 1;
		Employee emp = new Employee(empId, name, dept, salary, joiningDate);
		empList.add(emp);
		
		System.out.print(GREEN+"✔ Employee Added Successfully!"+ANSI_RESET);

	}

	public static void invokeSearchSwitchCase(int searchParam) {
		switch (searchParam) {
		case 1:
			System.out.println("You entered 1 to search by NAME");
			System.out.println("Enter the name of employee: ");
			String nameToBeSearched = sc.nextLine();
			showLoading();
			empList.stream().filter(e -> nameToBeSearched.equalsIgnoreCase(e.getName())).forEach(System.out::println);
			break;

		case 2:
			System.out.println("You entered 2 to search by ID");
			System.out.println("Enter the ID of employee: ");
			int idToBeSearched = sc.nextInt();
			showLoading();
			empList.stream().filter(e -> idToBeSearched == e.getId()).forEach(System.out::println);
			break;

		case 3:
			System.out.println("You entered 3 to search by DEPT");
			System.out.println("Enter the DEPT of employee: ");
			String deptToBeSearched = sc.nextLine();
			showLoading();
			empList.stream().filter(e -> deptToBeSearched.equalsIgnoreCase(e.getDepartment()))
					.forEach(System.out::println);
			break;

		case 4:
			System.out.println("You entered 4 to search by SALARY");
			System.out.println("Enter the SALARY of employee: ");
			int salaryToBeSearched = sc.nextInt();
			showLoading();
			empList.stream().filter(e -> salaryToBeSearched == e.getSalary()).forEach(System.out::println);
			break;

		}

	}

	public static void main(String[] args) {

		showOfficeAnimation();

		int ch=showMenuAndAcceptUserInput(); 
		boolean runFlag=true;
		while(runFlag) {
		switch(ch) {
		case 1:
			System.out.println("You have entered option 1. Let's add employee details!");
			acceptEmpDetails();
			ch=showMenuAndAcceptUserInput();
			break;

		case 2:
			if(empList.isEmpty()) {
				System.out.println("No Employees in list!"+RED+" Add employees first."+ANSI_RESET);
				ch=showMenuAndAcceptUserInput();
				break;
			}
			System.out.println("You have entered option 2. Let's list all employees!");
			System.out.println("| ID | NAME            | SALARY | JOINING DATE|");
			empList.forEach(emp-> System.out.println("| " +emp.getId()+" | "+emp.getName()+" | "+emp.getSalary()+" | " +emp.getJoiningDate()+" |"));
			ch=showMenuAndAcceptUserInput();
		break;

		case 3:
			System.out.println("You have entered option 3. Let's search any employee.");
			int searchParam = showSearchParamAcceptUserInput();
			invokeSearchSwitchCase(searchParam);
			ch=showMenuAndAcceptUserInput();
		break;

		case 4:
			System.out.println("You have entered option 4. Let's remove an employee");
			if(empList.isEmpty()) {
				System.out.println("There are no employees to remove! "+RED+"Add employees first."+ANSI_RESET);
				ch=showMenuAndAcceptUserInput();
				break;
			}
			System.out.println("Enter ID of employee you want to remove: ");
			int removeEmpId = sc.nextInt();
			empList.remove(removeEmpId-1);
			System.out.println(RED+"Employee removed successfully!"+ANSI_RESET);
			ch=showMenuAndAcceptUserInput();
		break;

		case 0:
			runFlag = false;
			System.out.println(PURPLE+"Bye! You have EXITED the application!"+ANSI_RESET);
			sc.close();
			break;
		}
		
	}
	}

}
