package com.mindtree.manager;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mindtree.DAO.DAO;
import com.mindtree.entiry.Book;
import com.mindtree.entiry.Purchase;
import com.mindtree.exception.MyException;

public class BookStoreSystemManager {
	DAO dao = new DAO();
	final static Logger logger = Logger.getLogger(BookStoreSystemManager.class);

	public List<Book> checkCategory(String category) {
		logger.info("Entered checkCategory() ");
		List<Book> list = null;
		if (category.endsWith("Technology") || category.equalsIgnoreCase("General")
				|| category.equalsIgnoreCase("Kids")) {
			try {
				list = dao.getBooks(category);
				logger.info("Retrives data successfully:");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				logger.error("SQL Exceptions", e);
			}

		} else {
			try {
				throw new MyException("InvalidCategoryException");
			} catch (MyException e) {
				System.out.println("Invalid category name please check your input:" + e.getMessage());
				logger.info("Invalid category name please check your input:", e);
			}
		}
		return list;

	}

	public Purchase checkPhAndCheckBookId(int book_Id, String cust_Name, String phNo) {
		logger.info("Executing checkPhAndCheckBookId()");
		int len = phNo.length();
		Purchase purchase = null;
		if (len < 10) {
			try {
				throw new MyException("InvalidMobileNoException");
			} catch (MyException e) {
				System.out.println("Invalid mobile no, please check your input:" + e.getMessage());
				logger.error("Invalid mobile no, please check your input:", e);
			}
		} else if (book_Id == 1001 || book_Id == 1002 || book_Id == 1003 || book_Id == 1004 || book_Id == 1005
				|| book_Id == 1006) {
			try {

				purchase = dao.purchase(book_Id, cust_Name, phNo);
				logger.info("Inserted and retrives the data properly");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				logger.error("SQL Exceptions:", e);
			}

		} else {
			try {
				throw new MyException("InvalidBookIdException");
			} catch (MyException e) {
				System.out.println("Invalid book id, please check your input" + e.getMessage());
				logger.error("Invalid book id, please check your input", e);
			}
		}
		return purchase;
	}
}
