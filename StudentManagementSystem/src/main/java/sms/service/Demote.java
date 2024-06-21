package sms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sms.persistance.DatabaseConnection;


@WebServlet("/Demote")
public class Demote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ids = Integer.parseInt(request.getParameter("id"));
		String dbGroup = null;
		try {
			Connection connect = DatabaseConnection.DbConnection();
			
			PreparedStatement getGrupName = connect.prepareStatement("select groupname from students where id = ?");
			getGrupName.setInt(1, ids);
			ResultSet rs = getGrupName.executeQuery();
			while(rs.next()) {
				dbGroup = rs.getString("groupname");
			}
			if(dbGroup.equals("Group 1")) {
				HttpSession session = request.getSession();
				session.setAttribute("firstBatchDemotion", "success");
				response.sendRedirect("dashboard.jsp");
			}else if(dbGroup.equals("Group 2")){
				PreparedStatement groupTwo = connect.prepareStatement("update students set groupname = ? where id = ?");
				groupTwo.setString(1, "Group 1");
				groupTwo.setInt(2, ids);
				int groupTwoDemotion = groupTwo.executeUpdate();
				if(groupTwoDemotion >0) {
					HttpSession session = request.getSession();
					session.setAttribute("secondBatchDemotion", "success");
					response.sendRedirect("dashboard.jsp");
				}
			}else if(dbGroup.equals("Group 3")) {
				PreparedStatement groupThree = connect.prepareStatement("update students set groupname = ? where id = ?");
				groupThree.setString(1, "Group 2");
				groupThree.setInt(2, ids);
				int groupThreeDemotion = groupThree.executeUpdate();
				if(groupThreeDemotion >0) {
					HttpSession session = request.getSession();
					session.setAttribute("thirdBatchDemotion", "success");
					response.sendRedirect("dashboard.jsp");
				}
			}else if(dbGroup.equals("Group 4")) {
				PreparedStatement groupFour = connect.prepareStatement("update students set groupname = ? where id = ?");
				groupFour.setString(1, "Group 3");
				groupFour.setInt(2, ids);
				int groupFourDemotion = groupFour.executeUpdate();
				if(groupFourDemotion >0) {
					HttpSession session = request.getSession();
					session.setAttribute("thirdBatchDemotion", "success");
					response.sendRedirect("dashboard.jsp");
				}
			}else if(dbGroup.equals("Group 5")) {
				PreparedStatement groupFive = connect.prepareStatement("update students set groupname = ? where id = ?");
				groupFive.setString(1, "Group 4");
				groupFive.setInt(2, ids);
				int groupFiveDemotion = groupFive.executeUpdate();
				if(groupFiveDemotion >0) {
					HttpSession session = request.getSession();
					session.setAttribute("thirdBatchDemotion", "success");
					response.sendRedirect("dashboard.jsp");
				}
			}else if(dbGroup.equals("Group 6")) {
				PreparedStatement groupSix = connect.prepareStatement("update students set groupname = ? where id = ?");
				groupSix.setString(1, "Group 5");
				groupSix.setInt(2, ids);
				int groupSixDemotion = groupSix.executeUpdate();
				if(groupSixDemotion >0) {
					HttpSession session = request.getSession();
					session.setAttribute("thirdBatchDemotion", "success");
					response.sendRedirect("dashboard.jsp");
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
