package ma.sqli.tests.itevent.room;

public class Suite extends Room{

	/**
	 * @param number
	 */
	public Suite(int number) {
		super(number);
	}

	@Override
	public String print() {
		return "Suite N°"+number;
	}

	
	
	
	
}
