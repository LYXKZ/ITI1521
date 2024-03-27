interface IFinanceTransaction {
    Double credit(long transactionId, Double amount);
    Double debit(long transactionId, Double amount);
}