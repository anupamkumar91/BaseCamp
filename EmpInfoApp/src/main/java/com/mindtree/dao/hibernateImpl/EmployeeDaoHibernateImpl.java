package com.mindtree.dao.hibernateImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.midntree.entity.Employee;
import com.mindtree.dao.EmployeeDao;

public class EmployeeDaoHibernateImpl {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		EmployeeDao dao = new EmployeeDao();
		Scanner sc = new Scanner(System.in);

		String result = "y";
		do {
			System.out.println("1:To Add Employee:");
			System.out.println("2:To Get Employee:");
			System.out.println("3:To Delete Employee:");
			System.out.println("4:To Update Employee:");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Employee Number:");
				emp.setEmployeeNo(sc.nextInt());
				System.out.println("Enter Employee Name:");
				emp.setEmployeeName(sc.next());
				System.out.println("Enter Employee Email:");
				emp.setEmail(sc.next());
				System.out.println("Enter Employee DOB(dd/mm/yy):");
				Date date = new SimpleDateFormat("dd/mm/yy").parse(sc.next());
				emp.setDateOfBirth(date);
				System.out.println("Enter Employee Salary:");
				emp.setSalary(sc.nextDouble());
				int resultSet = dao.addEmployee(emp);
				System.out.println(resultSet);
				break;
			case 2:
				System.out.println("Enter Employee Number:");
				int empNo = sc.nextInt();
				String employee = dao.getEmployee(empNo);
				System.out.println("Employee Details are:");
				System.out.println(employee);
				// System.out.println(employee.getEmployeeNo());
				// System.out.println(employee.getEmployeeName());
				// System.out.println(employee.getEmail());
				// System.out.println(employee.getDateOfBirth());
				// System.out.println(employee.getSalary());
				break;

			case 3:
				System.out.println("Enter Employee Number:");
				int no = sc.nextInt();
				dao.deleteEmployee(no);
				break;

			case 4:
				System.out.println("Enter Employee Number:");
				int empNumber = sc.nextInt();
				dao.updateEmployee(empNumber);
				break;
			default:
				System.out.println("Wrong selection:");
			}
			System.out.println("Enter Y to continue or N for exit?");
			result = sc.next();
		} while (result.equalsIgnoreCase("y"));
		System.out.println("Exit Successfully:");
		sc.close();
	}

}
