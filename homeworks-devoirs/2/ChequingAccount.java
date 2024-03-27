/**
 * classe ChequingAccount
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
public class ChequingAccount extends BankAccount {
    private String accountId;

    public ChequingAccount(char[] bankInstitution, String transit, Person owner, String shortAccountNumber) {
        super(owner);
        this.accountId = transit + bankInstitution[0] + bankInstitution[1] + bankInstitution[2] + shortAccountNumber;
    }

    public ChequingAccount(char[] bankInstitution, String transit, Person owner) {
        this(bankInstitution, transit, owner, String.valueOf(Bank.getNextAccountNumber()));
        int checkDigit = Utils.generateRandomEvenNumber();
        accountId += String.valueOf(checkDigit);
    }

    public String getId() {
        return this.accountId;
    }

    public String getMetadata() {
        return "[chequing]";
    }

}