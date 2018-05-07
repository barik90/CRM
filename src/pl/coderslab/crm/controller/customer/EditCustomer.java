package pl.coderslab.crm.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.crm.dao.CustomerDao;
import pl.coderslab.crm.model.Customer;
import pl.coderslab.crm.util.DbUtil;

/**
 * Servlet implementation class DeleteExercise
 */
@WebServlet("/customer/edit")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCustomer() {
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
		request.setAttribute("id", (id));
		getServletContext().getRequestDispatcher("/WEB-INF/views/customer/edit-customer-form.jsp").forward(request,
				response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		Customer customer = new Customer(id, name, surname, dateOfBirth);
		CustomerDao cDao = new CustomerDao();
		try {
			Connection c = DbUtil.getConn();
			cDao.saveToDB(c, customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
