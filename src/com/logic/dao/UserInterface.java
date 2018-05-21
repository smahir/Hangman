package com.logic.dao;

import java.sql.SQLException;
import com.logic.dto.User;

public interface UserInterface {

	public User validateUser(String username, String password);

	public boolean register(User user) throws SQLException;
	

}