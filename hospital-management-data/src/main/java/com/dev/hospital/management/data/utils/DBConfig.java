/**
 * 
 */
package com.dev.hospital.management.data.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author dayanlazare
 *
 */
public class DBConfig {

	private String url = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user = "root";
	private String pwd = "root";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private static DBConfig dbConfig = null;
	
	private DBConfig(){
	}
	
	public static DBConfig getInstance() {
		if(dbConfig == null) {
			dbConfig = new DBConfig();
		}
		return dbConfig;
	}
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pwd);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}
