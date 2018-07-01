package demo.game;

public class Card {
	private String type;
	private int nodeValue;
	private String nodeDipslay;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}

	public String getNodeDipslay() {
		return nodeDipslay;
	}

	public void setNodeDipslay(String nodeDipslay) {
		this.nodeDipslay = nodeDipslay;
	}

	public String inCard() {
		return nodeDipslay + " " + type;
	}
}
