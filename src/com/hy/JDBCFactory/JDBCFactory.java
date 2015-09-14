package com.hy.JDBCFactory;

import java.sql.Connection;

public interface JDBCFactory {
	public static final String HY_USER="user";
	public static final String HY_DEFAULT_USER="root";
	public static final String HY_PASSWORD="password";
	public static final String HY_DEFAULT_PASSWORD="root";
	public static final String HY_URL="url";
	public static final int HY_MAX_SIZE=50;
	public static final int HY_MIN_SIZE=20;
	public static final long HY_TIME_OUT=6000;
	public Connection getConnection();
}
