package com.hy.JDBCFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
public static void main(String[] args) {
	JDBCConnFactory jcf = new JDBCConnFactory("com\\hy\\JDBCFactory\\resource.properties");
	Connection con = jcf.getConnection();
	ResultSet rs = null;
	try {
		rs = con.prepareStatement("select * from card").executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("ID"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
