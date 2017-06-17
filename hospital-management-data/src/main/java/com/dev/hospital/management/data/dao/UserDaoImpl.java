package com.dev.hospital.management.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.utils.DBConfig;

/**
 * @author dayanlazare
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String username, String password) {
		String query = "Select id, firstname, lastname, email, date_of_birth, username From user Where username = ? and password = ?";
		User user = null;
		try(Connection connection = DBConfig.getInstance().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query)) {
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = this.createUser(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	private User createUser(ResultSet rs) {
		User user = null;
		try {
			Long id = rs.getLong("id");
			String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String email = rs.getString("email");
			Date dateOfBirth = rs.getDate("date_of_birth");
			String dbUsername = rs.getString("username");
			
			user = new User(firstname, lastname, email, dateOfBirth, dbUsername, null);
			user.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
