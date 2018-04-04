package test;

import java.util.Scanner;

import DAO.Dao;
import beans.Candidates;
import beans.Constituencies;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		Scanner sc = new Scanner(System.in);

		String result = "y";
		do {
			System.out.println("1:To Add Constituency:");
			System.out.println("2:To Add Candidates:");
			System.out.println("3:To Display With Constituency Id:");
			System.out.println("4:To Display With PartyName:");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				Constituencies cons = new Constituencies();
				System.out.println("Enter Constituency Number:");
				cons.setName(sc.next());
				System.out.println("Added Successfuly");
				break;
			case 2:
				Candidates candidates = new Candidates();
				System.out.println("Enter Candidates name:");
				candidates.setName(sc.next());
				System.out.println("Enter Candidates ConsituencyID:");
				candidates.setConsituencyID(sc.nextInt());
				System.out.println("Enter Candidates party:");
				candidates.setParty(sc.next());
				dao.addCandidates(candidates);
				break;
			case 3:
				System.out.println("Enter the ConstituencyID:");
				dao.diplayWithConsId(sc.nextInt());
				break;
			case 4:
				System.out.println("Enter the Party name:");
				dao.displayWithGivenParty(sc.next());
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