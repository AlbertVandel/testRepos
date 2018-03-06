/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricecalculation;

import dao.DAO;
import datasource.DataSource1;
import java.math.BigDecimal;

/**
 *
 * @author Albert Scheel Vandel
 */

public class PriceCalculation {

    DataSource1 ds = new DataSource1();
    DAO dao = new DAO(ds.getDataSource());
   
/**
 * Returns the price of the window where frame price is added to glass price.
 * 
 * @param height the height of the GLASS.
 * @param width The width of the GLASS.
 * @param type The type of FRAME.
 * @return The price of the window where frame price is added to glass price.
 * @throws java.lang.IllegalArgumentException when the height or width is less than 0.
 */
    public BigDecimal calculate(java.math.BigDecimal height, java.math.BigDecimal width, String type) throws java.lang.IllegalArgumentException {
        if (height.compareTo(new BigDecimal(0))<1) {
            throw new java.lang.IllegalArgumentException("Height must be more than 0");
        }
        if (width.compareTo(new BigDecimal(0))<1) {
            throw new java.lang.IllegalArgumentException("Width must be more than 0");
        }
        BigDecimal area = height.multiply(width);
        BigDecimal circumference = height.add(width).multiply(new BigDecimal(2));
        BigDecimal glassPrice = dao.getPrice("GLASS", "PLAIN").multiply(area);
        BigDecimal framePrice = dao.getPrice("FRAME", type).multiply(circumference);
        return glassPrice.add(framePrice);
    }
}
