/**
 * classe  ChequingAccount
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/08/2024
 */
public class ChequingAccount extends BankAccount { // TODO
    private String accountId;

    //TODO
    public ChequingAccount(char[] bankInstitution, String transit, Person owner, String shortAccountNumber) {
        super(owner);
        accountId = String.valueOf(transit) + String.valueOf(bankInstitution) + shortAccountNumber;
    }

    public ChequingAccount(char[] bankInstitution, String transit, Person owner) {
        this(bankInstitution, transit, owner, String.valueOf(Bank.getNextAccountNumber()));
        int checkDigit = Utils.generateRandomEvenNumber();
        accountId += String.valueOf(checkDigit);
    }

    //TODO
    @Override
    public String getId() {
        return accountId;
    }

    //TODO
    @Override
    public String getMetadata() {
        return "[chequing]";
    }
     
}