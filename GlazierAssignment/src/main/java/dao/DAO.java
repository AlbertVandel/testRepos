/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import dbconnector.DBConnector;
import java.math.BigDecimal;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Albert Scheel Vandel
 */
public class DAO implements DAOInterface {

    private DBConnector dbc = new DBConnector();

    /**
     *
     * @param ds
     */
    public DAO(DataSource ds) {
        dbc.setDataSource(ds);
    }

    /**
     * Returns the price of the window.
     * 
     * @param category The category(FRAME or GLASS).
     * @param ptype The type of FRAME or GLASS.
     * @return The price of the window.
     */
    @Override
    public BigDecimal getPrice(String category, String ptype) {
        BigDecimal price = null;

        try {
            dbc.open();

            String sql = "select * from price where category ='" + category + "' and ptype = '" + ptype + "'";
            ResultSet resultset = dbc.query(sql);

            if (resultset.next()) {
                price = resultset.getBigDecimal("price");
            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }

    /**
     * Returns The type of FRAME or GLASS.
     * 
     * @param category The category(FRAME or GLASS).
     * @return The type of FRAME or GLASS.
     */
    @Override
    public ArrayList<String> getTypes(String category){
        ArrayList<String> types = new ArrayList();
        try {
            dbc.open();

            String sql = "select * from price where category ='" + category  + "'";
            ResultSet resultset = dbc.query(sql);

            while (resultset.next()) {
                types.add(resultset.getString("ptype"));
            }
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;
    }    

}

