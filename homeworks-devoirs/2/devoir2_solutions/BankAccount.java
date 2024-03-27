/**
 * classe abstraite BankAccount
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
abstract class BankAccount extends Account implements ITextMetadata{  //TODO
    protected double balance;

    public BankAccount(Person accountHolder) {
        this(accountHolder, 0.0);
    }

    public BankAccount(Person accountHolder, double balance) {
        super.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Détenteur/" + this.getAccountHolder() + "/AccountNumber:" + this.getId() + this.getMetadata() +  "/Balance: " + this.getBalance() + "\n");
        return sb.toString();
    }

    //TODO - 
    public boolean equals(BankAccount account) {
        boolean result = false;

        if (account!=null) {
            if (account.getId().equals(this.getId())) {
                result = true;
            }
        }

        return result;
    }
}