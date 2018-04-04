package com.mindtree.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.mindtree.entiry.Book;
import com.mindtree.entiry.NameComparator;
import com.mindtree.entiry.Purchase;

public class DAO {
	final static Logger log = Logger.getLogger(DAO.class);

	public List<Book> getBooks(String category) throws SQLException {
		log.info("Executing getBooks()");
		ArrayList<Book> arrayList = new ArrayList<Book>();
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String query = ("select*from book where Category='" + category + "'");
		ResultSet resultSet = stmt.executeQuery(query);

		while (resultSet.next()) {
			Book bk = new Book();

			bk.setBookId(resultSet.getInt("Book_Id"));
			bk.setBookName(resultSet.getString("Book_name"));
			bk.setAuthorName(resultSet.getString("Author_name"));
			bk.setPublisherName(resultSet.getString("Publisher"));
			bk.setCategoryName(resultSet.getString("Category"));
			bk.setPrice(resultSet.getInt("price"));
			arrayList.add(bk);
		}
		stmt.close();
		con.close();
		Collections.sort(arrayList, new NameComparator());
		log.info("Done successfully:");
		return arrayList;
	}

	public Purchase purchase(int book_Id, String cust_Name, String phNo) throws SQLException {
		log.info("Executing purchase()");
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		String str = ("select price from book where Book_Id='" + book_Id + "'");
		ResultSet set = stmt.executeQuery(str);
		int price = 0;
		while (set.next()) {
			price = set.getInt("price");
		}
		set.close();
		stmt.close();
		PreparedStatement ps = con.prepareStatement(
				"insert into purchase(Book_Id,Customer_name,Customer_mobileno,Purchase_date,Amount)values(?,?,?,?,?)");
		ps.setInt(1, book_Id);
		ps.setString(2, cust_Name);
		ps.setString(3, phNo);
		ps.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
		ps.setInt(5, price);
		ps.executeUpdate();
		ps.close();
		String query = ("select*from purchase where Book_Id='" + book_Id + "'");
		Statement stmt2 = con.createStatement();
		ResultSet resultSet = stmt2.executeQuery(query);
		Purchase purchase = new Purchase();

		while (resultSet.next()) {
			purchase.setPurchaseId(resultSet.getInt("Purchase_no"));
			purchase.setCustomerMobileNo(resultSet.getString("Customer_mobileno"));
			purchase.setDate(resultSet.getDate("Purchase_date"));
			purchase.setAmount(resultSet.getInt("Amount"));

		}
		log.info("Done successfully:");
		return purchase;

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
