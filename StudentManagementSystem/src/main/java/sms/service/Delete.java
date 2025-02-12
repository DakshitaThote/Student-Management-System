package sms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sms.persistance.DatabaseConnection;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ids = Integer.parseInt(request.getParameter("id"));
		try {
			Connection connect = DatabaseConnection.DbConnection();
			PreparedStatement stmt = connect.prepareStatement("delete from students where id = ?");
			stmt.setInt(1, ids);
			int success = stmt.executeUpdate();
			if(success > 0) {
				System.out.println("Student deleted successfully..");
				HttpSession session = request.getSession();
				session.setAttribute("deleteSuccess", "success");
				response.sendRedirect("dashboard.jsp");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
