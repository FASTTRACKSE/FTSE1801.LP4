
public class demo {
	public static void main(String[] args) {
		String c = "Pham Ngoc Hoi ";
		String b = "Pham";
		String[] a1 = c.split(" ");
		for(String x:a1) {
			if(x.equals(b)) {
				System.out.println("dung");

			}
			
		}
	}
}
