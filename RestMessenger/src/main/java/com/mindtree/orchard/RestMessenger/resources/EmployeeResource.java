package com.mindtree.orchard.RestMessenger.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.mindtree.orchard.RestMessenger.model.Employee;

@Path("/employee")
public class EmployeeResource {

	final static Logger logger = Logger.getLogger(EmployeeResource.class);

	@GET
	@Path("/getallemployee")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployee() {
		logger.info("Entered getAllEmployee method:");
		Employee employee;
		ArrayList<Employee> emp = new ArrayList<Employee>();
		try {

			Connection con = EmployeeResource.getConnection();
			PreparedStatement ps = con.prepareStatement("select*from EMP");
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				employee = new Employee();
				employee.setEmployeeNo(set.getInt(1));
				employee.setEmployeeName(set.getString(2));
				employee.setEmail(set.getString(3));
				employee.setSalary(set.getDouble(4));
				emp.add(employee);
			}
			con.close();
			logger.info("all employees fethced");
		}

		catch (Exception e) {
			logger.error("Error occured while fetching employee" + e.getMessage());

			e.printStackTrace();
		}

		return emp;
	}

	@GET
	@Path("getemployee/{empId}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("empId") int eid) {
		logger.info("Entered into get employee method");
		Employee employee = new Employee();
		logger.info("employeeID entered is" + eid);
		try {

			Connection con = EmployeeResource.getConnection();
			PreparedStatement ps = con.prepareStatement("select*from EMP where employeeNo=?");
			ps.setInt(1, eid);
			ResultSet set = ps.executeQuery();
			while (set.next()) {

				employee.setEmployeeNo(set.getInt(1));
				employee.setEmployeeName(set.getString(2));
				employee.setEmail(set.getString(3));
				employee.setSalary(set.getDouble(4));
			}
			con.close();
		}

		catch (Exception e) {
			logger.error("error occured while fetching employees" + e.getMessage());
			e.printStackTrace();
		}

		return employee;
	}

	@POST
	@Path("/addemployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {

		try {
			Connection con = EmployeeResource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into EMP(employeeNo,employeeName,email,salary) values(?,?,?,?)");
			ps.setInt(1, emp.getEmployeeNo());
			ps.setString(2, emp.getEmployeeName());
			ps.setString(3, emp.getEmail());
			ps.setDouble(4, emp.getSalary());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity("Employee added successfully").build();
	}

	@PUT
	@Path("/updatemployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee emp) {

		try {
			Connection con = EmployeeResource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update EMP set employeeName=?,email=?,salary=? where employeeNo=?");

			ps.setString(1, emp.getEmployeeName());
			ps.setString(2, emp.getEmail());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getEmployeeNo());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity("Employee record updated successfully").build();
	}

	@DELETE
	@Path("/deletemployee")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmployee(@QueryParam("eid") int id) {

		try {

			Connection con = EmployeeResource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from EMP where employeeNo=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity("Employee recorde deleted successfully").build();
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

}
