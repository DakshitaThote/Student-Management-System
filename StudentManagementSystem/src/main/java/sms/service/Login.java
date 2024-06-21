package sms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sms.persistance.DatabaseConnection;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Preventing from back after logout.
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		String dbUser =null;
		String dbPass =null;
		try {
			Connection conn = DatabaseConnection.DbConnection();
			PreparedStatement statement = conn.prepareStatement("select username, password from admin where username = ? and password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				dbUser = resultSet.getString(1);
				dbPass = resultSet.getString(2);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		if(username.equals(dbUser) && password.equals(dbPass)) {
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("password", password);
			response.sendRedirect("dashboard.jsp");
		}else {
			request.setAttribute("invalidCredential", "Invalid username or password!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
