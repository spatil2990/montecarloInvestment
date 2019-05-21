package com.portfolio.montecarlo.results;

/**
 * Created by spatil2 on 5/20/19.
 */
public class PortfolioReturns {
    private double median;
    private double best;
    private double worst;

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getBest() {
        return best;
    }

    public void setBest(double best) {
        this.best = best;
    }

    public double getWorst() {
        return worst;
    }

    public void setWorst(double worst) {
        this.worst = worst;
    }
}
