public class Account{

   private double balance;

   public Account() {
	    this.balance=0;
   }

   public double getBalance() {
     return balance;
   }

   public void deposit(double amount){
	    balance+=amount;
	     System.out.println("new balance=" + balance +"$");
   }

   public void withdraw(double amount){
	    if (balance < amount){
	       throw new NotEnoughMoneyException(amount, balance);
    	}

	    balance-=amount;
	    System.out.println("new balance=" + balance +"$");
    }
}
