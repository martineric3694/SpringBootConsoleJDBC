package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Employees;
import util.Connector;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	Connector conn;
	@Autowired
	Employees emp;
	
	@Override
	public List<Employees> getAll() {
		// TODO Auto-generated method stub
		List<Employees> result = new ArrayList<Employees>();
		Connection con = conn.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT employee_id, first_name, last_name FROM employees";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Employees model = new Employees();
				model.setEmployeeId(rs.getInt(1));
				model.setFirstName(rs.getString(2));
				model.setLastName(rs.getString(3));
				
				result.add(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
//		System.out.println(conn.getConnection());
//		
//		emp.setEmployeeId(100);
//		emp.setFirstName("Steven");
//		emp.setLastName("King");
//		
//		System.out.println(emp.getEmployeeId()+"."+emp.getFirstName()+" "+emp.getLastName());
//		return "Call EmployeeDaoImpl";
	}

	
}
