package ma.sqli.tests.itevent.factory;

import java.util.ArrayList;
import java.util.List;

import ma.sqli.tests.itevent.Offer;
import ma.sqli.tests.itevent.customer.Attendee;
import ma.sqli.tests.itevent.customer.Customer;
import ma.sqli.tests.itevent.customer.Speaker;
import ma.sqli.tests.itevent.customer.Staff;

public class CustomerFactory {

	public Customer createInstance(String offer, String name) {
		switch (offer) {
		case "STAFF":
			return new Staff(name);
		case "SPEAKER":
			return new Speaker(name);
		case "TRINGA":
			return new Attendee(name, Offer.TRINGA);

		case "CONF":
			return new Attendee(name, Offer.CONF);

		case "DEEP DIVE":
			return new Attendee(name, Offer.DEEP_DIVE);
		default:
			return null;
		}
	}
	public List<Customer> createGroupOfCustomers(String ...offerAndnames) {
		String offer = offerAndnames[0];
		List<Customer> customers = new ArrayList<Customer>(); 
		for (int i=1;i<offerAndnames.length;i++) 
			customers.add(createInstance(offer, offerAndnames[i]));

		return customers;
		
	}
}
