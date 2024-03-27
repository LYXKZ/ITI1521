public class Transaction {

    public enum TransactionType {
        DEPOT_ATM,
        WIDTHRAW_ATM,
        INTERAC,
        E_INTERAC,
        TRANSFER,
        CANCEL,
        UNDEFINED
    };

    long transactionId;
    TransactionType transactionType;
    double amount;
    String specialNotes;

    public Transaction(long transactionId, TransactionType transactionType, double amount, String specialNotes) {
        this.transactionId = transactionId;
        this.specialNotes = specialNotes;
        this.amount = amount;
        this.transactionType= transactionType;
    }

    public Transaction(long transactionId, double amount, String specialNotes) {
        this (transactionId, TransactionType.UNDEFINED, amount, specialNotes);
    }

    public TransactionType getTransactionType(){
        return this.transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}