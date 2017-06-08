package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import Object.Employee;
import Object.Employee.Gender;

@WebServlet("/listEmployee")
public class ListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
	ArrayList<Employee> list = new ArrayList<Employee>();
	Context context = null;		
	DataSource dataSource = null;		
	Connection conn = null;		
	try {			
		context = new InitialContext();		
		} catch (NamingException e) {
			e.printStackTrace();		
			}		
	try {			
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Employees");			
		conn = dataSource.getConnection();		
		} 
	catch (NamingException | SQLException e) {			
		e.printStackTrace();		
		}		
	try {			
		PreparedStatement ps = conn.prepareStatement("Select * from employees inner join dept_emp on employees.emp_no=dept_emp.emp_no where dept_no=? and employees.birth_date>?");
		ps.setString(1, request.getParameter("department"));			
		ps.setDate(2, Date.valueOf("1965-01-30"));
		ResultSet rs = ps.executeQuery();			
			while (rs.next()) {								
				list.add(new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4),						
					Gender.valueOf(rs.getString(5)), rs.getDate(6)));			
			}			
		rs.close();			
		ps.close();			
		conn.close();
		} 
	catch (SQLException e) {			
		e.printStackTrace();		
		}		
	request.setAttribute("list", list);		
	RequestDispatcher rd = request.getRequestDispatcher("/ListEmployees.jsp");		
	rd.forward(request, response);	
	}

}