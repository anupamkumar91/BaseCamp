package empservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import bean.Employee;

@WebService
public class EmployeeService {
	Employee emp = new Employee();

	@WebMethod(action = "Employee")
	public Employee getEmployee(int id) {
		Employee employee = new Employee();
		try {

			Connection con = EmployeeService.getConnection();
			PreparedStatement ps = con.prepareStatement("select*from EMP where employeeNo=?");
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				employee.setEmployeeNo(set.getInt(1));
				employee.setEmployeeName(set.getString(2));
				employee.setEmail(set.getString(3));
				employee.setDateOfBirth(set.getDate(4));
				employee.setSalary(set.getDouble(5));
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return employee;
	}

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "Welcome123");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {

	}
}
