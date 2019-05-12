package com.montecarlo.calculator;

/**
 * Created by spatil2 on 5/10/19.
 */

import java.util.HashMap;

public class MonteCarloApplication {


    public static void main(String args[]) {
        MonteCarloCalculator monteCarlo = new MonteCarloCalculator();

        HashMap<String,Double> aggressivePortFolio = monteCarlo.calculate(100000,
                20,10000, 0.094324,0.15675,0.035);

        System.out.println("*********Aggressive portfolio returns**********");
        System.out.println("Median = " + aggressivePortFolio.get("median"));
        System.out.println("Best Case = " + aggressivePortFolio.get("bestCase"));
        System.out.println("Worst Case = " + aggressivePortFolio.get("worstCase"));



        HashMap<String,Double> conservativePortFolio = monteCarlo.calculate(100000,
                20, 10000,0.06189,0.063438,  0.035);

        System.out.println("*********Conservative portfolio returns**********");
        System.out.println("Median = " + conservativePortFolio.get("median"));
        System.out.println("Best Case = " + conservativePortFolio.get("bestCase"));
        System.out.println("Worst Case = " + conservativePortFolio.get("worstCase"));

    }
}
