package ma.sqli.tests.itevent;

public enum Offer {
	TRINGA("TRINGA"),
	CONF("CONF"),
	DEEP_DIVE("DEEP_DIVE");
	private String title;
	/**
	 * @param title
	 */
	private Offer(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
