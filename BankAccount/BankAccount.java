
public class BankAccount {
    private double saving = 0.0;
    private double checking = 0.0;
    public static int accountsCreated = 0;
    private static Double totalMoney = 0.0;

    public BankAccount() {
        double checking = 0.0;
        double saving = 0.0;
        accountsCreated += 1;
        System.out.println("Total accounts created: " + accountsCreated + ".");
    }

    public double getCheckingBalance() {
        return checking;
    }

    public double getSavingsBalance() {
        return saving;
    }

    public void setCheckingBalance(double checking) {
        this.checking = checking;
    }

    public void setSavingsBalance(double saving) {
        this.saving = saving;
    }

    public void accountDeposit(String type, double depositAmount) {
        if (type == "checking" || type == "Checking") {
            setCheckingBalance(getCheckingBalance() + depositAmount);
            totalMoney += depositAmount;
            System.out.println("Successfully deposited " + depositAmount);
        }
        if (type == "saving" || type == "Saving") {
            setSavingsBalance(getSavingsBalance() + depositAmount);
            totalMoney += depositAmount;
            System.out.println("Successfully deposited " + depositAmount);
        }
    }

    public void accountWithdrawal(String type, double withdrawalAmount) {
        if (type == "checking" || type == "Checking") {
            if (getCheckingBalance() < withdrawalAmount) {
                System.out.println("Insufficient Funds!");
            } else {
                setCheckingBalance(getCheckingBalance() - withdrawalAmount);
                totalMoney -= withdrawalAmount;
                System.out.println("You have withdrawal" + withdrawalAmount);
            }
        }
        if (type == "saving" || type == "Saving") {
            if (getSavingsBalance() < withdrawalAmount) {
                System.out.println("Insufficient Funds!");
            } else {
                setSavingsBalance(getSavingsBalance() - withdrawalAmount);
                totalMoney -= withdrawalAmount;
                System.out.println("You have withdrawal" + withdrawalAmount);
            }
        }
    }

    public double myBalance() {
        double totalBalance = checking + saving;
        System.out.println(totalBalance);
        return totalBalance;
    }
}
