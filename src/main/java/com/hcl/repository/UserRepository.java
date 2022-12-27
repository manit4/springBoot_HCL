package com.hcl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hcl.db.DBConnection;
import com.hcl.to.User;

@Repository
public class UserRepository {

	public UserRepository() {
		System.out.println("inside UserRepository constr...");
	}

//	public void saveUser(String username, String password, String name, String email) {
//
//		try {
//
//			Connection conn = DBConnection.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");
//
//			statement.setString(1, username);
//			statement.setString(2, password);
//			statement.setString(3, name);
//			statement.setString(4, email);
//
//			statement.executeUpdate();
//
//		} catch (Exception e) {
//
//			System.out.println("inside catch of saveUser()...");
//
//			e.printStackTrace();
//		}
//	}

	public void saveUser(User user) {

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());
			statement.setString(4, user.getEmail());

			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("inside catch of saveUser()...");

			e.printStackTrace();
		}
	}

//	public String findUser(String username, String password) {
//		
//		String loginStatus = "Failed";
//		
//		try {
//
//			Connection conn = DBConnection.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement("select * from user where username = ? and password = ?");
//
//			statement.setString(1, username);
//			statement.setString(2, password);
//			
//			ResultSet set =  statement.executeQuery();
//			
//			if(set.next()) {
//				loginStatus = "Success";
//			}
//
//		} catch (Exception e) {
//
//			System.out.println("inside catch of findUser()...");
//
//			e.printStackTrace();
//		}
//		
//		return loginStatus;
//	}

	public User findUser(String username, String password) {

		User user = null;

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn
					.prepareStatement("select * from user where username = ? and password = ?");

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String uname = set.getString(1);
				String pwd = set.getString(2);
				String name = set.getString(3);
				String email = set.getString(4);

				user = new User(uname, pwd, name, email);
			}

		} catch (Exception e) {

			System.out.println("inside catch of findUser()...");

			e.printStackTrace();
		}

		return user;
	}

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();
		
		User user = null;

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn.prepareStatement("select * from user");

			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String uname = set.getString(1);
				String pwd = set.getString(2);
				String name = set.getString(3);
				String email = set.getString(4);

				user = new User(uname, pwd, name, email);
				users.add(user);
			}

		} catch (Exception e) {

			System.out.println("inside catch of findUser()...");

			e.printStackTrace();
		}
		return users;
	}
	
	public void deleteByUsername(String username) {
		
		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn.prepareStatement("delete from user where username = ?");
			
			statement.setString(1, username);
			
			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("inside catch of findUser()...");

			e.printStackTrace();
		}
	}
	
	public User findUser(String username) {

		User user = null;

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn
					.prepareStatement("select * from user where username = ?");

			statement.setString(1, username);

			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String uname = set.getString(1);
				String pwd = set.getString(2);
				String name = set.getString(3);
				String email = set.getString(4);

				user = new User(uname, pwd, name, email);
			}

		} catch (Exception e) {

			System.out.println("inside catch of findUser()...");

			e.printStackTrace();
		}

		return user;
	}
	
	public void update(User user) {
		
		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn.prepareStatement("update user set password = ?, name = ?, email = ? where username = ?");
			
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getUsername());
			
			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("inside catch of update()...");

			e.printStackTrace();
		}
	}
}
