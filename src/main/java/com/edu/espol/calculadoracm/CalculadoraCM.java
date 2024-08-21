/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edu.espol.calculadoracm;

/**
 *
 * @author hailiejimenez
 */
public class CalculadoraCM {

    public static void main(String[] args) {

        String question = Operations.MakeFormula();
        System.out.println(question);
        String ret = Operations.Solve(question);
        System.out.println(ret);
    }
}
