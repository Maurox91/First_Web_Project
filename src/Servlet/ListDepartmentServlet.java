package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Object.Department;


@WebServlet("/listDepartment")
public class ListDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Department> list= new ArrayList<Department>();
		Context context=null;
		DataSource dataSource=null;
		Connection conn=null;
		
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		try {
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Employees");
			conn = dataSource.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
			while(rs.next()){
				list.add(new Department(rs.getString(1), rs.getString(2)));
			}
			rs.close();
            stmt.close();
            conn.close();
            
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/listaDipartimenti.jsp");
		rd.forward(request, response);
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("department"));
	}

	
}
