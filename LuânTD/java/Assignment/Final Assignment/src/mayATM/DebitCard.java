package mayATM;

public class DebitCard {
	private String id;
	private String pin;
	public DebitCard(String id, String pin) {
		super();
		this.id = id;
		this.pin = pin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	

}
