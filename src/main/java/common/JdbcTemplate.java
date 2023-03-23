package common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemplate {
	private static String DRIVER = "";
	private static String URL = "";
	private static String DB_ID = "";
	private static String DB_PWD = "";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "config/dbconfig.properties";
		Properties prop = new Properties();
		Connection conn = null;
		try {
			InputStream is = JdbcTemplate.class.getClassLoader().getResourceAsStream(url);
			prop.load(is);

			DRIVER = prop.getProperty("driver");
			URL = prop.getProperty("url");
			DB_ID = prop.getProperty("db_id");
			DB_PWD = prop.getProperty("db_pwd");
			System.out.println(URL + " " + DB_ID + " " + DB_PWD);

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
