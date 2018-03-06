/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricecalculation;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Albert Scheel Vandel
 */
public class PriceCalculationTest {
    
    public PriceCalculationTest() {
    }

    /**
     * Test of calculate method, of class PriceCalculation.
     */
    
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        BigDecimal height = new BigDecimal(100);
        BigDecimal width = new BigDecimal(160);
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal expResult = new BigDecimal(1000.00);
        BigDecimal result = instance.calculate(height, width, type);
        assertTrue(expResult.compareTo(result) == 0);
    }

    @Test
    public void testLargeNumber() {
        System.out.println("calculate");
        BigDecimal height = new BigDecimal(1000000000);
        BigDecimal width = new BigDecimal(1000000000);
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal expResult = new BigDecimal(30000004000000000.00);
        BigDecimal result = instance.calculate(height, width, type);
        assertTrue(expResult.compareTo(result) == 0);
    }
    @Test
    public void testSmallNumber() {
        System.out.println("calculate");
        BigDecimal height = new BigDecimal(1);
        BigDecimal width = new BigDecimal(1);
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal expResult = new BigDecimal("4.03");
        BigDecimal result = instance.calculate(height, width, type);
        assertTrue(expResult.compareTo(result) == 0);
    }    

    @Test
    public void testDecimal() {
        System.out.println("calculate");
        BigDecimal height = new BigDecimal("100.1000");
        BigDecimal width = new BigDecimal("100.1000");
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal expResult = new BigDecimal("701.0003");
        BigDecimal result = instance.calculate(height, width, type);
        assertTrue(expResult.compareTo(result) == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        BigDecimal height = new BigDecimal(-100);
        BigDecimal width = new BigDecimal(-160);
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal result = instance.calculate(height, width, type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZero() {
        BigDecimal height = new BigDecimal(0);
        BigDecimal width = new BigDecimal(0);
        String type = "FRAMETYPE1";
        PriceCalculation instance = new PriceCalculation();
        BigDecimal result = instance.calculate(height, width, type);
    }
}
