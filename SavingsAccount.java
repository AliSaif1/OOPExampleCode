public class SavingsAccount extends EarningsAccount{

    protected Saver_Category saver_category;

    public SavingsAccount(int id, double balance, String name, int age,
                          boolean zakatDeduction, FilerStatus filerStatus,
                          int year, String countryName) {
        super(id, balance, name, age, zakatDeduction, filerStatus, year, countryName);
        setSaver_category();
    }

    public void setSaver_category(){
        if(getAge() < 35)
            saver_category = Saver_Category.YOUNG_SAVER;
        else if(getAge() >= 35 && getAge() < 50)
            saver_category = Saver_Category.ADULT_SAVER;
        else
            saver_category = Saver_Category.SENIOR_CITIZEN_SAVER;
    }

    @Override
    public double totalEarnings() {
        double profit = getBalance() * saver_category.getProfitRatio();
        profit -= deductTax(profit);
        return profit;
    }

    @Override
    public double realProfitRatio() {
        double profit = totalEarnings();
        double tax = deductTax(profit);
        tax += calculateZakat();
        for (CountryInflationRate countryInflationRate1: InflationRateTest.countryInflationRates) {
            if(countryInflationRate1.getCountryName().equals(getCountryName()))
            {
                for (InflationRate inflationRate : countryInflationRate1.inflationRates) {
                    if(inflationRate.getYear() == getYear()){
                        tax += profit * inflationRate.getInflationRate();
                    }
                }
            }
        }
        return (profit - tax) / 100;
    }
}
