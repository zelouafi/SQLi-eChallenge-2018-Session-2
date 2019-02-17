package ma.sqli.tests.itevent;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.tests.itevent.config.Config;
import ma.sqli.tests.itevent.customer.Attendee;
import ma.sqli.tests.itevent.customer.Customer;
import ma.sqli.tests.itevent.customer.Speaker;
import ma.sqli.tests.itevent.customer.Staff;
import ma.sqli.tests.itevent.factory.RoomFactory;
import ma.sqli.tests.itevent.room.Room;

public class Hotel {

	private int standardRooms;
	private int suites;
	private int apparts;
	private List<Room> rooms = new ArrayList<Room>();
	private RoomFactory roomFactory = new RoomFactory();
	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * @param standardRooms
	 * @param suites
	 * @param apparts
	 */
	public Hotel(int standardRooms, int suites, int apparts) {
		this.standardRooms = standardRooms;
		this.suites = suites;
		this.apparts = apparts;
		Config.init(standardRooms, suites, apparts);
	}

	/**
	 * 
	 * @return return form of hotel
	 */
	public String checkAvailibility() {
		return "Standard rooms: " + standardRooms + "|Suites: " + suites + "|Aparts: " + apparts;
	}

	/**
	 * 
	 * @param customer
	 * @return false if customer is already save
	 */
	public boolean addCustomer(Customer customer) {
		String name = customer.getName();
		if (customer instanceof Speaker) {
			if (suites > 0) {
				Room room = roomFactory.createInstance(Config.getSuites() - suites + 1, "Suite");
				customer.setRoom(room);
				customers.add(customer);
				suites--;
				return true;
			}

		} else if (customer instanceof Staff) {
			if (searchCustomer(name) == null) {
				if (standardRooms > 0) {
					Room room = roomFactory.createInstance(Config.getStandardRooms() - standardRooms + 1, "Stantard");
					customer.setRoom(room);
					customers.add(customer);
					standardRooms--;
				} else {
					Room room = roomFactory.createInstance(Config.getApparts() - apparts + 1, "Apar");
					customer.setRoom(room);
					customers.add(customer);
					apparts--;
				}
				return true;
			}
		} else if (customer instanceof Attendee) {
			Attendee attendee = (Attendee) customer;
			if (attendee.getOffer().getTitle().equals("DEEP_DIVE")) {
				if (getConfCustomer() != null) {
					attendee.setRoom(getConfCustomer().getRoom());
					customers.add(attendee);
					return true;
				}

			}

			if (searchCustomer(name) == null) {
				if (standardRooms > 0) {
					Room room = roomFactory.createInstance(Config.getStandardRooms() - standardRooms + 1, "Stantard");
					customer.setRoom(room);
					customers.add(customer);
					standardRooms--;
				} else {
					Room room = roomFactory.createInstance(Config.getApparts() - apparts + 1, "Apar");
					customer.setRoom(room);
					customers.add(customer);
					apparts--;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * add group of customers
	 * 
	 * @param customers
	 * @return
	 */
	public boolean addCustomers(List<Customer> customers) {
		Customer customerTemp = customers.get(0);
		if (customerTemp instanceof Attendee) {
			if (standardRooms < customers.size()) {
				for (Customer customer : customers) {
					Room room = roomFactory.createInstance(Config.getApparts() - apparts + 1, "Apar");
					customer.setRoom(room);
					this.customers.add(customer);
					apparts--;
				}
				return true;
			} else {
				for (Customer customer : customers) {
					addCustomer(customer);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return conf customer
	 */
	public Attendee getConfCustomer() {
		for (Customer customer : customers) {
			if (customer instanceof Attendee) {
				Attendee attendee = (Attendee) customer;
				if (attendee.getOffer().getTitle().equals("CONF")) {
					return attendee;
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @return
	 */
	public Attendee getDepCustomer() {
		for (Customer customer : customers) {
			if (customer instanceof Attendee) {
				Attendee attendee = (Attendee) customer;
				if (attendee.getOffer().getTitle().equals("DEEP_DIVE")) {
					return attendee;
				}
			}
		}
		return null;
	}

	/**
	 * search customer by name
	 * 
	 * @param name
	 * @return
	 */
	public Customer searchCustomer(String name) {
		for (Customer customer : customers) {
			if (name.equals(customer.getName())) {
				return customer;
			}
		}
		return null;
	}

	public String getRoomFor(String name) {
		Customer customer = searchCustomer(name);
		return customer.getRoom().print();
	}

	public int getStandardRooms() {
		return standardRooms;
	}

	public void setStandardRooms(int standardRooms) {
		this.standardRooms = standardRooms;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}

	public int getApparts() {
		return apparts;
	}

	public void setApparts(int apparts) {
		this.apparts = apparts;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
