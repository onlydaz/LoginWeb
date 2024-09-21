package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionSQLSever {
    private final String serverName = "LAPTOP-DA8RJKG7";
    private final String dbName = "ltwebst2";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "113300";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
}
