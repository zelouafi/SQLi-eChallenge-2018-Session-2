package ma.sqli.tests.itevent.factory;

import ma.sqli.tests.itevent.room.Apartment;
import ma.sqli.tests.itevent.room.Room;
import ma.sqli.tests.itevent.room.Standard;
import ma.sqli.tests.itevent.room.Suite;

public class RoomFactory {

	public Room createInstance(int number, String type) {
		switch (type) {
		case "Stantard":
			return new Standard(number);
		case "Suite":
			return new Suite(number);
		case "Apar":
			return new Apartment(number);

		default:
			return null;
		}
	}
}
