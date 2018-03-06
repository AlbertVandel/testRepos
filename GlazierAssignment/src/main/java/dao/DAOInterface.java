/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.math.BigDecimal;
import java.util.ArrayList;
/**
 *
 * @author Albert Scheel Vandel
 */
public interface DAOInterface {

    /**
     * Returns the price of the window.
     * 
     * @param category The category(FRAME or GLASS).
     * @param ptype The type of FRAME or GLASS.
     * @return The price of the window.
     */

    public BigDecimal getPrice(String category, String ptype);

    /**
     * Returns The type of FRAME or GLASS.
     * 
     * @param category The category(FRAME or GLASS).
     * @return The type of FRAME or GLASS.
     */
    public ArrayList<String> getTypes(String category);

}
