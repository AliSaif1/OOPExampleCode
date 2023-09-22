public abstract class EarningsAccount extends Account{

    protected FilerStatus filerStatus;
    public CountryInflationRate countryInflationRate = new CountryInflationRate();
    public InflationRate inflationRate = new InflationRate();
    private int year;
    private String countryName;

    public EarningsAccount(int id, double balance, String name, int age,
                           boolean zakatDeduction, FilerStatus filerStatus,
                           int year, String countryName){
        super(id, balance, name, age, zakatDeduction);
        this.filerStatus = filerStatus;
        setYear(year);
        setCountryName(countryName);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        double tax = amount * filerStatus.getWithDrawTax();
        setBalance(getBalance() - tax);
    }
    public double deductTax(double profit) {
        return profit * filerStatus.getCapitalGainTax();
    }

    public abstract double totalEarnings();
    public abstract double realProfitRatio();

    public void setYear(int year) {
        this.year = year;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getYear() {
        return year;
    }
    public String getCountryName() {
        return countryName;
    }
}
