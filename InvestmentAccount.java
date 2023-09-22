public class InvestmentAccount extends EarningsAccount {

    protected InvestmentPlan investmentPlan;

    public InvestmentAccount(int id, double balance, String name, int age,
                             boolean zakatDeduction, FilerStatus filerStatus, InvestmentPlan investmentPlan,
                             int year, String countryName) {
        super(id, balance, name, age, zakatDeduction, filerStatus, year, countryName);
        this.investmentPlan = investmentPlan;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        double tax = amount * 0.04;
        setBalance(getBalance() - tax);
    }

    @Override
    public double totalEarnings() {
        double profit = getBalance();
        for (int i = 0; i < investmentPlan.getYear(); i++) {
            profit += profit * investmentPlan.getProfitRatio();
        }
        profit -= getBalance();
        profit -= deductTax(profit);
        return profit;
    }

    @Override
    public double realProfitRatio() {
        double profit = totalEarnings();
        double tax = deductTax(profit);
        tax += calculateZakat();
        for (CountryInflationRate cir: InflationRateTest.countryInflationRates) {
            if(cir.getCountryName().equals(getCountryName()))
            {
                for (InflationRate ir: cir.inflationRates) {
                    if(ir.getYear() == getYear()){
                        tax += profit * ir.getInflationRate();
                    }
                }
            }
        }
        return (profit - tax) / 100;
    }
}
