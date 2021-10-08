package co.taejoon.prj.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSource() { // �ܺο��� ������ �� ������ private�� ������ ����

	}

	public static DataSource getInstance() {
		return dataSource;
	}

	private void dbconfig() { // �ܺ� properties ������ �о ���� �����Ѵ�
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		dbconfig();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn; // ������ Ŀ�ؼ� ��ü�� �����ش�
	}

}
