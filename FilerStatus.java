public enum FilerStatus {
    FILER(0.15, 0.02),
    NON_FILER(0.25, 0.04);
    protected double capitalGainTax;
    protected double withDrawTax;

    FilerStatus(double capitalGainTax, double withDrawTax) {
        this.capitalGainTax = capitalGainTax;
        this.withDrawTax = withDrawTax;
    }

    public double getCapitalGainTax() {
        return capitalGainTax;
    }
    public double getWithDrawTax() {
        return withDrawTax;
    }
}
