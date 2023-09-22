import java.util.ArrayList;
import java.util.Random;

public class AccountTest {

    public static void main(String[] args) {

        ArrayList<EarningsAccount> earningsAccounts = new ArrayList<>();

        earningsAccounts.add(0, new SavingsAccount(1, 206000, "Zoobia Ali",
                                                        21, false, FilerStatus.FILER,
                                                        2018, "Pakistan"));
        earningsAccounts.add(1, new InvestmentAccount(2, 1000, "Ali Saif",
                                                        22, true, FilerStatus.FILER,
                                                        InvestmentPlan.THREE_YEAR, 2018, "Japan"));
        earningsAccounts.add(2, new SavingsAccount(3, 564000, "Saif Ullah",
                                                        52, true, FilerStatus.FILER,
                                                        2019,"China"));
        earningsAccounts.add(3, new InvestmentAccount(4, 198000, "Zameer",
                                                        36, true, FilerStatus.NON_FILER,
                                                        InvestmentPlan.ONE_YEAR, 2018, "Lebanon"));
        earningsAccounts.add(4, new SavingsAccount(5, 56000, "Asad Saif",
                                                        25, false, FilerStatus.FILER,
                                                        2018, "Pakistan"));
        earningsAccounts.add(5, new InvestmentAccount(6, 2000, "Marium",
                                                        47, true, FilerStatus.FILER,
                                                        InvestmentPlan.FIVE_YEAR, 2018, "Turkey"));

        double profit;
        int reInvest;
        Random random = new Random();

        for (EarningsAccount earningsAccount : earningsAccounts) {
            profit = earningsAccount.totalEarnings();
            System.out.println("Total Earnings of " + earningsAccount.getName() + " = " + profit + " PKR");
            do{
                System.out.println("Press 1 to Re-invest :\nPress 2 if not to Re-invest : \n");
                reInvest = random.nextInt(1) + 1;
                if(reInvest == 1)
                    earningsAccount.deposit(profit);
            }while(reInvest != 0 && reInvest != 1);
        }

        System.out.println("\nTotal Profit Paid = " + Account.getTotalProfitPaid(earningsAccounts.toArray(new EarningsAccount[0])) + " PKR");
    }
}
