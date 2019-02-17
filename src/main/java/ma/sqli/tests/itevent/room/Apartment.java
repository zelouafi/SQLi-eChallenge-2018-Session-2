package ma.sqli.tests.itevent.room;

public class Apartment extends Room {

	/**
	 * @param number
	 */
	public Apartment(int number) {
		super(number);
	}

	@Override
	public String print() {
		return "Apart N°"+number;
	}

	
	
	
}
