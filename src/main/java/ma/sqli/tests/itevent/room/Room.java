package ma.sqli.tests.itevent.room;

public abstract class Room {
	protected int number ;

	/**
	 * @param number
	 */
	public Room(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	} 
	
	public abstract String print();
	
	
	
}
