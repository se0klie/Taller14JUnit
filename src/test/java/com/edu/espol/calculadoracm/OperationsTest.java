/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.edu.espol.calculadoracm;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hailiejimenez
 */
public class OperationsTest {
    private static List<String> formulas;
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMakeFormula() {
        String formula = Operations.MakeFormula();
        // Verifica que la fórmula no esté vacía
        assertNotNull(formula);
        assertFalse(formula.isEmpty());
        // Verifica que la fórmula comience con un número y tenga la estructura correcta
        assertTrue(formula.matches("^\\d+(\\+|-|\\*|/)\\d+((\\+|-|\\*|/)\\d+)*$"));
    }
    
     @Test //FAILED
    public void testSolveAddition() {
        String formula;
        String result;
        //works multiple operations
        formula = "2+3";
        result = Operations.Solve(formula);
        assertEquals("2+3=5", result);
        
    }
    
    @Test //FAILED
    public void testSolveMultipleAdditions() {
        String formula = "2+3+4";
        String result = Operations.Solve(formula);
        assertEquals("2+3+4=9", result);
    }

    @Test //PASSED
    public void testSolveSimpleSubtraction() {
        String formula = "10-5";
        String result = Operations.Solve(formula);
        assertEquals("10-5=5", result);
    }

    @Test //FAILED
    public void testSolveMultipleSubtractions() {
        String formula = "10-3-2";
        String result = Operations.Solve(formula);
        assertEquals("10-3-2=5", result);
    }

    @Test //FAILED
    public void testSolveAdditionAndSubtraction() {
        String formula = "10+5-3";
        String result = Operations.Solve(formula);
        assertEquals("10+5-3=12", result);
    }

    @Test //FAILED
    public void testSolveSubtractionAndAddition() {
        String formula = "10-5+3";
        String result = Operations.Solve(formula);
        assertEquals("10-5+3=8", result);
    }

    @Test
    public void testSolveMultipleOperations() {
        String formula = "10+5-3+7-2";
        String result = Operations.Solve(formula);
        assertEquals("10+5-3+7-2=17", result);
    }

    // Edge Cases
    @Test
    public void testSolveNegativeResult() {
        String formula = "5-10";
        String result = Operations.Solve(formula);
        assertEquals("5-10=-5", result);
    }

    @Test
    public void testSolveZeroResult() {
        String formula = "5+5-10";
        String result = Operations.Solve(formula);
        assertEquals("5+5-10=0", result);
    }

    @Test
    public void testSolveAdditionToZero() {
        String formula = "0+5";
        String result = Operations.Solve(formula);
        assertEquals("0+5=5", result);
    }

    @Test
    public void testSolveSubtractionToZero() {
        String formula = "5-0";
        String result = Operations.Solve(formula);
        assertEquals("5-0=5", result);
    }

    // Large Numbers
    @Test
    public void testSolveLargeAddition() {
        String formula = "1000000+2000000";
        String result = Operations.Solve(formula);
        assertEquals("1000000+2000000=3000000", result);
    }

    @Test
    public void testSolveLargeSubtraction() {
        String formula = "1000000-500000";
        String result = Operations.Solve(formula);
        assertEquals("1000000-500000=500000", result);
    }

    // Cases with Negative Numbers
    @Test
    public void testSolveAdditionWithNegativeNumbers() {
        String formula = "-5+10";
        String result = Operations.Solve(formula);
        assertEquals("-5+10=5", result);
    }

    @Test
    public void testSolveSubtractionWithNegativeNumbers() {
        String formula = "-10-5";
        String result = Operations.Solve(formula);
        assertEquals("-10-5=-15", result);
    }

    @Test
    public void testSolveNegativeNumbersOnly() {
        String formula = "-5-10";
        String result = Operations.Solve(formula);
        assertEquals("-5-10=-15", result);
    }

    // Complex Cases
    @Test
    public void testSolveComplexAdditionSubtraction() {
        String formula = "5+10-3+7-10+2";
        String result = Operations.Solve(formula);
        assertEquals("5+10-3+7-10+2=11", result);
    }

    @Test
    public void testSolveComplexNegativeNumbers() {
        String formula = "-5+10-3-7+2";
        String result = Operations.Solve(formula);
        assertEquals("-5+10-3-7+2=-3", result);
    }
    
}
