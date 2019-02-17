package ma.sqli.tests.itevent.config;

public class Config {
	
	private static int standardRooms ;
	private static int suites ;
	private static int apparts ;
	public static int getStandardRooms() {
		return standardRooms;
	}
	public static int getSuites() {
		return suites;
	}
	public static int getApparts() {
		return apparts;
	}

	public static void init(int standardRoomsParam, int suitesParam , int appartsParam) {
		standardRooms = standardRoomsParam;
		suites = suitesParam + 100;
		apparts = appartsParam + 200;
	}
	
}
