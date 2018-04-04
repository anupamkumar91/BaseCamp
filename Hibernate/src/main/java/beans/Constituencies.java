package beans;

import java.util.Set;

public class Constituencies {

	private int id;
	private String name;
	private Set<Candidates> candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Candidates> getCandidate() {
		return candidate;
	}

	public void setCandidate(Set<Candidates> candidate) {
		this.candidate = candidate;
	}

}
