package com.version.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnection implements DataBaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/swing";
	private static final String user = "root";
	private static final String passwordDB = "Anuj1234";

	@Override
	public void addUser(String name, String username, String password) {
		String sql = "Insert into users values(?,?,?);";
		try (Connection con = DriverManager.getConnection(url, user, passwordDB);
				PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setString(2, username);
			stmt.setString(3, password);
			int executed = stmt.executeUpdate();
			if (executed > 0) {
				System.out.println("Insertion Complete!");
			} else {
				System.out.println("Failed!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean checkCredentials(String username, String password) {
		String sql = "Select * from users where username = ? and password = ?";
		try (Connection connection = DriverManager.getConnection(url, user, passwordDB);
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}  
			
			 

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		 
	}

}
