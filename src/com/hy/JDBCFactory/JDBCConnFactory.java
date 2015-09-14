package com.hy.JDBCFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnFactory implements JDBCFactory{
	private static ThreadLocal<Connection> holder = new ThreadLocal<Connection>(){
		protected Connection initialValue() {
			Connection conn = null;
			try {
				conn =  DriverManager.getConnection(getURL(),getName(),getPassword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	};
	private String path;
	private  static String Name;
	public static String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public static String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public static String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	private static String Password;
	private static String URL;	
	public JDBCConnFactory(final String path){
		this.path = path;
		init();
	}
	private void init() {
		Properties pro = new Properties();
		try {
			pro.load(ClassLoader.getSystemResourceAsStream(path));
			setURL(pro.getProperty(HY_URL)==null?null:pro.getProperty(HY_URL));
			setName(pro.getProperty(HY_USER)==null?HY_DEFAULT_USER:pro.getProperty(HY_USER));
			setPassword(pro.getProperty(HY_PASSWORD)==null?HY_DEFAULT_PASSWORD:pro.getProperty(HY_PASSWORD));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Connection getConnection() {
		return holder.get();
	}
}
