package bookstore.model;

import java.io.File;
//import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {

//    public static Connection buildConnection(String user, String password) throws SQLException {
//        OracleDataSource ods = new OracleDataSource();
//
//        ods.setURL("jdbc:oracle:thin:" + user + "/" + password + "@localhost:1521/XE");
//
//        return ods.getConnection();
//    }
	
	public static Connection buildConnection() throws SQLException {
		String dbPath = System.getProperty("user.dir") + File.separator + "db" + File.separator; 
		String url = "jdbc:sqlite:" + dbPath + "bookstore.db";
		
		Connection connection = DriverManager.getConnection(url);
		
		return connection;
	}
}