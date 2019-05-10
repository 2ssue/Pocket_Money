import java.util.Iterator;
import java.util.List;

public class Account {
	private List<MoneyTransaction> account;
	private int nBalance;
	private int nLimit;
	private String sAccountName;
	
	public Account(String accountName, int balance) {
		this.setBalance(balance);
		this.sAccountName = accountName;
	}
	public String getAccountName() {
		return sAccountName;
	}
	public void addTransaction(MoneyTransaction transaction) {
		account.add(transaction);
		System.out.println(sAccountName +"의 현재 총액은 " + nBalance + "입니다.");
	}
	public void deleteAllTransaction() {
		account.removeAll(account);
	}
	public Iterator<MoneyTransaction> iteratorTransaction(){
		return account.iterator();
	}
	public int getBalance() {
		return nBalance;
	}
	public void setBalance(int balance) {
		this.nBalance = balance;
	}
	public int getLimit() {
		return nLimit;
	}
	public void setLimit(int limit) {
		this.nLimit = limit;
	}
}
