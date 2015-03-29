package ch.ethz.globis.isk.persistence.db4o;

public enum PersistenceAttributes {
	
	TITLE("title"),
	NAME("name"),
	CONFERENCE("conference"),
	ID("id"),
	YEAR("year"),
	JOURNAL("journal"),
	VOLUME("volume"),
	NUMBER("number");
	
	private final String name;
	
	private PersistenceAttributes(String s) {
		name = s;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
