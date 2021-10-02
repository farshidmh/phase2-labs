package com.simplilearn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.simplilearn.model.User;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/adminLogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		Session se = HibernateUtil.getSessionFactory().openSession();

		CriteriaBuilder cb = se.getCriteriaBuilder();

		CriteriaQuery<User> cr = cb.createQuery(User.class);

		Root<User> root = cr.from(User.class);

		Predicate predicateForUserName = cb.equal(root.get("username"), userName);

		Predicate predicateForPassword = cb.equal(root.get("password"), password);

		Predicate predicateForUsernameAndPassword = cb.and(predicateForUserName, predicateForPassword);

		cr.where(predicateForUsernameAndPassword);


		List<User> users = se.createQuery(cr).getResultList();

		if( users.size()==1 ) {
			
			User tempUser = users.get(0);
					
			HttpSession loginSession = request.getSession();
			
			loginSession.setAttribute("logged", true);
			loginSession.setAttribute("userId", tempUser.getUserId());		
			
			response.sendRedirect("admin/list_product.jsp");				
			
		}else {
			response.sendRedirect("login.jsp?error=1");		
		}
	

	}

}
