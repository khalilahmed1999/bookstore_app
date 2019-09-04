package bookstore.model;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBuilder {

    public static Connection buildConnection(String user, String password) throws SQLException {
        OracleDataSource ods = new OracleDataSource();

        ods.setURL("jdbc:oracle:thin:" + user + "/" + password + "@localhost:1521/XE");

        return ods.getConnection();
    }
}