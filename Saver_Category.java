public enum Saver_Category{
    YOUNG_SAVER(0.06),
    ADULT_SAVER(0.07),
    SENIOR_CITIZEN_SAVER(0.08);

    protected double profitRatio;

    Saver_Category(double profitRatio) {
        this.profitRatio = profitRatio;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
