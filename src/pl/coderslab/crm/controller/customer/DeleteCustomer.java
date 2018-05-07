package pl.coderslab.crm.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.util.DbUtil;

/**
 * Servlet implementation class DeleteExercise
 */
@WebServlet("/customer/delete")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCustomer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		CustomerDao cDao = new CustomerDao();
		try {
			Connection c = DbUtil.getConn();
			cDao.delete(c, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
