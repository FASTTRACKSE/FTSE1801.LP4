
public class demo {
	public static void main(String[] args) {
		String a = "   afshahf asda \\t fẤ   ";
		System.out.println(new String(a.toUpperCase()).toLowerCase());
		System.out.println(a.length());
		System.out.println(a.trim().length());
		System.out.println(a.length());
		System.out.println(a);
		
		String b = "12345 67890";
		System.out.println(b.substring(2));
		System.out.println(b.substring(2, 7));
		System.out.println(b.charAt(3));
		System.out.println(b.replaceAll("6", "7"));
		
		String c = "Pham Ngoc Hoi Ngoc ";
		String[] a1 = c.split(" ");
		String[] a2 = c.split(" Ngoc ");
		for(String x:a1) {
			System.out.println(x);
			
		}
		
		for(String x:a2) {
			System.out.println(x);
		}
		
		String d ="phạm ngọc hợi";
		String x1 = "";
		String[] a3 = d.split(" ");
		
		for(String x:a3) {
			x1 = x1 +x.toUpperCase().charAt(0)  + x.substring(1) + " ";
		}
		System.out.println(x1.trim());
	}

	
}
