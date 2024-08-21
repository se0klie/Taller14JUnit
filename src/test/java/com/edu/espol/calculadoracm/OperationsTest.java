package com.edu.espol.calculadoracm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {
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

    @Test
    public void testSolveAddition() {
        String formula = "2+3";
        String result = Operations.Solve(formula);
        assertEquals("2+3=5", result);
    }

    @Test
    public void testSolveMultipleAdditions() {
        String formula = "2+3+4";
        String result = Operations.Solve(formula);
        assertEquals("2+3+4=9", result);
    }

    @Test
    public void testSolveSimpleSubtraction() {
        String formula = "10-5";
        String result = Operations.Solve(formula);
        assertEquals("10-5=5", result);
    }

    @Test
    public void testSolveMultipleSubtractions() {
        String formula = "10-3-2";
        String result = Operations.Solve(formula);
        assertEquals("10-3-2=5", result);
    }

    @Test
    public void testSolveAdditionAndSubtraction() {
        String formula = "10+5-3";
        String result = Operations.Solve(formula);
        assertEquals("10+5-3=12", result);
    }

    @Test
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

    // Additional Cases for Multiplication and Division
    @Test
    public void testSolveSimpleMultiplication() {
        String formula = "3*4";
        String result = Operations.Solve(formula);
        assertEquals("3*4=12", result);
    }

    @Test
    public void testSolveMultipleMultiplications() {
        String formula = "2*3*4";
        String result = Operations.Solve(formula);
        assertEquals("2*3*4=24", result);
    }

    @Test
    public void testSolveSimpleDivision() {
        String formula = "8/2";
        String result = Operations.Solve(formula);
        assertEquals("8/2=4", result);
    }

    @Test
    public void testSolveMultipleDivisions() {
        String formula = "24/2/2";
        String result = Operations.Solve(formula);
        assertEquals("24/2/2=6", result);
    }

    @Test
    public void testSolveCombinedOperations() {
        String formula = "10+2*6/3-4";
        String result = Operations.Solve(formula);
        assertEquals("10+2*6/3-4=10", result);
    }

    @Test
    public void testSolveComplexCombinedOperations() {
        String formula = "10+2*6-3/3+5*2";
        String result = Operations.Solve(formula);
        assertEquals("10+2*6-3/3+5*2=27", result);
    }

    @Test
    public void testSolveDivisionByZero() {
        String formula = "10/0";
        try {
            Operations.Solve(formula);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }
}