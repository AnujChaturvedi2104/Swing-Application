package com.version.one;

public interface DataBaseConnection {
	void addUser(String name, String username, String password);
	User getDetails(String username, String password);
	User updateExistingUser(User user);
	void delete(String username, String password);
}
