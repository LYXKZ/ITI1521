/**
 * classe Bank
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 */
public class Bank {
    private static long NEXT_ACCOUNT_NUMBER = 500001;
    private String name;
    private char[] institution;
    private Branch[] branches;

    public Bank(String name, char[] institution, Branch[] branches) {
        this.name = name;
        this.institution = institution;
        this.branches = branches;
    }

    public String getName() {
        return this.name;
    }

    public void configureBankAccount(BankAccount bankAccount, String transitNumber, boolean isNewAccount) { // To Verify
        for (Branch branch : this.branches) {
            if (branch.getTransitNumber().equals(transitNumber)) {
                if (isNewAccount) {
                    branch.recordBankAccount(bankAccount);
                } else {
                    branch.addBankAccount(bankAccount);
                }
            }
        }
    }

    public Double getDefaultInterestRate(String transitNUmber) {
        for (Branch branch : branches) {
            if (branch.getTransitNumber().equals(transitNUmber)) {
                return branch.getInterestRate();
            }
        }
        return 0.0;
    }

    public static long getNextAccountNumber() {
        return NEXT_ACCOUNT_NUMBER++;
    }

    public String toString() {
        String s = "Bank: " + this.name + ", Institution #: " + this.institution[0] + this.institution[1]
                + this.institution[2] + "\n*****************************\n";

        for (Branch branch : this.branches) {
            s += branch;
            s += "\n";
        }

        return s;

    }
}