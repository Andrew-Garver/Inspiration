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
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String OS_MYSQL_DB_HOST = getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String OS_MYSQL_DB_PORT = getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String DB_URL = "jdbc:mysql://" + OS_MYSQL_DB_HOST + ":" + OS_MYSQL_DB_PORT + "/";

    //  Database credentials
    static final String USER = "adminLGMn6AW";
    static final String PASS = "Lhh3jeWDXKe1";
    
    private Statement stmt = null;
    private Connection conn = null;
    private ResultSet rs = null;

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public ResultSet selectQuery(String query) 
            throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
            this.setConn(DriverManager.getConnection(DB_URL, USER, PASS));
            this.setStmt(conn.createStatement());
            this.setRs(stmt.executeQuery(query));
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null)
                    stmt.close();
            } catch(SQLException se2) {
        }// nothing we can do
            try {
                if(conn != null)
                conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return this.rs;
    }
    
    public void insertOrDeleteQuery(String query) 
            throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
            this.setConn(DriverManager.getConnection(DB_URL, USER, PASS));
            this.setStmt(conn.createStatement());
            stmt.executeQuery(query);
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if(stmt != null)
                    stmt.close();
            } catch(SQLException se2) {
        }// nothing we can do
            try {
                if(conn != null)
                conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
    
}
