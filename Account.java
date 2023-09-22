public class Account {

    private int id;
    private double balance;
    private String name;
    private int age;
    private boolean zakatApplicable;

    public Account(int id, double balance, String name,
                   int age, boolean zakatApplicable) {
        setId(id);
        setBalance(balance);
        setName(name);
        setAge(age);
        isZakatApplicable(zakatApplicable);
    }

    protected double calculateZakat(){
        double zakaat = 0.0;
        if(zakatApplicable)
            zakaat = getBalance() * 0.025;
        return zakaat;
    }

    protected void deductZakat(){
        setBalance(getBalance() - calculateZakat());
    }

    public static double getTotalProfitPaid(EarningsAccount... earningsAccounts){
        double totalProfit = 0;
        for(EarningsAccount earningsAccount : earningsAccounts){
            totalProfit += earningsAccount.totalEarnings();
        }
        return totalProfit;
    }

    public void withdraw(double amount){
        setBalance(getBalance() - amount);
    }
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    //BELOW ARE GETTERS AND SETTERS......
    //SETTERS ......
    protected void setId(int id) {
        if(id > 0)
            this.id = id;
        else
            System.out.println("Invalid Id : ");
    }
    protected void setBalance(double balance) {
        if(balance > 0) {
            this.balance = balance;
        }
        else
            System.out.println("Invalid Balance : ");
    }
    protected void setName(String name) {
        this.name = name;
    }
    protected void setAge(int age) {
        if(age > 0)
            this.age = age;
        else
            System.out.println("Invalid Age : ");
    }
    protected void isZakatApplicable(boolean zakatApplicable) {
        this.zakatApplicable = zakatApplicable;
    }

    //GETTERS .....
    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isZakatApplicable() {
        return zakatApplicable;
    }
}
