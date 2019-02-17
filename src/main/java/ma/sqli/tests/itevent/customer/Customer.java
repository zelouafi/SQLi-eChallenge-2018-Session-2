package ma.sqli.tests.itevent.customer;

import ma.sqli.tests.itevent.room.Room;

public abstract class Customer {
	private String name ;
	private Room room;
	/**
	 * @param name
	 * @param offer
	 */
	public Customer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
	

}
