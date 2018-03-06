/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Albert Scheel Vandel
 */
public class DBConnector
{
    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     *
     */
    public DBConnector() {
    }

    /**
     *
     * @param dataSource
     */
    public DBConnector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     *
     * @return
     */
    public Connection getConnection()
    {
        return connection;
    }
    
    /**
     *
     * @throws SQLException
     */
    public void open() throws SQLException
    {
        if(connection == null || connection.isClosed())
        {
            connection = dataSource.getConnection();
        }
    }
    
    /**
     *
     * @throws SQLException
     */
    public void close() throws SQLException
    {
        if(resultSet != null)
        {
            resultSet.close();
        }
        
        if(statement != null)
        {
            statement.close();
        }
        
        if(connection != null && !connection.isClosed())
        {
            connection.close();
            connection = null;
        }
    }
    
    /**
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet query(String sql) throws SQLException
    {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        
        return resultSet;
    }
    
    /**
     *
     * @param sql
     * @throws SQLException
     */
    public void change(String sql) throws SQLException
    {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
