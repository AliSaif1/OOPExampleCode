public enum InvestmentPlan {
    ONE_YEAR(1, 0.10),
    THREE_YEAR(3, 0.12),
    FIVE_YEAR(5, 0.14);
    protected double profitRatio;
    protected int year;
    InvestmentPlan(int year, double profitRatio) {
        this.year = year;
        this.profitRatio = profitRatio;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
    public int getYear() {
        return year;
    }
}
