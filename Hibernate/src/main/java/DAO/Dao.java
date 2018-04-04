package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import beans.Candidates;
import beans.Constituencies;

public class Dao {

	static Session configuration() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	public void addConstituency(Constituencies constituencies) {

		Session session = configuration();
		session.save(constituencies);
		session.beginTransaction().commit();
		session.close();
	}

	public void addCandidates(Candidates candidates) {

		Session session = configuration();
		session.save(candidates);
		session.beginTransaction().commit();
		session.close();
	}

	public void diplayWithConsId(int id) {
		String hql = "from Candidates where ConsituencyID=:cid ";
		Session session = configuration();
		Query query = session.createQuery(hql);
		query.setParameter("cid", id);
		List<Candidates> candid = query.list();
		for (Candidates c : candid) {
			System.out.println("Candidate Name:" + c.getName());
			System.out.println("Candidate Party:" + c.getParty());
		}

		String hql2 = "from Constituencies where id=:cid";
		Query query2 = session.createQuery(hql2);
		query2.setParameter("cid", id);
		List<Constituencies> consti = query2.list();
		for (Constituencies con : consti) {
			System.out.println("Constituencies Name:" + con.getName());
			System.out.println("Constituencies Id:" + con.getId());
		}
		session.close();
	}

	public void displayWithGivenParty(String party) {
		String hql = "from Candidates where party=:cparty";
		Session session = configuration();
		Query query = session.createQuery(hql);
		query.setParameter("cparty", party);
		List<Candidates> candid = query.list();
		for (Candidates c : candid) {

			System.out.println("Candidate Name:" + c.getName());
			int id = c.getId();
			String hql2 = "from Constituencies where id=:cid";
			Query query2 = session.createQuery(hql2);
			query2.setParameter("cid", id);
			List<Constituencies> consti = query2.list();
			for (Constituencies con : consti) {
				System.out.println("Constituencies Name:" + con.getName());
			}

		}

	}

	public static void main(String[] args) {

	}
}
