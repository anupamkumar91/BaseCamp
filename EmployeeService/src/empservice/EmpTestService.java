package empservice;

import javax.xml.ws.Endpoint;

public class EmpTestService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Endpoint.publish("http://localhost:8080/EmployeeService", new EmployeeService());
		System.out.println("Service created:");

		// EmployeeService employeeService = new EmployeeService();
		// int id = 2;
		// String str = employeeService.getEmployee(id);
		// System.out.println(str);

	}

}
