package com.portfolio.montecarlo;

/**
 * Created by spatil2 on 5/20/19.
 */

import com.portfolio.montecarlo.calculator.ReturnsCalculator;
import com.portfolio.montecarlo.results.PortfolioReturns;
import com.portfolio.montecarlo.settings.PortfolioSettings;
import org.junit.Test;

public class MonteCarloTest {
    @Test
    public void testreturns() {
        ReturnsCalculator monteCarlo = new ReturnsCalculator();

        PortfolioSettings aggreesive=new PortfolioSettings(100000,
                20,10000, 0.094324,0.15675,0.035);

        PortfolioReturns aggressivePortFolio = monteCarlo.calculate(aggreesive);

        //Test if all possible returns are greater than investment
        assert(aggressivePortFolio.getBest()>100000);
        assert(aggressivePortFolio.getWorst()>100000);
        assert(aggressivePortFolio.getMedian()>100000);

    }

    @Test
    public void testReturnsComparision() {
        ReturnsCalculator monteCarlo = new ReturnsCalculator();

        PortfolioSettings aggreesive=new PortfolioSettings(100000,
                20,10000, 0.094324,0.15675,0.035);

        PortfolioReturns aggressivePortFolio = monteCarlo.calculate(aggreesive);

        //Compare relative returns Best > Median > worst
        assert(aggressivePortFolio.getBest()>aggressivePortFolio.getWorst());
        assert(aggressivePortFolio.getBest()>aggressivePortFolio.getMedian());
        assert(aggressivePortFolio.getMedian()>aggressivePortFolio.getWorst());
    }

    @Test
    public void testPortfolioComparisions() {
        ReturnsCalculator monteCarlo = new ReturnsCalculator();

        PortfolioSettings aggreesive=new PortfolioSettings(100000,
                20,10000, 0.094324,0.15675,0.035);

        PortfolioReturns aggressivePortFolio = monteCarlo.calculate(aggreesive);


        PortfolioSettings conservative=new PortfolioSettings(100000,
                20, 10000,0.06189,0.063438,  0.035);

        PortfolioReturns conservativePortFolio = monteCarlo.calculate(conservative);

        //Conservative worst returns should be better than aggressive worst returns
        assert(conservativePortFolio.getWorst()>aggressivePortFolio.getWorst());
    }
}
