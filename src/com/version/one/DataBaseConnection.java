package com.version.one;

public interface DataBaseConnection {
	void addUser(String name, String username, String password);
	boolean checkCredentials(String username, String password);
 
}
