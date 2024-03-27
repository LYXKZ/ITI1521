/**
 * classe Bank
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 */
public class Bank {
    private static long NEXT_ACCOUNT_NUMBER = 500001;
    private String name;
    private char[] institution;
    private Branch[] branches;
 
    public Bank (String name, char[] institution, Branch[] branches) {
        this.name = name;
        this.institution = institution;
        this.branches = branches;
    }

    public String getName() {
        return this.name;
    }

    // TODO: to complete    
    public void configureBankAccount(BankAccount bankAccount, String transitNumber, boolean isNewAccount){
        for (int i=0; i<branches.length; i++) {
            if (branches[i].getTransitNumber().equals(transitNumber)) {
                if (isNewAccount) {
                    branches[i].addBankAccount(bankAccount);
                }
                else {
                    branches[i].recordBankAccount(bankAccount);
                }
                break;
            }
        }
    }

    public Double getDefaultInterestRate (String transitNUmber) {
        for (Branch branch : branches) {
            if (branch.getTransitNumber().equals(transitNUmber)) {
                return branch.getInterestRate();
            }
        }
        return 0.0;
    }

    public static long getNextAccountNumber () {
        return NEXT_ACCOUNT_NUMBER++;
    }

    //TODO
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Bank: " + this.name);
        sb.append(", Institution #: " + String.valueOf(this.institution) + "\n");
        sb.append("*****************************\n");
        for (Branch branch : branches) {
            sb.append("+ " + branch);
            sb.append("\n");
        }
        return sb.toString();
    }
}