package com.portfolio.montecarlo.util;

import java.util.Random;

/**
 * Created by spatil2 on 5/20/19.
 */
public class UtilityFunctions {

    private static Random r = new Random();

    public static double generateRandomNumber(double mean, double stdDev) {
        double nextGaussian = r.nextGaussian();
        double randomNumber = nextGaussian * stdDev + mean;
        return randomNumber;
    }

}
