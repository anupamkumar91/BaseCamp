package beans;

public class Candidates {
	private int id;
	private String name;
	private int ConsituencyID;
	private String party;

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

	public int getConsituencyID() {
		return ConsituencyID;
	}

	public void setConsituencyID(int consituencyID) {
		ConsituencyID = consituencyID;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

}
