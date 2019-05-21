package com.portfolio.montecarlo.settings;

/**
 * Created by spatil2 on 5/20/19.
 */
public class PortfolioSettings {
    private double investment;
    private int years;
    private int simulations;
    private double mean;
    private double stdDev;
    private double inflation;

    public PortfolioSettings(double investment,int years,int simulations,  double mean,
                             double stdDev,double inflation) {
        this.investment=investment;
        this.years=years;
        this.simulations=simulations;
        this.mean=mean;
        this.stdDev=stdDev;
        this.inflation=inflation;

    }

    public double getInvestment() {
        return investment;
    }

    public int getYears() {
        return years;
    }

    public int getSimulations() {
        return simulations;
    }

    public double getMean() {
        return mean;
    }

    public double getStdDev() {
        return stdDev;
    }

    public double getInflation() {
        return inflation;
    }
}
