
public class MoneyTransaction {
	private int nMoney;
	private String sUseDate;
	private String sUsePlace;
	private int nCategory;
	private boolean bFixedCost;
	
	public int getMoney() {
		return nMoney;
	}
	public String getDate() {
		return sUseDate;
	}
	public String getPlace() {
		return sUsePlace;
	}
	public int getCategory() {
		return nCategory;
	}
	public boolean getFixed() {
		return bFixedCost;
	}
	public MoneyTransaction(int money, String useDate, String usePlace, int category, boolean fixedCost) {
		this.nMoney = money;
		this.sUseDate = useDate;
		this.sUsePlace = usePlace;
		this.nCategory = category;
		this.bFixedCost = fixedCost;
	}
}
