package ma.sqli.tests.itevent;

import ma.sqli.tests.itevent.factory.CustomerFactory;

public class Event {

	private Hotel hotel;
	private CustomerFactory customerFactory = new CustomerFactory();
	//private EventManager eventManager = new EventManager();
	
	/**
	 * @param hotel
	 */
	public Event(Hotel hotel) {
		this.hotel = hotel;
	}

	public boolean register(String ...customersInfo) {
		if (customersInfo.length == 2) {
			return hotel.addCustomer(customerFactory.createInstance(customersInfo[0], customersInfo[1]));
		}
		else {
			return hotel.addCustomers(customerFactory.createGroupOfCustomers(customersInfo));
		}
	}
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}
