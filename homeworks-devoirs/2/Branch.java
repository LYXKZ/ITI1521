/**
 * classe Branch
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 */
public class Branch {
    private String transitNUmber;
    private Double interestRate;
    private String address;
    private int currentNumberOfAccountTreated = 0;
    private Stack<BankAccount> existingBankAccounts;
    private Stack<BankAccount> newBankAccounts;

    public Branch(String transitNumber, Double InterestRate, String address) {
        this.transitNUmber = transitNumber;
        this.interestRate = InterestRate;
        this.address = address;
        this.existingBankAccounts = new ArrayStack<BankAccount>(1);
        this.newBankAccounts = new ArrayStack<BankAccount>(1);
    }

    public String getTransitNumber() {
        return this.transitNUmber;
    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public String getAddress() {
        return this.address;
    }

    public Stack<BankAccount> getNewBankAccounts() {
        return this.newBankAccounts;
    }

    public Stack<BankAccount> getExistingBankAccounts() {
        return this.newBankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount) {
        Stack<BankAccount> tempStack = new ArrayStack<>(1);
        boolean isFound = false;

        while (!existingBankAccounts.isEmpty()) {
            BankAccount selAccount = existingBankAccounts.pop();

            // if found
            if (selAccount.equals(bankAccount)) {
                existingBankAccounts.push(bankAccount);
                isFound = true;
                break;

            } else {
                tempStack.push(selAccount);
            }

        }

        while (!tempStack.isEmpty()) {
            existingBankAccounts.push(tempStack.pop());
        }

        if (!isFound) {
            existingBankAccounts.push(bankAccount);
            currentNumberOfAccountTreated++;
        }

    }

    public void recordBankAccount(BankAccount bankAccount) {
        newBankAccounts.push(bankAccount);
        currentNumberOfAccountTreated++;
    }

    public int getCurrentNumberOfAccountTreated() {
        return this.currentNumberOfAccountTreated;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("+ Branch-Succursale, Transit=" + this.transitNUmber);
        sb.append(" / " + this.address);
        sb.append(" / Comptes traités=" + this.currentNumberOfAccountTreated + "\n");
        sb.append("  - Nouveau(x) compte(s) crée(s): \n");
        sb.append(getStackBankAccountToString(this.newBankAccounts));
        sb.append("  - Compte(s) existant(s): \n");
        sb.append(getStackBankAccountToString(this.existingBankAccounts));
        return sb.toString();
    }

    private static StringBuffer getStackBankAccountToString(Stack<BankAccount> stackBankAccount) {
        StringBuffer sb = new StringBuffer();

        Stack<BankAccount> tempStack = new ArrayStack<BankAccount>(100);
        while (!stackBankAccount.isEmpty()) {
            BankAccount account = stackBankAccount.pop();
            sb.append("    " + account.toString());
            tempStack.push(account);
        }

        while (!tempStack.isEmpty()) {
            BankAccount account = tempStack.pop();
            stackBankAccount.push(account);
        }

        return sb;
    }
}