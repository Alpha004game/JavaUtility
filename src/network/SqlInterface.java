package network;

import java.sql.*;

public class SqlInterface {

    private Connection db;
    private Statement statement;

    private String address;
    private String username;
    private String password;

    public SqlInterface(String address, String username, String password) {
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public boolean connect()
    {
        try {
            db= DriverManager.getConnection(address, username, password);
            statement=db.createStatement();
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    public ResultSet query(String query)
    {
        //if(query.startsWith("SELECT") || query.startsWith("select"))

        try {
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            return null;
        }
    }



}
