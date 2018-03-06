/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author Albert Scheel Vandel
 */
public class DataSource1
{
    MysqlDataSource dataSource = new MysqlDataSource();
    
    /**
     *
     */
    public DataSource1()
    {
        dataSource.setServerName("127.0.0.1");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("windowprice");
        dataSource.setUser("root");
        dataSource.setPassword("albert");
    }
    
    /**
     *
     * @return
     */
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}