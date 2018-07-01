
import java.util.Comparator;

public class NvComparator {
	public static Comparator<CanBo> NVNameASCComparator = new Comparator<CanBo>() {

		public int compare(CanBo nv1, CanBo nv2) {
			String codenv1 = nv1.getHoTen().toUpperCase();
			String codenv2 = nv2.getHoTen().toUpperCase();

			// ascending order
			return codenv1.compareTo(codenv2);
		}
	};

	public static Comparator<CanBo> NVNameDESCComparator = new Comparator<CanBo>() {

		public int compare(CanBo nv1, CanBo nv2) {
			String namenv1 = nv1.getHoTen().toUpperCase();
			String namenv2 = nv2.getHoTen().toUpperCase();

			// descending order
			return namenv2.compareTo(namenv1);
		}
	};

	/* Comparator for sorting the list by roll no */
	public static Comparator<CanBo> NhanVienLTBASComparator = new Comparator<CanBo>() {

		public int compare(CanBo nv1, CanBo nv2) {

			double fTL1 = nv1.tinhLuong();
			double fTL2 = nv2.tinhLuong();

			/* For ascending order */
			if ((fTL2 - fTL1) > 0)
				return 1;
			else if ((fTL2 - fTL1) < 0)
				return -1;
			else
				return 0;

			
		}
	};
	public static Comparator<CanBo> CanBoLuongASComparator = new Comparator<CanBo>() {

		public int compare(CanBo s1, CanBo s2) {

			/* For ascending order */
			if ((s2.tinhLuong() - s1.tinhLuong()) > 0)
				return 1;
			else if ((s2.tinhLuong() - s1.tinhLuong()) < 0)
				return -1;
			else

				return s1.getHoTen().compareTo(s2.getHoTen());

		
		}

	};
}