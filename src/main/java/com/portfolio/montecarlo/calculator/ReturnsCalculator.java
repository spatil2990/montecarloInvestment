package com.portfolio.montecarlo.calculator;

/**
 * Created by spatil2 on 5/12/19.
 */

import com.portfolio.montecarlo.results.PortfolioReturns;
import com.portfolio.montecarlo.settings.PortfolioSettings;
import com.portfolio.montecarlo.util.UtilityFunctions;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReturnsCalculator {


    private static final Logger logger = LoggerFactory.getLogger(ReturnsCalculator.class);

    public PortfolioReturns calculate(PortfolioSettings settings) {

        PortfolioReturns results=new PortfolioReturns();

        if(settings!=null) {

            try {
                int simulations = settings.getSimulations();
                double[] returns_predictions = new double[simulations];
                for (int i = 0; i < simulations; i++) {
                    double returns = settings.getInvestment();
                    for (int j = 0; j < settings.getYears(); j++) {
                        returns = returns * (1 + UtilityFunctions.generateRandomNumber(settings.getMean(),
                                settings.getStdDev())) * (1 - settings.getInflation());
                    }
                    returns_predictions[i] = returns;
                }

                DescriptiveStatistics ds = new DescriptiveStatistics(returns_predictions);

                results.setMedian(ds.getPercentile(50));
                results.setBest(ds.getPercentile(90));
                results.setWorst(ds.getPercentile(10));
            } catch (ArithmeticException ae) {
                logger.error("Error calculating the portfolio"+ ae.getMessage());
            } catch (Exception e) {
                logger.error("Error calculating the portfolio"+e.getMessage());
            }
        } else {
            logger.info("Portfolio settings are null please provide all parameters");
        }

        return results;

    }


}