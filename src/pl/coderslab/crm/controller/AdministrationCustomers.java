package pl.coderslab.crm.controller;

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
 * Servlet implementation class AdministrationCustomers
 */
@WebServlet("/administration-customers")
public class AdministrationCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrationCustomers() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao cDao = new CustomerDao();
		try {
			Connection c = DbUtil.getConn();
			request.setAttribute("customers", (cDao.loadAllCustomer(c)));
			getServletContext().getRequestDispatcher("/WEB-INF/views/customer/administration-customers.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
