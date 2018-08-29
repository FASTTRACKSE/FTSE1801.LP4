
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class phuongtrinhbac2
 */
public class phuongtrinhbac2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public phuongtrinhbac2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kQ = "";
		double a = Double.parseDouble(request.getParameter("soA"));
		double b = Double.parseDouble(request.getParameter("soB"));
		double c = Double.parseDouble(request.getParameter("soC"));
		double delta;
		if (request.getParameter("soA").equals("") && request.getParameter("soB").equals("")
				&& request.getParameter("soC").equals("")) {
			kQ = "- Không được để trống.!!";
		} else if (!request.getParameter("soA").matches("//d*") && !request.getParameter("soB").matches("//d*")
				&& !request.getParameter("soC").matches("//d*")) {
			kQ = "- Chỉ được nhập số.!!";
		} else {

			if (a == 0) {
				if (b == 0) {
					if (c == 0) {
						kQ = "- Phương trình có vô số nghiệm.";
					} else {
						kQ = "- Phương trình vô nghiệm.";
					}
				} else {
					double x1 = -b / a;
					kQ = "- Phương trình có nghiệm là x: " + x1;
				}
			} else {
				delta = Math.pow(b, 2) - 4 * a * c;
				if (delta < 0) {
					kQ = "- Phương trình vô nghiệm.";
				} else if (delta == 0) {
					double x2 = -b / (2 * a);

					kQ = "- Phương trình có nghiệm kép x= " + x2;
				} else {
					double x3 = (-b + Math.sqrt(delta)) / (2 * a);

					double x4 = (-b - Math.sqrt(delta)) / (2 * a);

					kQ = "Phương trình có 2 nghiệm phân biệt x1 =" + x3 + " và x2 = " + x4;
				}

			}
		}
		request.setAttribute("ketQua", kQ);
		request.getRequestDispatcher("phuongtrinhbac2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
