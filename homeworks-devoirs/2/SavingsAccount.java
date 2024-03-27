/**
 * classe SavingsAccount
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
public class SavingsAccount extends BankAccount {
    private String accountId;
    private Double interestRate;

    public SavingsAccount(char[] bankInstitution, String transit, Person owner, String shortAccountNumber,
            Double interestRate) {
        super(owner);
        this.accountId = transit + bankInstitution[0] + bankInstitution[1] + bankInstitution[2] + shortAccountNumber;
        this.interestRate = interestRate;
    }

    public SavingsAccount(char[] bankInstitution, String transit, Person owner, Double interestRate) {
        this(bankInstitution, transit, owner, String.valueOf(Bank.getNextAccountNumber()), interestRate);
        int checkDigit = (Utils.generateRandomEvenNumber() + 1) % 10;
        accountId += String.valueOf(checkDigit);
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getId() {
        return this.accountId;
    }

    public String getMetadata() {
        return "[saving, rate=" + this.interestRate + "]";
    }
}