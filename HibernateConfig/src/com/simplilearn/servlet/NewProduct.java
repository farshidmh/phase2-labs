package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.shop.Product;
import com.simplilearn.shop.ProductImage;
import com.simplilearn.shop.ProductImageMeta;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class NewProduct
 */
@WebServlet("/NewProduct")
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String name="Laptop";
			
			double price = 800;
			
			
			Product p1 = new Product(name,price);
			
			
			
			ProductImage img1 = new ProductImage("a.jpg",p1);
			
		
			img1.addImageMeta(new ProductImageMeta("height","200",img1));
			
			
			p1.addImage(img1);
			
			
			
						
			///SessionFactory factory = HibernateUtil.getSessionFactory();		
			//Session session  = factory.openSession();
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			
			Transaction trans = session.beginTransaction();
			
			
			session.save(p1);
			
			
			
			trans.commit();
			
			session.close();
			
			
			
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>  DONE! </body></html> ");


		
		
		
		
		
		
	}

	

	
}
