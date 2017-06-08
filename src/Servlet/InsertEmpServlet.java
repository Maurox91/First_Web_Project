package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/InsertEmployee")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	String id=request.getParameter("emp_no");
	Date birth=Date.valueOf(request.getParameter("birth_date"));
	String name=request.getParameter("first_name");		
	String surname=request.getParameter("last_name");		
	Gender gender=Gender.valueOf(request.getParameter("gender"));			
	Date hire=Date.valueOf(request.getParameter("hire_date"));		
	
	String nameDp=request.getParameter("nameDp");
	Date dataIns =Date.valueOf(request.getParameter("dataIns"));
		
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
		PreparedStatement ps = conn.prepareStatement("Insert into employees(emp_no, first_name, last_name, birth_date, hire_date, gender)"					
	    + " values(?, ?, ?, ?, ?, ?)");	
		
		PreparedStatement ps2= conn.prepareStatement("Insert into dept_emp(emp_no, dept_no, from_date) values(?, ?, ?)");
		
		ps.setString(1, id);			
		ps.setString(2, name);			
		ps.setString(3, surname);			
		ps.setDate(4,  birth);			
		ps.setDate(5, hire);			
		ps.setString(6, gender.toString());	
		
		ps2.setString(1, id);
		ps2.setString(2, nameDp);
		ps2.setDate(3, dataIns);
		
		ps.executeUpdate();
		ps2.executeUpdate();
		ps.close();			
		conn.close();		
		} 
	
	catch (SQLException e) {			
		e.printStackTrace();		
		}
	
	RequestDispatcher rd = request.getRequestDispatcher("/listDepartment");		
	rd.forward(request, response);			
	}
}