package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class LoaiAdminController
 */
@WebServlet("/LoaiAdminController")
public class LoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    loaibo loaiBo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String maloai = request.getParameter("txtmaloai");
			String tenLoai = request.getParameter("txttenloai");
			
			if (request.getParameter("butthem") != null) {
				int n = loaiBo.them(maloai, tenLoai);
				if (n == 0)
					request.setAttribute("ktnhap", 0);
			}
			if (request.getParameter("butsua") != null) {
				int n = loaiBo.Sua(maloai, tenLoai);
				if (n == 0)
					request.setAttribute("ktsua", 0);
			}
			if (request.getParameter("mlchon") != null) {
				loaibean l = loaiBo.chon(request.getParameter("mlchon"));
				request.setAttribute("chonloai", l);
			}

			if (request.getParameter("mlXoa") != null) {
				int n = loaiBo.Xoa(request.getParameter("mlXoa"));
				if (n == 0)
					request.setAttribute("ktxoa", 0);
			}

			request.setAttribute("dsloai", loaiBo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("LoaiAdmin.jsp");
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
