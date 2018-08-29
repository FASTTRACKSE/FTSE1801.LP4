

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pheptinh
 */
public class pheptinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pheptinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double a = Double.parseDouble(request.getParameter("soA"));
		double b = Double.parseDouble(request.getParameter("soB"));
		String pheptinh = request.getParameter("pheptinh");
		double tinh = 0;
		String kQ = "";
		if(pheptinh.equals("+")) {
			 tinh= a+b;
			 kQ = String.valueOf(tinh);
			request.setAttribute("tinhtoan", kQ);
			request.getRequestDispatcher("phepcong.jsp").forward(request, response);
		}
		else if(pheptinh.equals("-")) {
			 tinh= a-b;
			 kQ = String.valueOf(tinh);
			request.setAttribute("tinhtoan", kQ);
			request.getRequestDispatcher("pheptru.jsp").forward(request, response);
		}else if(pheptinh.equals("*")) {
			 tinh= a*b;
			 kQ = String.valueOf(tinh);
			request.setAttribute("tinhtoan", kQ);
			request.getRequestDispatcher("phepnhan.jsp").forward(request, response);
		}else if(pheptinh.equals("/")) {
			 tinh= a/b;
			 kQ = String.valueOf(tinh);
			request.setAttribute("tinhtoan", kQ);
			request.getRequestDispatcher("phepchia.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
