import java.util.HashMap;

public class vd1 {
	public static void main(String[] args) {
		HashMap<String, SinhVien> mapSV = new HashMap<String, SinhVien>();
		SinhVien sv1 = new SinhVien("FTSE1", "Vui1", 12, 10);
		SinhVien sv2 = new SinhVien("FTSE2", "Vui2", 12, 10);
		SinhVien sv3 = new SinhVien("FTSE3", "Vui3", 12, 10);
		SinhVien sv4 = new SinhVien("FTSE4", "Vui4", 12, 10);
		SinhVien sv5 = new SinhVien("FTSE5", "Vui5", 12, 10);
		
		mapSV.put(sv1.getId(), sv1);
		mapSV.put(sv2.getId(), sv2);
		mapSV.put(sv3.getId(), sv3);
		mapSV.put(sv4.getId(), sv4);
		mapSV.put(sv5.getId(), sv5);
		
		SinhVien sv6 = mapSV.get("Sinh vien 2");
		if(sv6 != null)
			System.out.println(sv6.getName() + "   " + sv6.getId());
		String key = "FTSE5";
		SinhVien sv7 = mapSV.get(key);
		if(sv7 != null)
			System.out.println(sv7.getName() + "   " + sv7.getId());

	}
}
