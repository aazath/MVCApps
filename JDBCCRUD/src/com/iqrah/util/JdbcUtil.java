package com.iqrah.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException {
//		FileInputStream fis = new FileInputStream("D:\\Documents\\Aazath\\EnterpriseJava\\JDBCCRUD\\src\\com\\iqrah\\properties\\db.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//		String url = properties.getProperty("url");
//		String user = properties.getProperty("user");
//		String password = properties.getProperty("password");
		String url = "jdbc:mysql://localhost:3306/iqrah_students";
		String user = "root";
		String password = "";
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}

}
