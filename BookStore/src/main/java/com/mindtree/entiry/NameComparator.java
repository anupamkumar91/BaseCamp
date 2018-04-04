package com.mindtree.entiry;

import java.util.Comparator;

public class NameComparator implements Comparator {

	public int compare(Object ob1, Object ob2) {
		Book b1 = (Book) ob1;
		Book b2 = (Book) ob2;

		return b1.getBookName().compareTo(b2.getBookName());
	}
}