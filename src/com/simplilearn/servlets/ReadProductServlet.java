package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadProductServlet
 */
@WebServlet("/read-product")
public class ReadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		pw.println("<html><body<h1> Product List :- </h1>");
		pw.println("<style> table, td, th {border:2px solid red;} </style>");

		// STEP 1: Gets SessionFactory object
		SessionFactory sf = HibernateUtil.buildSessionFactory();

		// STEP 2: Get session object
		Session session = sf.openSession();

		// STEP 3: Execute Query
		List<EProduct> products = session.createQuery(" from EProduct").list();

		pw.println("<table>");

		pw.println("<tr>");
		pw.println("<th>Product Id</th>");
		pw.println("<th>Product Name</th>");
		pw.println("<th>Product Price</th>");
		pw.println("</tr>");

		for (EProduct product : products) {
			pw.println("<tr>");
			pw.println("<td>" + product.getId() + "</td>");
			pw.println("<td>" + product.getName() + "</td>");
			pw.println("<td>" + product.getPrice() + "</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
