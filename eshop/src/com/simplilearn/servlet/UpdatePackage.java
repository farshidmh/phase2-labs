package com.simplilearn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.model.Product;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class UpdatePackage
 */
@WebServlet("/UpdatePackage")
public class UpdatePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePackage() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("pName");
		double price = Double.parseDouble( request.getParameter("pPrice")  );
		int pid = Integer.parseInt(  request.getParameter("pid") );
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Transaction transaction = session.beginTransaction();
		
		
		
		Product product = session.load(Product.class, pid);
		
		product.setName(name);
		product.setPrice(price);
		
		
		session.save(product);
		
		
		
		
		
		transaction.commit();
		session.close();
		
		
		
		response.sendRedirect("list_product.jsp");
		
		
		
		
		
		
	}

}
