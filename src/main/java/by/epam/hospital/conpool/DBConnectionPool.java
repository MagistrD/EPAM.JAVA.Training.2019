package by.epam.hospital.conpool;

import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Connection pool
 */
public class DBConnectionPool {
//    private static String DRIVER_NAME = ConfigurationManager.get("mysql.driver");
    private static String DRIVER_NAME = ConfigurationManager.get("postgres.driver");
    private static DBConnectionPool instance;
    private static int clients;
    private String url, user, password;
    private int maxConn;
    private ArrayList<Connection> freeConnections = new ArrayList<Connection>();

    /**
     * DB Connection pool
     *
     * @param url      url of DB
     * @param user     user
     * @param password password
     * @param maxConn  maximum of connections
     */
    public DBConnectionPool(final String url, final String user, final String password, final int maxConn) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
        loadDrivers();
    }

    private void loadDrivers() {
        try {
            Driver driver = (Driver) Class.forName(DRIVER_NAME).newInstance();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
        }
    }

    /**
     * one connection pool
     *
     * @param url      url
     * @param user     user
     * @param password password
     * @param maxConn  max connection
     * @return instance
     */
    public static synchronized DBConnectionPool
    getInstance(final String url, final String user, final String password, final int maxConn) {
        if (instance == null) {
            instance = new DBConnectionPool(url, user, password, maxConn);
        }
        clients++;
        return instance;
    }

    /**
     * getting connection
     *
     * @return connection
     */
    public synchronized Connection getConnection() {
        Connection con = null;
        if (!freeConnections.isEmpty()) {
            con = (Connection) freeConnections.get(freeConnections.size() - 1);
            freeConnections.remove(con);
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
            } catch (Exception e) {
                con = getConnection();
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection() {
        Connection con = null;
        try {
            if (user == null) {
                con = DriverManager.getConnection(url);
            } else {
                con = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            return null;
        }
        return con;
    }

    /**
     * add free connection
     *
     * @param con connection
     */
    public synchronized void freeConnection(final Connection con) {
        if ((con != null) && (freeConnections.size() <= maxConn)) {
            freeConnections.add(con);
        }
    }

    /**
     * clear of free connections
     */
    public synchronized void release() {
        Iterator allConnections = freeConnections.iterator();
        while (allConnections.hasNext()) {
            Connection con = (Connection) allConnections.next();
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
        freeConnections.clear();
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        release();
    }
}
