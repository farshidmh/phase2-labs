package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.simplilearn.shop.Product;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class GetAllProducts
 */
@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		//List<Product> products = session.createQuery("from Product where price>=200").list();
			
		
		//Criteria cr = session.createCriteria(Product.class);
		
		//cr.add(  Restrictions.ge("price",(double) 200) );
		
		//cr.add( Restrictions.like("name", "ph%") );
		
		//List<Product> products = cr.list()  ;
		
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
			
		Root<Product> root  = cr.from(Product.class);
		
		cr.select(root).where(   cb.ge(root.get("price") , (double) 200 )  );
		

		org.hibernate.Query<Product> query = session.createQuery(cr);
		
		List<Product> products = query.getResultList();

		
		
		for( Product p : products ) {
			
			out.println( p.getName()+" "+p.getPrice()+" "+p.getProductId() );
			
			
			out.println("<hr>");
			
			
			
		}
		
		
		
		
		
		
		session.close();
		
		
		out.println("</body></html>");
		
		
	}

	


}
