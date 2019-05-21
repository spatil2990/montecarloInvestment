package com.portfolio.montecarlo.application;

/**
 * Created by spatil2 on 5/10/19.
 */

import com.portfolio.montecarlo.calculator.ReturnsCalculator;
import com.portfolio.montecarlo.results.PortfolioReturns;
import com.portfolio.montecarlo.settings.PortfolioSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonteCarloApplication {


    private static final Logger logger = LoggerFactory.getLogger(MonteCarloApplication.class);

    public static void main(String args[]) {
        ReturnsCalculator monteCarlo = new ReturnsCalculator();

        PortfolioSettings aggreesive=new PortfolioSettings(100000,
                20,10000, 0.094324,0.15675,0.035);

        PortfolioReturns aggressivePortFolio = monteCarlo.calculate(aggreesive);

        if(aggressivePortFolio!=null) {
            logger.info("*********Aggressive portfolio returns**********");
            logger.info("Median = " + aggressivePortFolio.getMedian());
            logger.info("Best Case = " + aggressivePortFolio.getBest());
            logger.info("Worst Case = " + aggressivePortFolio.getWorst());
        }


        PortfolioSettings conservative=new PortfolioSettings(100000,
                20, 10000,0.06189,0.063438,  0.035);

        PortfolioReturns conservativePortFolio = monteCarlo.calculate(conservative);

        if(aggressivePortFolio!=null) {
            logger.info("*********Conservative portfolio returns**********");
            logger.info("Median = " + conservativePortFolio.getMedian());
            logger.info("Best Case = " + conservativePortFolio.getBest());
            logger.info("Worst Case = " + conservativePortFolio.getWorst());
        }

    }
}
