package mayATM;

public class User {
	private String name;
	private double money;
	private String typeMoney;
	private String status;
	public User(String name, double money, String typeMoney, String status) {
		super();
		this.name = name;
		this.money = money;
		this.typeMoney = typeMoney;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTypeMoney() {
		return typeMoney;
	}
	public void setTypeMoney(String typeMoney) {
		this.typeMoney = typeMoney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
