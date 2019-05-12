package com.montecarlo.calculator;

/**
 * Created by spatil2 on 5/12/19.
 */

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Random;

public class MonteCarloCalculator {
    private Random r = new Random();

    public HashMap<String,Double> calculate(double investment,int years,int simulations,  double mean,
                                                double stdDev,double inflation) {
        double[] returns_predictions = new double[simulations];
        for (int i = 0; i < simulations; i++) {
            double returns = investment;
            for (int j = 0; j < years; j++) {
                returns = returns * (1 + generateRandomNumber(mean, stdDev)) * (1 - inflation);
            }
            returns_predictions[i] = returns;
        }

        DescriptiveStatistics ds = new DescriptiveStatistics(returns_predictions);

        double median = ds.getPercentile(50);
        double bestCase = ds.getPercentile(90);
        double worstCase = ds.getPercentile(10);



        HashMap<String,Double> predictions=new HashMap<String,Double>();
        predictions.put("bestCase",bestCase);
        predictions.put("median",median);
        predictions.put("worstCase",worstCase);


        return predictions;

    }

    public double generateRandomNumber(double mean, double stdDev) {
        double nextGaussian = r.nextGaussian();
        double randomNumber = nextGaussian * stdDev + mean;
        return randomNumber;
    }
}