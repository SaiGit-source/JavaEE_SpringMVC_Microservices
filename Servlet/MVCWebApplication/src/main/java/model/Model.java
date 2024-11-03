package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// this is a regular Java class

public class Model 
{
	private String name;
	private String password;
	private String email;
	private String city;
	
	private Connection connect=null;
	private PreparedStatement statement = null;
	int numRowsAffected;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	// logic to connect to database and register data
	// common operation we dont want to write repeatedly
	
	public int register()
	{
		try 
		{ // create these 2 variables above
			connect = JDBCUtilty.getDBConnection();
			String sql = "INSERT INTO personinfomvc (name, email, password, city) VALUES(?,?,?,?);";
			statement = connect.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2,  email);
			statement.setString(3,  password);
			statement.setString(4,  city);
			numRowsAffected=statement.executeUpdate();
			// return numRowsAffected;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JDBCUtilty.closeResource(connect, statement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return numRowsAffected;
	}
	
}
