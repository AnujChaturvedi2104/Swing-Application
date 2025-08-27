package com.version.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnection implements DataBaseConnection {

	
	@Override
	public void addUser(String name, String username, String password) {
		 String sql = "Insert into users values(?,?,?);";
		try (Connection con = DriverManager
				  .getConnection("jdbc:mysql://localhost:3306/swing", "root", "Anuj1234");
				PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, name);
				stmt.setString(2, username);
				stmt.setString(3, password);
				int executed = stmt.executeUpdate();
				if(executed > 0) {
					System.out.println("Insertion Complete!");
				}else {
					System.out.println("Failed!");
				}
				    
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
	}

	@Override
	public User getDetails(String username, String password) {
		 
		return null;
	}

	@Override
	public User updateExistingUser(User user) {
		
		return null;
	}

	@Override
	public void delete(String username, String password) {
	 
		
	}

}
