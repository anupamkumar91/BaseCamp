package com.mindtree.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.midntree.entity.Employee;

public class EmployeeDao {

	static SessionFactory sessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return sessionFactory;

	}

	public int addEmployee(Employee emp) {

		Session session = sessionFactory().openSession();
		int result = 0;
		try {
			Transaction transaction = session.beginTransaction();
			result = (Integer) session.save(emp);
			transaction.commit();
		} catch (HibernateException e) {

			System.out.println(e.getMessage());
		} finally {

			session.close();
		}

		return result;
	}

	public String getEmployee(int empNo) {
		Session session = sessionFactory().openSession();
		Employee employee = null;
		try {
			String hql = "from Employee where employeeNo=:no";
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("no", empNo);
			List<Employee> emp = query.list();
			for (Employee e : emp) {
				employee = e;
			}
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return employee.toString();
	}

	public void deleteEmployee(int empNo) {
		Session session = sessionFactory().openSession();
		Employee employee = null;
		try {
			String hql = "from Employee where employeeNo=:empNo";
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("empNo", empNo);
			List<Employee> emp = query.list();
			for (Employee e : emp) {
				employee = e;
			}
			session.delete(employee);

			transaction.commit();
			System.out.println("Record deleted successfuly:");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	public void updateEmployee(int eno) {

		Session session = sessionFactory().openSession();
		Scanner scanner = new Scanner(System.in);
		Employee employee = null;
		try {

			String hql = "from Employee where employeeNo=:empNo";
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("empNo", eno);
			List<Employee> emp = query.list();
			for (Employee e : emp) {
				employee = e;
			}
			System.out.println("Enter Salary for Updation:");
			Double sal = scanner.nextDouble();
			employee.setSalary(sal);
			session.update(employee);

			transaction.commit();
			System.out.println("Record updated successfuly:");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			// scanner.close();
			session.close();
		}
	}

	// public static void main(String[] args) {
	//
	// }

}
