/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import java.io.IOException;
import static java.lang.System.getenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;

/**
 *
 * @author cswor
 */
public class dbConnection {
        
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String DB_URL;
    private String USER;
    private String PASS;
    
    // remove opening multi-line comment and adjust vars for local connection
    public void setConnections() {
        this.setDB_URL("jdbc:mysql://localhost:3306/jsp");
        this.setUSER("root");
        this.setPASS("");
    }   //  */
    
    // remove opening multi-line comment for server connection
/*    public void setConnections() {
        String host = getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = getenv("OPENSHIFT_MYSQL_DB_PORT");
        this.setDB_URL("jdbc:mysql://" + host + ":" + port + "/jsp");
        this.setUSER("adminLGMn6AW");
        this.setPASS("Lhh3jeWDXKe1");
    }   //  */

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
    
}
