package com.simplilearn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.shop.Product;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		Session session  = HibernateUtil.getSessionFactory().openSession();
		
		
		try {
	

					Product product = session.load(Product.class, 3);
					
					
					System.out.println(product.getName() );
					System.out.println( product.getPrice() );
		
					
					product.setName("Tablet");
					product.setPrice(740.00);
					
					
					
					Transaction tr = session.beginTransaction();
					
					
					session.save(product);
					
					
					//session.delete(product);
					
					
					tr.commit();
					
					
					
		}catch (ObjectNotFoundException e) {
			

			System.out.println("No row found!");
			
			
			
		}
		
		
		
		
		
		
		
		
		session.close();
		
		
		
		
		
	}




}
