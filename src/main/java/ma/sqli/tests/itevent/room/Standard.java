package ma.sqli.tests.itevent.room;

public class Standard extends Room {

	/**
	 * @param number
	 */
	public Standard(int number) {
		super(number);
	}

	public String print() {
		return "Standard room N°"+number;
	}
	
	
}
