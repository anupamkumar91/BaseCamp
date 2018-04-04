package com.mindtree.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mindtree.entiry.Book;
import com.mindtree.entiry.Purchase;
import com.mindtree.manager.BookStoreSystemManager;

public class BookStoreSystemClient {

	public static void main(String[] args) throws SQLException {

		BookStoreSystemManager manager = new BookStoreSystemManager();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("1:Display Book Details:");
			System.out.println("2:Purchase a book:");
			System.out.println("3:Exit:");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("-------------------------");
				System.out.println("Availabe book categories");
				System.out.println("-------------------------");
				System.out.println("Enter the category[Kids,General,Technology]:");
				String category = sc.next();
				List<Book> list = manager.checkCategory(category);
				if (list == null) {
					break;
				}
				System.out.println("Id   Name   Author   Publisher   Price");
				for (Book b : list) {
					System.out.print(b.getBookId() + "," + b.getBookName() + "," + b.getAuthorName() + ","
							+ b.getPublisherName() + "," + b.getPrice());
					System.out.println();
				}
				System.out.println();
				break;
			case 2:
				System.out.println("------------------------");
				System.out.println("Purchase Book");
				System.out.println("-------------------------");
				System.out.println("Enter book id:");
				int bid = sc.nextInt();
				System.out.println("Enter customer name:");
				String name = sc.next();
				System.out.println("Enter customer mobile number:");
				String phno = sc.next();
				Purchase response = manager.checkPhAndCheckBookId(bid, name, phno);
				if (response == null) {
					break;
				}
				System.out.println("Book successfully purchased!");
				System.out.println("purchase number:" + response.getPurchaseId());
				System.out.println("purchase date:" + response.getDate());
				System.out.println("purchase amount:" + response.getAmount());
				break;

			case 3:
				flag = false;
				break;

			default:
				System.out.println("Wrong selection:");
			}
		}
	}
}
