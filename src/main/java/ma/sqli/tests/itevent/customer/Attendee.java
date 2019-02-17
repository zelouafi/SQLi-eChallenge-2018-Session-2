package ma.sqli.tests.itevent.customer;

import ma.sqli.tests.itevent.Offer;
import ma.sqli.tests.itevent.room.Room;

public class Attendee extends Customer{

	private Offer offer ;
	

	public Attendee(String name , Offer offer) {
		super(name);
		this.offer = offer;
	}


	public Offer getOffer() {
		return offer;
	}


	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	
	
}
